package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.elasticsearch.ModelMapping;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.Product;
import com.lrz.eshop.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品控制类
 * @author 天天
 * @create 2023/2/26 15:24
 * @description
 */

@Api(tags = "product-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * 根据sellerId查询用户上架的所有model
     * @param sellerId
     * @return
     */
    @ApiOperation("根据sellerId查询用户上架的所有model")
    @PostMapping("/selectAllModelBySellerId")
    public Result<?> selectAllModelBySellerId(@RequestParam("sellerId") String sellerId) {
        List<ModelMapping> models = productService.selectAllModelBySellerId(sellerId);
        if (models == null) {
            return Result.operateFailed();
        }else {
            return Result.success("查询成功", models);
        }
    }

    /**
     * 具体商品页面
     * @param modelId
     * @return
     */
    @ApiOperation("根据modelId查询所有product信息")
    @PostMapping("/selectAllProductByModelId")
    public Result<?> selectAllProductByModelId(@RequestParam("modelId") String modelId) {
        Model model = productService.selectAllProductByModelId(modelId);
        if (model == null) {
            return Result.notFound();
        }else {
            return Result.success("查询成功", model);
        }
    }

    /**
     * 查看最新(create_time)的十个model
     * @return
     */
    @ApiOperation("查看最新(create_time)的十个model")
    @GetMapping("/getNewModel")
    public Result<?> getNewModel() {
        List<Model> models = productService.selectNewModel(10);
        return Result.success(models);
    }

    /**
     * 查看最热(sell_count)的十个model
     * @return
     */
    @ApiOperation("查看最热(sell_count)的十个model")
    @GetMapping("/getHotModel")
    public Result<?> getHotModel() {
        List<Model> models = productService.selectHotModel(10);
        return Result.success(models);
    }

/*     @ApiOperation("根据modelId上传cover照片地址")
    @PostMapping("/uploadModelCoverImage")
    public Result<?> uploadModelCoverImage(@RequestParam("file") MultipartFile file, @RequestParam("modelId") String modelId) {
        Model model = productService.selectModelById(modelId);
        if(model == null) {
            return Result.failed();
        }
        String url = productService.uploadModelCoverImage(file, model);
        if(url == null) {
            return Result.failed();
        }
        model.setCoverImgUrl(url);
        productService.updateModel(model);
        return Result.success("更新成功", url);
    } */


    /**
     * 添加商品，包含图片和具体产品
     * @param model
     * @return
     */
    @ApiOperation("添加model")
    @PostMapping("/addModel")
    public Result<?> addModel(@RequestBody Model model) {
        // System.out.println("666666666666666666666666");
        // System.out.println(model);
        // if(model.getProducts() != null) {
        //     for (Product product: model.getProducts()) {
        //         product.setModelId(model.getId());
        //     }
        //     System.out.println(model.getProducts());
        // }
        // productService.insertModel(model);
        boolean flag = productService.addModel(model);
        // boolean flag = true;
        if(flag) {
            return Result.success("添加成功", model);
        }else {
            return Result.operateFailed();
        }
    }

/*     @ApiOperation("添加product")
    @PostMapping("/addProduct")
    public Result<?> addProduct(@RequestBody Product product) {
        productService.insertProduct(product);
        return Result.success("添加成功", product);
    } */

/*     @ApiOperation("添加一组product")
    @PostMapping("/addProductList")
    public Result<?> addProduct(@RequestBody List<Product> products) {
        for (Product product: products) {
            productService.insertProduct(product);
        }
        return Result.success("添加成功", products);
    } */


    @ApiOperation("根据categoryId查询所有model")
    @PostMapping("/selectModelByCategoryId")
    public Result<?> selectModelByCategoryId(@RequestParam("categoryId") String categoryId) {
        List<Model> models = productService.selectModelByCategoryId(categoryId);
        return Result.success("查询成功", models);
    }


/*     @ApiOperation("同机型最大seq")
    @PostMapping("/selectMaxSeqByModelId")
    public Result<?> selectMaxSeqByModelId(@RequestParam("modelId") String modelId) {
        Integer seq = productService.selectMaxProSeqByModelId(modelId);
        if(seq == null) seq = 0;
        return Result.success("查询成功", seq);
    } */

    /**
     * 获取全部category，以及每个category的configs数组
     * @return
     */
    @ApiOperation("获取全部category，以及每个category的configs数组")
    @GetMapping("/selectAllCategory")
    public Result<?> selectAllCategory() {
        List<Category> categories = productService.selectAllCategory();
        if(categories == null) {
            return Result.operateFailed();
        }
        return Result.success("查询成功", categories);
    }



    // 下面是购物车页面所用到的接口

    @ApiOperation("按照productId查找具体product")
    @PostMapping("/selectProductDetailByProductId")
    public Result<?> selectProductDetailByProductId(@RequestParam("productId") String productId) {
        Product product = productService.selectProductDetailByProductId(productId);
        if (product == null) {
            return Result.operateFailed();
        }else {
            return Result.success("查询成功", product);
        }
    }

    @ApiOperation("按照productIdList查找具体productList")
    @PostMapping("/selectProductDetailByProductIdList")
    public Result<?> selectProductDetailByProductIdList(@RequestBody List<String> productIds) {
        List<Product> products = new ArrayList<>();
        if(productIds == null || productIds.size() == 0) {
            return Result.success(products);
        }
        for (String productId: productIds) {
            Product product = productService.selectProductDetailByProductId(productId);
            if (product != null) {
                products.add(product);
            }
        }
        if (products.size() == 0) {
            return Result.operateFailed();
        }else {
            return Result.success("查询成功", products);
        }
    }


    /**
     * 下架商品
     * @param sellerId
     * @param modelId
     * @return
     */
    @ApiOperation("根据sellerId和modelId移除model")
    @PostMapping("/removeModel")
    public Result<?> removeModel(@RequestParam("sellerId") String sellerId, @RequestParam("modelId") String modelId) {
        Model model = productService.delModel(sellerId, modelId);
        if(model == null) {
            return Result.operateFailed();
        }
        return Result.success("删除成功", model);
    }



}
