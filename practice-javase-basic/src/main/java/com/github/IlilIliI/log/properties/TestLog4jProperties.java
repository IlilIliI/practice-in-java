package com.github.IlilIliI.log.properties;

//import org.apache.log4j.Logger;

/**
 * @author leinl
 * @Description:
 * @create 2018/03/05
 * @Modified By:
 **/
public class TestLog4jProperties {

    public static void main(String[] args) {
        testLog4j1Properties();
    }


    //测试Log4j的properties: 日志体系为slf4j ==> log4j
    public static void testLog4j1Properties(){

        //Logger logger = Logger.getLogger(TestLog4jProperties.class);
        for (int i = 0; i < 10; i++){
            //logger.info("测试信息,Test Info");
        }
    }
}
