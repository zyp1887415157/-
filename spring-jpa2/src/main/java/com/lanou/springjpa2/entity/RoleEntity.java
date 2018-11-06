package com.lanou.springjpa2.entity;


import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "role_info")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    // 生成之后的表 唯一  不能为空  长度为50
    @Column(name = "name",
            unique = true,
            nullable = false,
            length = 50)
    private String name;

    private Integer deleteFlag;

    @Getter
    @Setter
    @ManyToMany   // 多对多的关系
    @JoinTable(
            //中间表的表名
            name = "role_module",
            // 中间表的列名与当前表的主键相关联
            joinColumns = @JoinColumn(name = "temp_role_id"),
            // 中间表的另一个列名 与另一张表的主键相关联
            inverseJoinColumns = @JoinColumn(name = "temp_module_id")
    )
    private List<ModuleEntity> moduleList = new ArrayList<>();

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
