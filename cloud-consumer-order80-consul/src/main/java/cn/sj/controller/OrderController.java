package cn.sj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/2 14:11
 */
@RestController
public class OrderController {
    private final static String INVORK_URL="http://consul-provider-order8006";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String consumer(){
        return restTemplate.getForObject(INVORK_URL+"/payment/consul",String.class);
    }
}
