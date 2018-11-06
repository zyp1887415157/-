package com.lanou.springjpa2.Repository;

import com.lanou.springjpa2.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepositry extends JpaRepository<ModuleEntity,Long> {
}
