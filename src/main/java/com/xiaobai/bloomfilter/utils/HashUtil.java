package com.xiaobai.bloomfilter.utils;

/**
 * hash工具类
 *
 * @author yin_zhj
 * @date 2020/6/9
 */
public class HashUtil {
    /**
     * BKDRHash
     * @param str
     * @return
     */
    public static int BKDRHash(int seed, String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * seed) + str.charAt(i);
        }
        return (hash & 0x7FFFFFFF);
    }

    private static void test(int i) {
        System.out.println(i);
    }
}
