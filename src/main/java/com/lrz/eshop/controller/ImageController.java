package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.pojo.common.Image;
import com.lrz.eshop.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 与图片相关的控制类
 * @author 天天
 * @create 2023/3/16 23:41
 * @description
 */
@Api(tags = "image-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @ApiOperation("根据image删除图片,image必须包含id和url")
    @PostMapping("/delImg")
    public Result<?> delImg(@RequestBody Image image) {
        // image必须包含id和url
        Image imageDB = imageService.delImg(image);
        if(imageDB == null) {
            return Result.failed();
        }
        return Result.success("删除图片成功",imageDB);
    }

    @ApiOperation("根据imageList删除一组,每个image必须包含id和url")
    @PostMapping("/delImageList")
    public Result<?> delImageList(@RequestBody List<Image> images) {
        if(images == null) {
            return Result.success("没有要删除的照片", null);
        }
        // image必须包含id和url
        List<Image> imageDBs = new ArrayList<>();
        for (Image image: images) {
            Image imageDB = imageService.delImg(image);
            if (imageDB == null) {
                return Result.failed();
            }
            imageDBs.add(imageDB);
        }
        return Result.success("删除图片数组成功", imageDBs);
    }




    @ApiOperation("上传图片文件")
    @PostMapping("/uploadImage")
    public Result<?> uploadImage(@RequestParam("file") MultipartFile file) {
        String url = imageService.uploadImage(file);
        if(url == null) {
            return Result.failed();
        }
        Image image = new Image();
        image.setImgUrl(url);
        // image.setType((short) 1);
        imageService.insertImage(image);
        return Result.success("上传图片成功", image);
    }

    @ApiOperation("关联图片文件")
    @PostMapping("/linkImage")
    public Result<?> linkImage(@RequestBody Image image) {
        // image必须包含type、id、url、foreignId
        // System.out.println(image);
        Image imageDB = imageService.linkImage(image);
        if (imageDB == null) {
            return Result.failed();
        }
        return Result.success("关联图片成功", image);
    }


    @ApiOperation("关联图片数组")
    @PostMapping("/linkImageList")
    public Result<?> linkImageList(@RequestBody List<Image> images) {
        List<Image> imageDBs = new ArrayList<>();
        // image必须包含type、id、url、foreignId
        for (Image image: images) {
            Image imageDB = imageService.linkImage(image);
            if(imageDB == null) return Result.failed();
            imageDBs.add(imageDB);
        }
        return Result.success("关联图片数组成功", imageDBs);
    }


}
