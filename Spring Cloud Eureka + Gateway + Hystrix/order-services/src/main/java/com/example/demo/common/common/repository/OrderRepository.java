package com.example.demo.common.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.common.common.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
