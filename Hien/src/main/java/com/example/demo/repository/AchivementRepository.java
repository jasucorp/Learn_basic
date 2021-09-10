package com.example.demo.repository;

import com.example.demo.model.Achivement;
import com.example.demo.model.Role;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchivementRepository extends JpaRepository<Achivement,Long> {
}