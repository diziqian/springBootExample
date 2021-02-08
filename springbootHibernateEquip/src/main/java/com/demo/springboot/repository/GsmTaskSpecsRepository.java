package com.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot.entity.GsmTaskSpecs;



@Repository
public interface GsmTaskSpecsRepository extends JpaRepository<GsmTaskSpecs, Integer> {

}
