package com.yangrd.today.modules.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Utils
 *
 * @author yangrd
 * @date 2019/10/09
 */
public class MD5Utils {

    public static String getMd5(String str){
        // 第一步，获取MessageDigest对象，参数为MD5字符串，表示这是一个MD5算法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 第二步，输入源数据，参数类型为byte[]
        md5.update(str.getBytes());
        // 第三步，计算MD5值 
        /*
         * digest() 方法返回值是一个字节数组类型的 16 位长度的哈希值，通常，我们会
         * 转化为十六进制的 32 位长度的字符串来使用，可以利用 BigInteger 类来做这个转化：
         */
        BigInteger bigInt = new BigInteger(1, md5.digest());
        return bigInt.toString(16);
    }
}
