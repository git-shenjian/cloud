package cn.sj.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/7/20 13:09
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    //@LoadBalanced注解赋予RestTemplate负载均衡的能力,模式是以轮询方式的负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
