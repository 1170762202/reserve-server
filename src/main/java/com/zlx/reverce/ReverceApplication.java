package com.zlx.reverce;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.zlx.reverce.handler.BootNettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.InetAddress;

@SpringBootApplication
@MapperScan("com.zlx.reverce.mapper")
@EnableSwagger2Doc
public class ReverceApplication extends SpringBootServletInitializer{


    @Value("${netty.port}")
    private int port;

    @Value("${netty.url}")
    private String url;



    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ReverceApplication.class, args);

        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) ctx.getBean("tomcatServletWebServerFactory");
            int port = tomcatServletWebServerFactory.getPort();
            String contextPath = tomcatServletWebServerFactory.getContextPath();
            System.out.println("http://" + host + ":" + port + contextPath + "/");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ReverceApplication.class);
    }

}
