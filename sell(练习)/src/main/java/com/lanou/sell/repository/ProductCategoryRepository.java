package com.lanou.sell.repository;

import com.lanou.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    ProductCategory findByCategoryId(int id);

    List<ProductCategory> findByCategoryTypeIn (List<Integer> typeList);


}
