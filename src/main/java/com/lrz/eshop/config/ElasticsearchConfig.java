package com.lrz.eshop.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * ES 配置类
 * @author 天天
 * @create 2023/5/11 18:07
 * @description
 */

@Configuration
// public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
public class ElasticsearchConfig {
    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    // @Bean// es 两个端口 9200 9300
    // // spring data 还会创建 ElasticsearchOperations
    // public RestHighLevelClient elasticsearchClient() {
    //     final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
    //             .connectedTo(host)
    //             .build();
    //     return RestClients.create(clientConfiguration).rest();
    // }

    @Bean
    public RestHighLevelClient elasticsearchClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host, port, "http")));
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}
