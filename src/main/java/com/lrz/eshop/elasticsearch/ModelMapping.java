package com.lrz.eshop.elasticsearch;

import com.lrz.eshop.pojo.product.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.mapper.MapperParsingException;
import org.elasticsearch.xcontent.XContentBuilder;
import org.elasticsearch.xcontent.XContentFactory;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author 天天
 * @create 2023/5/12 3:45
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelMapping {


    @ElasticsearchProperty(type = FieldType.Long, index = false)
    private Long id;

    @ElasticsearchProperty(type = FieldType.Text)
    private String title;

    @ElasticsearchProperty(type = FieldType.Text)
    private String advertisement;

    @ElasticsearchProperty(type = FieldType.Keyword, index = false)
    private Long categoryId;

    @ElasticsearchProperty(type = FieldType.Keyword)
    private String categoryName;

    @ElasticsearchProperty(type = FieldType.Integer, index = false)
    private int starCounts;

    @ElasticsearchProperty(type = FieldType.Double, index = false)
    private Double lowPrice;

    @ElasticsearchProperty(type = FieldType.Keyword, index = false)
    private String coverImgUrl;

    @ElasticsearchProperty(type = FieldType.Keyword, index = false)
    private Long sellerId;

    @ElasticsearchProperty(type = FieldType.Date, index = false)
    private Date createTime;

    // getters and setters omitted for brevity

    public static String getSource() {
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            {
                builder.startObject("properties");
                {
                    Class<? extends ModelMapping> obj = new ModelMapping().getClass();
                    for (Field field : obj.getDeclaredFields()) {
                        ElasticsearchProperty annotation = field.getAnnotation(ElasticsearchProperty.class);
                        if (annotation != null) {
                            builder.startObject(field.getName());
                            {
                                builder.field("type", annotation.type().getMappedName());
                                builder.field("index", annotation.index());
                            }
                            builder.endObject();
                        }
                    }
                }
                builder.endObject();
            }
            builder.endObject();
            System.out.println(Strings.toString(builder));
            return Strings.toString(builder);
        } catch (IOException ex) {
            throw new MapperParsingException("Failed to build mapping source", ex);
        }
    }

    public String paramJson() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.field("id", this.getId());
            builder.field("title", this.getTitle());
            builder.field("advertisement", this.getAdvertisement());
            builder.field("categoryId", this.getCategoryId());
            builder.field("categoryName", this.getCategoryName());
            builder.field("starCounts", this.getStarCounts());
            builder.field("lowPrice", this.getLowPrice());
            builder.field("coverImgUrl", this.getCoverImgUrl());
            builder.field("sellerId", this.getSellerId());
            builder.field("createTime", this.getCreateTime());
        }
        builder.endObject();
        return Strings.toString(builder);
    }

}
