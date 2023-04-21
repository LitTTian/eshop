package com.lrz.eshop.pojo.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户的社区信息
 * @author 天天
 * @create 2023/4/19 15:10
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommunityInfo {

        @JsonFormat(shape = JsonFormat.Shape.STRING)
        private Long id; // 用户的id

        private int articleCount; // 文章的数量
        private int articleStaredCount; // 文章被收藏的次数

        private int articleReadCount; // 文章被阅读的次数
        private int articleLikedCount; // 文章被点赞的次数
        
        private int articleCommentCount; // 文章被评论的次数
        private int peopleStarCount; // 关注的人的数量
        private int fansCount; // 粉丝的数量
}
