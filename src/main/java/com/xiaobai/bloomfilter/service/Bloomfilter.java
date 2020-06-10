package com.xiaobai.bloomfilter.service;

/**
 * 布隆过滤器接口
 *
 * @author yin_zhj
 * @date 2020/6/9
 */
public interface Bloomfilter {
    void put(String msg);
    boolean mightContains(String msg);
    void clear();
}
