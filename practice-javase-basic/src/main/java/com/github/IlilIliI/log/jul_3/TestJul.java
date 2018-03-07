package com.github.IlilIliI.log.jul_3;


import java.util.logging.Logger;

/**
 * @author leinl
 * @Description:
 * @create 2018/02/28
 * @Modified By:
 **/
public class TestJul {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("com.xxx");
        logger.info("Jdk logger!!!");

//        Logger logger = LoggerFactory.getLogger(TestJul.class);
//        System.out.println(logger);
//        logger.error("sssssdfwerewr");
    }
}
