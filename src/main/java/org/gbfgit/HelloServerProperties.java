package org.gbfgit;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello")
public class HelloServerProperties {
    //用以验证是否会去读取配置，如果没有配置或者没有读取配置，则会默认为world
    private static final String MSG = "world";
    private String msg = MSG;

    //【猜测】Spring在启动时加载class时会根据类上的注解自动进行类的初始化，调用该方法。在读取配置后，再次实例化这个类的对象。
    public String getMsg() {
        System.out.println("return the Properties msg value..." + msg);
        return msg;
    }

    //根据前缀及factories配置文件，读取properties配置文件里面的相关值。
    public void setMsg(String msg) {
        System.out.println("init the Properties msg value..." + msg);
        this.msg = msg;
    }
}
