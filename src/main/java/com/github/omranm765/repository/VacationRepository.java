package com.github.omranm765.repository;

import com.github.omranm765.entity.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepository extends JpaRepository<VacationEntity, Long> {
    public List<VacationEntity> findByUserName(String name);
}
