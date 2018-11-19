package com.lanou.activemq.entity;

import lombok.Data;

import java.io.Serializable;

@Data
// 必须要实现序列化接口   把一个对象转成一个特定格式的
public class MsgEntity implements Serializable {

    private Long id;
    private String mobile;
    private String message;
}
