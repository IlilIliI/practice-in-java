package com.github.IlilIliI.log.common_logging_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author leinl
 * @Description:
 * @create 2018/02/28
 * @Modified By:
 **/
public class TestJcl {

    public static void main(String[] args) {

        Log log = LogFactory.getLog(TestJcl.class);
        System.out.println(log);
        log.debug("JCL Test infomation");
    }
}
