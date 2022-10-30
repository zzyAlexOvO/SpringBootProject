package com.utakata.utils;

import org.hibernate.loader.plan.spi.Return;

import java.util.Random;

/**
 * Created by Utakata
 * 2022/10/19 0:39
 */
public class KeyUtil {

    /**
     *生成唯一主键
     *格式：时间+随机数
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number=random.nextInt(900000)+100000;//生成6位随机数

        return  System.currentTimeMillis()+String.valueOf(number);
    }
}
