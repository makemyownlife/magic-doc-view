package cn.javayong.magic.converter.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 网关开发(接口提交 、文件渲染)
 */
public class GatewayApplication {

    private static Logger logger = LoggerFactory.getLogger(GatewayApplication.class);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        logger.info("开始启动转码网关");
        logger.info("结束启动转码网关，耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }

}
