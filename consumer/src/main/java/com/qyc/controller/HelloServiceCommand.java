package com.qyc.controller;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * 利用提供的接口，手动实现 熔断@HystrixCommand(fallbackMethod = "helloFallBack") 功能
 */
public class HelloServiceCommand extends HystrixCommand<String> {
    private RestTemplate restTemplate;

    protected HelloServiceCommand(String commandGroupKey, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return restTemplate.getForEntity("http://PROVIDER/hello",String.class).getBody();
    }

    @Override
    protected String getFallback() {
        return "error";
    }
}
