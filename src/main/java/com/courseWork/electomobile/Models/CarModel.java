package com.courseWork.electomobile.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {
    public enum CarStatus {
        IN_STOCK,
        TO_ORDER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String price;
    private String powerReserve;
    private String batery;
    private String drivePrivod;
    private String typeCarcas;
    private CarStatus status;

    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cars")
    private List<ImageModel> images = new ArrayList<>();
    private Long previewImageId;

    public void addImageToCars(ImageModel image){
        image.setCars(this);
        images.add(image);
    }
}

