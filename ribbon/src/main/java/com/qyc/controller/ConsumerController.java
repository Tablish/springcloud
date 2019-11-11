package com.qyc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class ConsumerController {

    /*@Autowired
    private LoadBalancerClient client;

    @RequestMapping("/consumer")
    public String helloConsumer() {

        ServiceInstance serviceInstance = client.choose("providers");
        //负载均衡算法默认是轮询，轮询取得服务
        URI uri = URI.create(String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()));
        return uri.toString();
    }*/
}
