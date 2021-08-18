package cn.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/6 12:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix //激活hystrix，效果和@EnableCircuitBreaker一一昂
public class HystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderMain80.class,args);
    }
}
