package cn.sj.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/17 12:35
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator route_one(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("route_one",f -> f.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator route_two(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("route_two",f -> f.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
