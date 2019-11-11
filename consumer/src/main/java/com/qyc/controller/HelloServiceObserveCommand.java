package com.qyc.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

/**
 * 手动方式层面上去实现多请求，将结果会聚起来
 */
public class HelloServiceObserveCommand extends HystrixObservableCommand<String> {

    private RestTemplate restTemplate;

    protected HelloServiceObserveCommand(String commandGroupKey, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.restTemplate = restTemplate;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if(!subscriber.isUnsubscribed()) {
                        System.out.println("方法执行");

                        String result = restTemplate.getForEntity("http://PROVIDER/hello", String.class).getBody();
                        subscriber.onNext(result);

                        String result1 = restTemplate.getForEntity("http://PROVIDER/hello", String.class).getBody();
                        //这个方法是监听方法，传递结果的
                        subscriber.onNext(result1);

                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    //服务降级Fallback
    @Override
    protected Observable<String> resumeWithFallback() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext("error");
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
