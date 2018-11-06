package com.lanou.sell.repository;

import com.lanou.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {


    @Resource
    private ProductCategoryRepository repository;

    @Test
    public void findOne() {
        ProductCategory byCategoryId = repository.findByCategoryId(1);
        System.out.println(byCategoryId.toString());
    }

    @Test
    @Transactional
    public void saveOne() {
        ProductCategory category = new ProductCategory("女生最爱", 3);

        ProductCategory save = repository.save(category);
        Assert.assertNotEquals(save, true);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> byCategoryTypeIn = repository.findByCategoryTypeIn(list);
        byCategoryTypeIn.forEach(System.out::println);
        Assert.assertNotEquals(0, byCategoryTypeIn.size());
    }
}