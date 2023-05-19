package com.courseWork.electomobile.Repo;

import com.courseWork.electomobile.Models.NewsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewRepo extends JpaRepository<NewsModel, Long> {
    @Override
    List<NewsModel> findAll();

}
