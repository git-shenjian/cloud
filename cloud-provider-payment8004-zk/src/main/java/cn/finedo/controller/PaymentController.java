package cn.finedo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/7/30 14:27
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverport;

    @RequestMapping("payment/zk")
    public String zk(){
        return "zookeeper"+serverport;
    }
}
