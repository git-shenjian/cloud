package cn.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/7/21 12:40
 */
@SpringBootApplication
@EnableEurekaServer //代表这是eureka服务端
public class EurekaMain7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7003.class,args);
    }
}
