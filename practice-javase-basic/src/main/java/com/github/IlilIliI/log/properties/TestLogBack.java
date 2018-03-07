package com.github.IlilIliI.log.properties;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leinl
 * @Description:
 * @create 2018/03/07
 * @Modified By:
 **/
public class TestLogBack {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TestLogBack.class);
        for (int i = 0; i < 10; i++){
            logger.info("哈哈");
        }
    }
}
