package com.courseWork.electomobile.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
}

