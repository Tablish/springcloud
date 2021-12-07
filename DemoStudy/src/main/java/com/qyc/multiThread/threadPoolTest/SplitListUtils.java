package com.qyc.multiThread.threadPoolTest;


import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.*;

public class SplitListUtils {


    /**
     * 拆分集合
     *
     * @param <T>           泛型对象
     * @param resList       需要拆分的集合
     * @param subListLength 每个子集合的元素个数
     * @return 返回拆分后的各个集合组成的列表
     * 代码里面用到了guava和common的结合工具类
     **/
    public static <T> List<List<T>> split(List<T> resList, int subListLength) {
        if (CollectionUtils.isEmpty(resList) || subListLength <= 0) {
            return new ArrayList<>();
        }
        List<List<T>> ret = new ArrayList<>();
        int size = resList.size();
        if (size <= subListLength) {
            // 数据量不足 subListLength 指定的大小
            ret.add(resList);
        } else {
            int pre = size / subListLength;
            int last = size % subListLength;
            // 前面pre个集合，每个大小都是 subListLength 个元素
            for (int i = 0; i < pre; i++) {
                List<T> itemList = new ArrayList<>();
                for (int j = 0; j < subListLength; j++) {
                    itemList.add(resList.get(i * subListLength + j));
                }
                ret.add(itemList);
            }
            // last的进行处理
            if (last > 0) {
                List<T> itemList = new ArrayList<>();
                for (int i = 0; i < last; i++) {
                    itemList.add(resList.get(pre * subListLength + i));
                }
                ret.add(itemList);
            }
        }
        return ret;

    }

    // 运行代码
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<String> list = new ArrayList<>();
//        int size = 1099;
//        for (int i = 0; i < size; i++) {
//            list.add("hello-" + i);
//        }
//        // 大集合里面包含多个小集合
//        List<List<String>> temps = split(list, 100);
//        int j = 0;
//        // 对大集合里面的每一个小集合进行操作
//        for (List<String> obj : temps) {
//            System.out.println(String.format("row:%s -> size:%s,data:%s", ++j, obj.size(), obj));
//        }

        SplitListUtils.threadMethod();
    }


    public static void threadMethod() throws ExecutionException, InterruptedException {
        List<String> totalList = new ArrayList<>();
        int size = 10000;
        for (int i = 0; i < size; i++) {
            totalList.add("hello-" + i);
        }
        System.out.println("================批量更新前的list================");
        //System.out.println(totalList);


        List<Object> updateList = new ArrayList();
        // 初始化线程池, 参数一定要一定要一定要调好！！！！
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(100, 200,
                4, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadPoolExecutor.AbortPolicy());
        // 大集合拆分成N个小集合, 这里集合的size可以稍微小一些（这里我用100刚刚好）, 以保证多线程异步执行, 过大容易回到单线程
        List<List<String>> splitNList = SplitListUtils.split(totalList, 100);
        // 记录单个任务的执行次数
        CountDownLatch countDownLatch = new CountDownLatch(splitNList.size());
        //全局变量
        //List<String> updateList1 = new ArrayList<>(10000);
        //List<String> updateList1= Collections.synchronizedList(new ArrayList<String>());
        //List<String> updateList1 = new Vector<>();
        //new  Copyonwritearraylist<>

        //每次add/set都要重新复制数组，用了可重入锁，总之性能不高，但是保证了安全性:
        // 适合读多写少的情况，我们需求中虽然用在了写中，但是数据少，理论上没啥问题
        CopyOnWriteArrayList<String> updateList1 = new CopyOnWriteArrayList<>();

        // 对拆分的集合进行批量处理, 先拆分的集合, 再多线程执行
        for (List<String> singleList : splitNList) {
            // 线程池执行
//            threadPool.execute(new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (String yangshiwen : singleList) {
//                        // 将每一个对象进行数据封装, 并添加到一个用于存储更新数据的list
//                        // ......
//                        updateList1.add(yangshiwen + "-" + Thread.currentThread().getName());
//                        // 任务个数 - 1, 直至为0时唤醒await()
//                        countDownLatch.countDown();
//                    }
//                }
//            }));


            Future<?> submit = threadPool.submit(new Thread(String.valueOf(new Callable<Object>() {
                @Override
                public Object call() {
                    for (String yangshiwen : singleList) {
                        // 将每一个对象进行数据封装, 并添加到一个用于存储更新数据的list
                        // ......
                        updateList1.add(yangshiwen + "-" + Thread.currentThread().getName());
                        // 任务个数 - 1, 直至为0时唤醒await()
                        countDownLatch.countDown();
                    }
                    return "ok";
                }
            })));

            //System.out.println("=========================submit:" + submit.get());

        }
        try {
            // 让当前线程处于阻塞状态，直到锁存器计数为零
            countDownLatch.await();
        } catch (InterruptedException e) {
            //throw new BusinessLogException(ResponseEnum.FAIL);
            throw new RuntimeException("error");
        }
        // 通过mybatis的批量插入的方式来进行数据的插入, 这一步还是要做判空
//        if (GeneralUtil.listNotNull(updateList)) {
//            batchUpdateEntity(updateList);
//            LogUtil.info("xxxxxxxxxxxxxxx");
//        }
        System.out.println("================批量更新后的list================");
        for (String s : updateList1) {
            if (!StringUtils.isEmpty(s)) {
                System.out.println(s);
            }
        }


        //System.out.println(updateList1);

    }
}
