package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long> {

	Orders save(Orders orderFromOrderRequestDto);

}
