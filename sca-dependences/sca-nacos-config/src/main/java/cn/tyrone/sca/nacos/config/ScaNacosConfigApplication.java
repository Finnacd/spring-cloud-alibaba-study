package cn.tyrone.sca.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class ScaNacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ScaNacosConfigApplication.class, args);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String serverPort = environment.getProperty("server.port");

        System.out.printf("------------ 启动端口号: " + serverPort + " ------------\n");

    }

}
