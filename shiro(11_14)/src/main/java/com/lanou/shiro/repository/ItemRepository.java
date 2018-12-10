package com.lanou.shiro.repository;

import com.lanou.shiro.entity.TbItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ItemRepository extends JpaRepository<TbItem, Long> {

    @Transactional
    @Modifying
    @Query(value = "update tb_item tb set tb.sell_point = '卖点' where id = ?1 ", nativeQuery = true)
    int update(Long id);


    @Query(value = "select * from tb_item where sell_point = ?1",nativeQuery = true)
    TbItem findBySellPoint(String sellPoint);
}
