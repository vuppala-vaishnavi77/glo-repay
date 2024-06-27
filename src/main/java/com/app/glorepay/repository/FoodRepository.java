package com.app.glorepay.repository;

import com.app.glorepay.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

// make this into a food repository
public interface FoodRepository extends JpaRepository<Food,Long> {
}
