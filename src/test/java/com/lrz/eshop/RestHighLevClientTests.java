package com.lrz.eshop;


import com.lrz.eshop.elasticsearch.ModelMapping;
import com.lrz.eshop.mapper.product.ModelMapper;
import com.lrz.eshop.pojo.product.Model;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.xcontent.XContentBuilder;
import org.elasticsearch.xcontent.XContentFactory;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * @author 天天
 * @create 2023/5/11 18:35
 * @description
 */
@Slf4j
public class RestHighLevClientTests extends EshopApplicationTests {
    private final RestHighLevelClient restHighLevelClient;

    private final ModelMapper modelMapper;

    @Autowired
    public RestHighLevClientTests(RestHighLevelClient restHighLevelClient, ModelMapper modelMapper) {
        this.restHighLevelClient = restHighLevelClient;
        this.modelMapper = modelMapper;
    }


    /**
     * 初始化索引
     * @throws IOException
     */
    @Test
    public void initIndexWithMapping() throws IOException {
        String indexName = "models";
        // 检查索引是否存在
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);

        if (exists) {
            // 删除索引
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
            restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            log.info("Index 'models' deleted successfully.");
        } else {
            log.info("Index 'models' does not exist.");
        }
        createIndexWithMapping(indexName, ModelMapping.getSource());
        mySqlToEs();
    }

    /**
     * 创建索引 创建映射
     * @param indexName
     * @param mapping
     * @throws IOException
     */
    public void createIndexWithMapping(String indexName, String mapping) throws IOException{
        // 参数1：创建索引请求对象
        // 参数2：索引请求的配置对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
                .put("index.analysis.analyzer.default.type", "ik_max_word") //指定 ik分词器作为默认分词器
        );
        createIndexRequest.mapping(mapping, XContentType.JSON); // 参数1， 映射，参数2，类型
        // 创建映射
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        log.info("创建状态：{}", createIndexResponse.isAcknowledged());
    }


    /**
     * 从mysql导入数据到es
     */
    public void mySqlToEs() throws IOException {
        List<ModelMapping> models = modelMapper.selectAllModelMapping();
        // 遍历结果集并插入 Elasticsearch 索引
        BulkRequest bulkRequest = new BulkRequest();
        for (ModelMapping modelMapping : models) {
            String source = modelMapping.paramJson();
            System.out.println(source);
            IndexRequest indexRequest = new IndexRequest("models")
                    .id(String.valueOf(modelMapping.getId()))
                    .source(source, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        // 执行批量索引请求
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        // 检查响应状态
        if (bulkResponse.status() == RestStatus.OK) {
            log.info("Imported data from MySQL to Elasticsearch index successfully.");
        } else {
            log.info("Failed to import data from MySQL to Elasticsearch index.");
        }
    }

    /**
     * PUT /products
     * {
     *  "mappings": {
         *  "properties": {
             *  "title": {
             *      "type": "keyword"
             *  },
             *  "price": {
             *      "type": "double"
             *  },
             *  "created_at": {
             *      "type": "date",
             *  },
             *  "description": {
             *      "type": "text",
             *      "analyzer": "ik_max_word"
             *  }
     *    }
     *   }
     * }
     */



}
