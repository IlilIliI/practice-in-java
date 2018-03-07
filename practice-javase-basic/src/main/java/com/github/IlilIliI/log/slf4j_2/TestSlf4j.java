package com.github.IlilIliI.log.slf4j_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leinl
 * @Description:
 * @create 2018/02/28
 * @Modified By:
 **/
public class TestSlf4j {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TestSlf4j.class);
        System.out.println(logger);
        logger.debug("slf4j测试信息");
    }
}
