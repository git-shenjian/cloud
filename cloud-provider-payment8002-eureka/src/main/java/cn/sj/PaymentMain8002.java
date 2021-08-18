package cn.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:主启动类
 * @author: sj
 * @createDate: 2021/7/7 13:50
 */
@SpringBootApplication
@EnableEurekaClient //表示是eureka客户端
@EnableDiscoveryClient //服务发现服务端
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
