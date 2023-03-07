package com.lrz.eshop.common;

import java.io.Serializable;

/**
 * @author 天天
 * @create 2023/3/7 3:18
 * @description
 */
public interface ConstantBase<T extends Serializable> {
    /**
     * 获取名称,无对应值时返回 ""
     *
     * @param val 常量值
     * @return 常量名称
     */
    String getName(T val);

    /**
     * 获取分类名称
     *
     * @return 类型名
     */
    default String getCategoryName() {
        return "";
    }

    /**
     * 是否允许用户新增，默认不允许
     *
     * @return Boolean
     */
    default boolean isUserAppend() {
        return false;
    }

    /**
     * 获取名称
     *
     * @param obj 常量值
     * @return 常量名称(参数为Null或不存在该常量 ， 返回Null)
     */
    default String getNameByObject(Object obj) {
        T t = convertByObject(obj);
        return getName(t);
    }

    /**
     * 通过Object转换为当前常量值，不能转换抛出异常
     *
     * @param obj Object类型的参数
     * @return T
     */
    default T convertByObject(Object obj) {
        try {
            return (T) obj;
        } catch (Exception e) {
            throw new BaseException(ConstantResultCode.ERROR_SYS_FAILED_DATA_CONVERT, "未实现数据转换：" + this.getClass().getSimpleName());
        }
    }


    /**
     * 根据名获取常量值
     *
     * @param name 常量名称
     * @return 常量值
     */
    default T getValue(String name) {
        throw new RuntimeException("未实现该功能：根据名获取常量值" + this.getClass().getSimpleName());
    }


}