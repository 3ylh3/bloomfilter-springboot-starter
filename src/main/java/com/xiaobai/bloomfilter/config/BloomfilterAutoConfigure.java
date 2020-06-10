package com.xiaobai.bloomfilter.config;

import com.xiaobai.bloomfilter.service.Bloomfilter;
import com.xiaobai.bloomfilter.service.impl.BloomfilterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配类
 *
 * @author yin_zhj
 * @date 2020/6/9
 */
@Configuration
@EnableConfigurationProperties(BloomfilterProperties.class)
public class BloomfilterAutoConfigure {
    @Autowired
    private BloomfilterProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public Bloomfilter initBloomfilter() {
        return new BloomfilterImpl(properties.getSize(), properties.getHashNums());
    }
}
