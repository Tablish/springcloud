package com.qyc.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.ExecutionException;

@Service
public class HelloService {


    /*@Autowired
    private RestTemplate restTemplate;*/

    //请求熔断注解，当服务出现问题时候会执行fallbackMetho属性的名为helloFallBack的方法
    /*@HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService() throws ExecutionException, InterruptedException {

        return restTemplate.getForEntity("http://PROVIDER/hello", String.class).getBody();
    }*/


    //这里并没有执行，不知道为什么，当关闭provider2服务后，只返回hello1
    /*public String helloFallBack() {
        return "error";
    }*/






    //@Autowired
    //private RestTemplate restTemplate;
    //多请求结果会聚的注解写法，调用还是跟手写会聚一样调用
    //ObservableExecutionMode.EAGER热执行  ObservableExecutionMode.LAZY冷执行
    //还可以忽略某些异常避免出现服务降级，有时候某些异常出现，但是我们并不想服务降级，异常就异常吧。参数ignoreExceptions = XXX.class
    //groupKey ="" ,threadPoolKey = "",这是线程隔离，比如我需要根据groupKey划分，如果还要对groupKey内的任务进一步划分，就要threadPoolKey，比如对groupKey组内进行
    //读取数据的时候，是从缓存读，还是数据库读
    //@CacheKey,缓存的注解方式

    /**
     * 注解的方式层面上去实现多请求，将结果会聚起来
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    /*@HystrixCommand(fallbackMethod = "helloFallBack",observableExecutionMode = ObservableExecutionMode.LAZY)
    public Observable<String> helloService() throws ExecutionException, InterruptedException {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()){
                        String result = restTemplate.getForEntity("http://PROVIDER/hello", String.class).getBody();
                        subscriber.onNext(result);
                        String result1 = restTemplate.getForEntity("http://PROVIDER/hello", String.class).getBody();
                        subscriber.onNext(result1);
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public String helloFallBack(){
        return "error";
    }*/
}
