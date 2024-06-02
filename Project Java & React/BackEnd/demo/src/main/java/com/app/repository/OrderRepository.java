package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
