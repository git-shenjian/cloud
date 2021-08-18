package cn.sj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/2 13:52
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverport;

    @RequestMapping("/payment/consul")
    public String payment(){
        return "consul"+serverport;
    }
}
