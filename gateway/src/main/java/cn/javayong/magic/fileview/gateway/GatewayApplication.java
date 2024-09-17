package cn.javayong.magic.fileview.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 网关开发(接口提交 、文件渲染)
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("cn.javayong.magic.fileview")
public class GatewayApplication {

    private static Logger logger = LoggerFactory.getLogger(GatewayApplication.class);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        logger.info("开始启动转码网关");
        SpringApplication application = new SpringApplication(GatewayApplication.class);
        application.run(args);
        logger.info("结束启动转码网关，耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }

}
