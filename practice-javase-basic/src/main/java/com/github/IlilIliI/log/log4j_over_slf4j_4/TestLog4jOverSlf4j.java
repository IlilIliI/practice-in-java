package com.github.IlilIliI.log.log4j_over_slf4j_4;


/**
 * @author leinl
 * @Description:
 * @create 2018/02/28
 * @Modified By:
 **/
public class TestLog4jOverSlf4j {

    /**
     *
     *   比如应用有A模块和B模块(单体应用),A模块使用log4j,B模块使用slf4j门面和log4j2
     *
     *   现在要使两个模块都使用log4j2而不能改变A模块原有代码
     *
     *
     *   解决方案:使用log4j-over-slf4j 将A模拟适配到 B模拟的slf4j的log4j2
     *           将日志全在B模块打印
     *
     * @param args
     */
    public static void main(String[] args) {

        //log4j1 ==> jcl + log4j1
        //[DEBUG][2018/02/28 21:57:33482][com.github.IlilIliI.log.log4j_over_slf4j_4.TestLog4jOverSlf4j.main(TestLog4jOverSlf4j.java:28)]
        //这是log4j1的日志!!!!
        //org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger(TestLog4jOverSlf4j.class);
        //logger1.debug("这是log4j1的日志!!!!");

        //log4j2==> slf4j + log4j2
        //21:57:34.546 [main] WARN  com.github.IlilIliI.log.log4j_over_slf4j_4.TestLog4jOverSlf4j - 这是log4j2的日志
        //org.apache.logging.log4j.Logger logger2 = org.apache.logging.log4j.LogManager.getLogger(TestLog4jOverSlf4j.class);
        //logger2.debug("这是log4j2的日志");


        //现在让log4j1 适配到 slf4j上,不改变代码的情况下,全部走log4j2,在pom.xml中添加 log4j-over-slf4j
        //将log4j适配到slf4j及log4j2上去 ==> log4j2需要使用log4j-slf4j-impl桥接到slf4j来,再使用log4j-over-slf4j
        //将log4j1适配到slf4j上来使用log4j2输出.此时需要删除log4j1的依赖,不然不走slf4j下的log4j2
    }
}
