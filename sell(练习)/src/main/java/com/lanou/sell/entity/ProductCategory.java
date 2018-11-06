package com.lanou.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;

/**
 * 类目表
 */
@Entity
@Table(name = "product_category")
// 动态更新的意思
@DynamicUpdate
@Data
public class ProductCategory {

    // 类目id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    // 类目名字
    private String categoryName;
    // 类目编号
    private Integer categoryType;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }

    //    private Date createTime;
//
//    private Date updateTime;

}
