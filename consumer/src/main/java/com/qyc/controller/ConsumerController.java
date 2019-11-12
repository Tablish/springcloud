package com.qyc.controller;

import com.qyc.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class ConsumerController {

    @Autowired
    private  RestTemplate restTemplate;

    /*@Autowired
        private RestTemplate restTemplate;
    */


    /**
     * 实现消费
     */
    /*@RequestMapping("ribbon-consumer")
    public String helloConsumer() {

        return restTemplate.getForEntity("http://PROVIDER/hello", String.class).getBody();
    }*/

    @Autowired
    private HelloService helloService;

    /**
     * 利用注解完成熔断
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    /*@RequestMapping("ribbon-consumer")
    public String consumer() throws ExecutionException, InterruptedException {
        return helloService.helloService();
    }*/

    /**
     * 手动完成熔断
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    /*@RequestMapping("/consumer")
    public String helloConsumer() throws ExecutionException, InterruptedException {

        HelloServiceCommand command = new HelloServiceCommand("hello",restTemplate);
        String result = command.execute();
        return result;
    }*/


    /**
     * 手动方式层面上去实现多请求，将结果会聚起来
     *
     * 多个请求，每个请求调用多个服务，利用监听：热执行 冷执行好像效果一样
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @RequestMapping("/consumer")
    public String helloConsumer() throws ExecutionException, InterruptedException {

        List<String> list = new ArrayList<>();
        HelloServiceObserveCommand command = new HelloServiceObserveCommand("hello",restTemplate);
        //热执行
        Observable<String> observable = command.observe();
        //冷执行
        //Observable<String> observable =command.toObservable();
        //订阅
        observable.subscribe(new Observer<String>() {
            //请求完成的方法
            @Override
            public void onCompleted() {
                System.out.println("会聚完了所有查询请求");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
            //订阅调用事件，结果会聚的地方，用集合去装返回的结果会聚起来。
            @Override
            public void onNext(String s) {
                System.out.println("结果来了.....");
                list.add(s);
            }
        });

        return list.toString();
    }

}
