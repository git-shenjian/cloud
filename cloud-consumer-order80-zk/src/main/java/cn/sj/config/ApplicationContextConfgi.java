package cn.sj.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/2 13:16
 */
@Configuration
public class ApplicationContextConfgi {

    @Bean
    @LoadBalanced//负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
