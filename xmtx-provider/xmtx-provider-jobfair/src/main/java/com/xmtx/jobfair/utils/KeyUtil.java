package com.xmtx.jobfair.utils;

import java.util.Random;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 0:17 2020/1/3
 * @ Description：生成唯一的主键，格式：时间+随机数
 * @ Modified By：
 * @Version: $
 */
public class KeyUtil {
    /*生成唯一的主键，
    **格式：
    **时间+随机数*/
    public static synchronized Integer genUniqueKey(){//简单方法
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return number;
        //return System.currentTimeMillis() + String.valueOf(number);
    }
}
