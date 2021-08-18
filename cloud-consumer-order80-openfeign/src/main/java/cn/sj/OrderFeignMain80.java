package cn.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/4 14:01
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients  //开启OpenFeign
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
