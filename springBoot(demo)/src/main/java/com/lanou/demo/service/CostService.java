package com.lanou.demo.service;

import com.lanou.demo.entity.Cost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CostService extends JpaRepository<Cost, Long> {

//    @Query(value = "select * from Cost where costId=:costId",nativeQuery = true)
    @Query("select r from Cost r where r.costId=:costId")
    Cost findCostByCostId(@Param("costId") Long costId);

    @Transactional
    @Modifying
    @Query(value = "insert into cost(name,base_cost) values(?1,?2)", nativeQuery = true)
    int insertCost(String name,Integer baseCost);

}
