package com.qyc.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {


    /*@Autowired
    private RestTemplate restTemplate;

    //请求熔断注解，当服务出现问题时候会执行fallbackMetho属性的名为helloFallBack的方法
    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService() {

        return restTemplate.getForEntity("http://PROVIDER/hello", String.class).getBody();
    }


    public String helloFallBack() {
        return "error";
    }*/

}
