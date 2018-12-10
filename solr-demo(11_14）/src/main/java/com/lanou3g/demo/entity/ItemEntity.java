package com.lanou3g.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field
    private long id;
    @Field
    private String title;
    @Field
    private String sellPoint;
    @Field
    private long Price;
    private long Num;
    private String barcode;
    private String Image;
    private long cid;
    private long status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated;

}

