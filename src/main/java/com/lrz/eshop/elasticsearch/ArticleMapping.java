package com.lrz.eshop.elasticsearch;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.user.UserSocialInfo;
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
 * @create 2023/5/18 23:21
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleMapping {
    @ElasticsearchProperty(type = FieldType.Long, index = false)
    private Long id;

    @ElasticsearchProperty(type = FieldType.Long)
    private Long userId;

    @ElasticsearchProperty(type = FieldType.Keyword, index = false)
    private String nickname;

    @ElasticsearchProperty(type = FieldType.Long)
    private Long categoryId;

    @ElasticsearchProperty(type = FieldType.Keyword)
    private String categoryName;

    @ElasticsearchProperty(type = FieldType.Text)
    private String title;

    @ElasticsearchProperty(type = FieldType.Text)
    private String abstracts;

    @ElasticsearchProperty(type = FieldType.Keyword, index = false)
    private String coverImageUrl;

    @ElasticsearchProperty(type = FieldType.Integer, index = false)
    private int watches;

    @ElasticsearchProperty(type = FieldType.Integer, index = false)
    private int stars;

    @ElasticsearchProperty(type = FieldType.Integer, index = false)
    private int likes;
    // isLike = 0,
    @ElasticsearchProperty(type = FieldType.Integer, index = false)
    private int dislikes;

    @ElasticsearchProperty(type = FieldType.Date, index = false)
    private Date createTime;

    public static String getSource() {
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            {
                builder.startObject("properties");
                {
                    Class<? extends ArticleMapping> obj = ArticleMapping.class;
                    for(Field field: obj.getDeclaredFields()) {
                        ElasticsearchProperty annotation = field.getAnnotation(ElasticsearchProperty.class);
                        if(annotation != null) {
                            builder.startObject(field.getName());
                            {
                                builder.field("type", annotation.type().getMappedName());
                                if(!annotation.index()) {
                                    builder.field("index", false);
                                }
                            }
                            builder.endObject();
                        }
                    }
                }
                builder.endObject();
            }
            builder.endObject();
            return Strings.toString(builder);
        } catch (Exception e) {
            throw new MapperParsingException("Failed to build mapping source", e);
        }
    }

    public String paramJson() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.field("id", this.getId());
            builder.field("userId", this.getUserId());
            builder.field("nickname", this.getNickname());
            builder.field("categoryId", this.getCategoryId());
            builder.field("categoryName", this.getCategoryName());
            builder.field("title", this.getTitle());
            builder.field("abstracts", this.getAbstracts());
            builder.field("coverImageUrl", this.getCoverImageUrl());
            builder.field("watches", this.getWatches());
            builder.field("stars", this.getStars());
            builder.field("likes", this.getLikes());
            builder.field("dislikes", this.getDislikes());
            builder.field("createTime", this.getCreateTime());
        }
        builder.endObject();
        return Strings.toString(builder);
    }
}
