package com.lrz.eshop.service;

import com.lrz.eshop.pojo.common.Image;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.Product;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.trade.TradeDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *
 * @author 天天
 * @create 2023/2/26 15:29
 * @description
 */
public interface ProductService {


    /**
     * 根据卖家sellerId查询所有在售model
     * @param sellerId
     * @return
     */
    List<Model> selectAllModelBySellerId(String sellerId);

    /**
     * 获取最新机型
     * @return
     */
    List<Model> selectNewModel(int limit);

    /**
     * 获取最热机型
     * @return
     */
    List<Model> selectHotModel(int limit);

    /**
     * 根据modelId查询所有product
     *
     * @param modelId
     * @return
     */
    Model selectAllProductByModelId(String modelId);

    Model selectModelById(String modelId);

    /**
     * 将cover图片上传到oss服务器
     * @param file
     * @param model
     * @return
     */
    // String uploadModelCoverImage(MultipartFile file, Model model);



    int updateModel(Model model);
    int updateProduct(Product product);

    int insertModel(Model model);
    int insertProduct(Product product);

    /**
     * 根据categoryId查询所有model
     * @param categoryId
     * @return
     */
    List<Model> selectModelByCategoryId(String categoryId);

    Integer selectMaxProSeqByModelId(String modelId);


    List<Category> selectAllCategory();



    /**
     * 根据modelId查询具体的产品信息，用于购物车页面
     * @param productId
     * @return
     */
    Product selectProductDetailByProductId(String productId);

    Trade insertTrade(Trade trade);
    TradeDetail insertTradeDetail(TradeDetail tradeDetail);

}
