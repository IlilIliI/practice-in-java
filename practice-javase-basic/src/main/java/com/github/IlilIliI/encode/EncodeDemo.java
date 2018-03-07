package com.github.IlilIliI.encode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author leinl
 * @Description:
 * @create 2018/02/20
 * @Modified By:
 **/
public class EncodeDemo {

    public static void main(String[] args) throws Exception {

        String gb2312 = new String("密码是8个8".getBytes(), "GB2312");

        System.out.println(gb2312);
        FileOutputStream fos = new FileOutputStream(new File("test.txt"));
        fos.write(gb2312.getBytes());
        fos.close();
    }
}
