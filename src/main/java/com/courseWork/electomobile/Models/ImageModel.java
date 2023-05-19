package com.courseWork.electomobile.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String originFileName;
    private Long size;
    private String contentType;
    private boolean isPreviewImage;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private NewsModel news;


}
