package com.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.apache.tomcat.util.digester.Rule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 胡开成
 * @Date 2020/3/19 22:16
 */

@Configuration
public class MyRule {

    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
