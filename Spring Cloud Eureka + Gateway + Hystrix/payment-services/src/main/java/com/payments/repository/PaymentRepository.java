package com.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payments.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment findByOrderId(int orderId);
}

