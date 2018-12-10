package com.lanou.shiro.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_item")
public class TbItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 添加注解 solr才能查询出来
    @Field
    private Long id;
    @Field
    private String title;
    @Field
    private String sellPoint;
    private Long price;
    private Long num;
    private String barcode;
    private String image;
    private Long cid;
    private Long status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated;

}
