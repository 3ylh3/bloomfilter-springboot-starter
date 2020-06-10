package com.xiaobai.bloomfilter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置类
 *
 * @author yin_zhj
 * @date 2020/6/9
 */
@Data
@ConfigurationProperties("bloomfilter")
public class BloomfilterProperties {
    /**
     * 布隆过滤器size
     */
    private String size;
    /**
     * 哈希函数个数
     */
    private String hashNums;
}
