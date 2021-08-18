package cn.sj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/11 13:15
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardMain.class,args);
    }
}
