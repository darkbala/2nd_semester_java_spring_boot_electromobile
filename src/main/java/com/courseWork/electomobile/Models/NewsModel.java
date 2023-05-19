package com.courseWork.electomobile.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, anons, full_text;
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "news")
    private List<ImageModel> images = new ArrayList<>();
    private Long previewImageId;


    public void addImageToNews(ImageModel image){
        image.setNews(this);
        images.add(image);
    }
}
