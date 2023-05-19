package com.courseWork.electomobile.Services;

import com.courseWork.electomobile.Models.ImageModel;
import com.courseWork.electomobile.Models.NewsModel;
import com.courseWork.electomobile.Repo.NewRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewService {
    private final NewRepo newRepo;
    private List<NewsModel> news = new ArrayList<>();

    public List<NewsModel> newsList(){
        List<NewsModel> news = newRepo.findAll();
        return news;
    }

    public void saveNew(NewsModel neww, MultipartFile file1, MultipartFile file2)throws IOException {
        ImageModel image1;
        ImageModel image2;
        if (file1.getSize() != 0){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            neww.addImageToNews(image1);
        }
        if (file2.getSize() != 0){
            image2 = toImageEntity(file1);
            neww.addImageToNews(image2);
        }
        log.info("Saving new {}", neww);
        NewsModel newFromDB = newRepo.save(neww);
        newFromDB.setPreviewImageId(newFromDB.getImages().get(0).getId());
        newRepo.save(neww);
    }

    private ImageModel toImageEntity(MultipartFile file) throws IOException {
        ImageModel image = new ImageModel();
        image.setName(file.getName());
        image.setOriginFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteNews(Long id){
        newRepo.deleteById(id);
    }

    public NewsModel getNewById(Long id){
        return newRepo.findById(id).orElse(null);
    }


}
