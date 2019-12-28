package cn.tyrone.sca.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ScaAccountServiceApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(ScaAccountServiceApplication.class, args);
    }

    public void run(String... args) throws Exception {
        logger.info("-------------- 账户应用服务提供者-启动成功 --------------");
    }
}
