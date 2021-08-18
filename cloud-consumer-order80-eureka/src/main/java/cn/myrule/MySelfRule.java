package cn.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

/**
 * @description:修改ribbon默认负载均衡策略
 * 该配置类不能放在@compententscan扫描包以及子包下面，也就是不能和主启动类同级
 * @author: sj
 * @createDate: 2021/8/4 12:17
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myrule(){
        //负载均衡策略：随机策略
        return new RandomRule();
    }
}
