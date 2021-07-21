package com.tutoria.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutoria.manytomany.entity.Canal;

@Repository
public interface CanalRepository extends JpaRepository<Canal, Integer>{

}
