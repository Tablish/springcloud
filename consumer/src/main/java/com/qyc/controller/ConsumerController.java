package com.qyc.controller;

import com.qyc.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@RestController
public class ConsumerController {

    @Autowired
    private  RestTemplate restTemplate;

    /*@Autowired
    private RestTemplate restTemplate;
*/

    /*@RequestMapping("ribbon-consumer")
    public String helloConsumer() {


        return restTemplate.getForEntity("http://PROVIDER/hello", String.class).getBody();
    }*/

    @Autowired
    private HelloService helloService;


    /*@RequestMapping("ribbon-consumer")
    public String consumer() throws ExecutionException, InterruptedException {
        return helloService.helloService();
    }*/


    @RequestMapping("/consumer")
    public String helloConsumer() throws ExecutionException, InterruptedException {

        HelloServiceCommand command = new HelloServiceCommand("hello",restTemplate);
        String result = command.execute();
        return result;
    }

}
