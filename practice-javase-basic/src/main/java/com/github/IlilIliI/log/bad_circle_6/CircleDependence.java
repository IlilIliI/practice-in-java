package com.github.IlilIliI.log.bad_circle_6;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leinl
 * @Description:
 * @create 2018/02/28
 * @Modified By:
 **/
public class CircleDependence {

    //日志循环依赖 : app ==> slf4j ==> slf4j-log4j12 ==> 日志文件
    //             log4j ==> log4j-over-slf4j
    //注意:log4j依赖放最后

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CircleDependence.class);
        logger.info("sdfdsfds");
    }
}
