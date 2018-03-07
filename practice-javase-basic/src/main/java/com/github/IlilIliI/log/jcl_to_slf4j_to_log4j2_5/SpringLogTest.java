package com.github.IlilIliI.log.jcl_to_slf4j_to_log4j2_5;

//import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author leinl
 * @Description:
 * @create 2018/02/28
 * @Modified By:
 **/
public class SpringLogTest {

    //static Logger logger = Logger.getLogger(SpringLogTest.class);

    public static void main(String[] args) {

        //spring ==> jcl ==> slf4j ==> log4j-slf4j-impl ==> log4j2
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.start();

        //但是自定义的日志会打印到jdk14中,使用log4j-over-slf4j 或jcl-over-slf4j来适配即可
        //logger.debug("打印到哪里呢?");
    }
}
