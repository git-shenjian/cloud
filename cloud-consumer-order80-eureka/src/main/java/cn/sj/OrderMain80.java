package cn.sj;

import cn.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/7/20 13:07
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //服务发现客户端
@RibbonClient(name="CLOUD-PROVIDER-PAYMENT",configuration = MySelfRule.class)//修改ribbon默认负载均衡策略，name：服务端地址  configuration:自定义配置
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}

