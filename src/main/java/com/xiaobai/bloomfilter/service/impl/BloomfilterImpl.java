package com.xiaobai.bloomfilter.service.impl;

import com.xiaobai.bloomfilter.service.Bloomfilter;
import com.xiaobai.bloomfilter.utils.HashUtil;

import java.util.BitSet;

/**
 * 布隆过滤器实现类
 *
 * @author yin_zhj
 * @date 2020/6/9
 */
public class BloomfilterImpl implements Bloomfilter {
    private int hashNums;
    private BitSet bitSet;
    private static final int DEFAULT_SIZE = 2147483647;
    private static final int DEFAULT_HASH_NUMS = 3;
    private static final int[] seeds = {31,131,1313,13131,131313,1313131,13131313,131313131};

    public BloomfilterImpl(String sizeStr, String hashNumsStr) {
        if(null == hashNumsStr || hashNumsStr.length() == 0) {
            this.hashNums = DEFAULT_HASH_NUMS;
        } else {
            this.hashNums = Integer.parseInt(hashNumsStr);
        }
        if(null == sizeStr || sizeStr.length() == 0) {
            this.bitSet = new BitSet(DEFAULT_SIZE);
        } else {
            this.bitSet = new BitSet(Integer.parseInt(sizeStr));
        }
    }

    @Override
    public void put(String msg) {
        for(int i = 0;i < hashNums;i++) {
            int hash = HashUtil.BKDRHash(seeds[i], msg);
            int index = hash % bitSet.size();
            synchronized (this) {
                bitSet.set(index, true);
            }
        }
    }

    @Override
    public boolean mightContains(String msg) {
        synchronized (this) {
            for (int i = 0; i < hashNums; i++) {
                int hash = HashUtil.BKDRHash(seeds[i], msg);
                int index = hash % bitSet.size();
                boolean tmp = bitSet.get(index);
                if (!tmp) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void clear() {
        bitSet.clear();
    }
}
