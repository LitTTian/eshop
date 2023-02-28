package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.pojo.common.Banner;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.Product;
import com.lrz.eshop.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @ApiOperation("根据sellerId查询用户上架的所有model")
    @PostMapping("/selectAllModelBySellerId")
    public Result<?> selectAllModelBySellerId(@RequestParam("sellerId") String sellerId) {
        List<Model> models = productService.selectAllModelBySellerId(sellerId);
        if (models == null) {
            return Result.failed();
        }else {
            return Result.success("查询成功", models);
        }
    }

    @ApiOperation("根据modelId查询所有product信息")
    @PostMapping("/selectAllProductByModelId")
    public Result<?> selectAllProductByModelId(@RequestParam("modelId") String modelId) {
        Model model = productService.selectAllProductByModelId(modelId);
        if (model == null) {
            return Result.failed();
        }else {
            return Result.success("查询成功", model);
        }
    }

    @ApiOperation("查看最新的十个model")
    @GetMapping("/getNewModel")
    public Result<?> getNewModel() {
        List<Model> models = productService.selectNewModel(10);
        return Result.success(models);
    }

    @ApiOperation("查看最热的十个model")
    @GetMapping("/getHotModel")
    public Result<?> getHotModel() {
        List<Model> models = productService.selectHotModel(10);
        return Result.success(models);
    }

    @ApiOperation("根据modelId上传cover照片地址")
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
    }


    @ApiOperation("添加model")
    @PostMapping("/addModel")
    public Result<?> addModel(@RequestBody Model model) {
        productService.insertModel(model);
        return Result.success("添加成功", model);
    }

    @ApiOperation("添加product")
    @PostMapping("/addProduct")
    public Result<?> addProduct(@RequestBody Product product) {
        productService.insertProduct(product);
        return Result.success("添加成功", product);
    }

    @ApiOperation("添加一组product")
    @PostMapping("/addProductList")
    public Result<?> addProduct(@RequestBody List<Product> products) {
        for (Product product: products) {
            productService.insertProduct(product);
        }
        return Result.success("添加成功", products);
    }


    @ApiOperation("根据分类id查询机型")
    @PostMapping("/selectModelByCategoryId")
    public Result<?> selectModelByCategoryId(@RequestParam("categoryId") String categoryId) {
        List<Model> models = productService.selectModelByCategoryId(categoryId);
        return Result.success("查询成功", models);
    }


    @ApiOperation("同机型最大seq")
    @PostMapping("/selectMaxSeqByModelId")
    public Result<?> selectMaxSeqByModelId(@RequestParam("modelId") String modelId) {
        int seq = productService.selectMaxSeqByModelId(modelId);
        return Result.success("查询成功", seq);
    }

}
