package cn.sj.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:OpenFeign配置
 * @author: sj
 * @createDate: 2021/8/5 12:48
 */
@Configuration
public class OpenFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}

