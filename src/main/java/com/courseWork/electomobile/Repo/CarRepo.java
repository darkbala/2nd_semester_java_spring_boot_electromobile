package com.courseWork.electomobile.Repo;

import com.courseWork.electomobile.Models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<CarModel, Long> {
    @Override
    List<CarModel> findAll();
}
