package com.lanou.springjpa2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
// 相当于  get、set，toString
@Data
// 无参的构造方法
@NoArgsConstructor
//  有参的构造方法
@AllArgsConstructor
@Table(name = "module_info")
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    @Column(name = "module_name",
            unique = true,
            nullable = false,
            length = 50)
    private String moduleName;

    //    @JsonManagedReference
//    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "role_module",
//            joinColumns = @JoinColumn(name = "temp_module_id"),
//            inverseJoinColumns = @JoinColumn(name = "temp_role_id")
//    )

//    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = true)
//    @JoinColumn(name = "role_id")
//    private RoleEntity roleEntity;



}
