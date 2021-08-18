package cn.sj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/2 13:17
 */
@RestController
@Slf4j
public class OrderZKController {
    private final String INVORK_URL="http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getInfo(){
        return restTemplate.getForObject(INVORK_URL+"/payment/zk",String.class);
    }
}
