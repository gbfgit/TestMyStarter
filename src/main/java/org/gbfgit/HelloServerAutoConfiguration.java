package org.gbfgit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloServerProperties.class)
@ConditionalOnClass(HelloServer.class)
@ConditionalOnProperty(prefix = "hello",value = "enable",matchIfMissing = true)
public class HelloServerAutoConfiguration {
    @Autowired
    private HelloServerProperties helloServerProperties;

    //该注解用于将返回对象封装成bean并由Spring进行管理。否则在使用@Autowired时会报错
    @Bean
    public HelloServer helloServer(){
        System.out.println("create and init the server... ");
        HelloServer helloServer = new HelloServer();
        helloServer.setMsg(helloServerProperties.getMsg());
        return helloServer;
    }
}
