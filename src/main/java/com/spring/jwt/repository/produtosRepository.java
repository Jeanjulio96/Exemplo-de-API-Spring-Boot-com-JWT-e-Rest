package com.spring.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jwt.model.produto;

public interface produtosRepository extends JpaRepository<produto, Long> {

}