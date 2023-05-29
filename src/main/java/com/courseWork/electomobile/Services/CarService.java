package com.courseWork.electomobile.Services;

import com.courseWork.electomobile.Models.CarModel;
import com.courseWork.electomobile.Models.ImageModel;
import com.courseWork.electomobile.Repo.CarRepo;
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
public class CarService {
    private final CarRepo carRepo;
    private List<CarModel> cars = new ArrayList<>();

    public List<CarModel> carsList(){
        List<CarModel> cars = carRepo.findAll();
        return cars;
    }

    public void saveCar(CarModel car, MultipartFile file1)throws IOException {

        if (!file1.isEmpty()) {
            ImageModel image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            car.addImageToCars(image1);
        }

        log.info("Saving new {}", car);
        CarModel carFromDB = carRepo.save(car);

        if (carFromDB.getImages().size() > 0) {
            ImageModel previewImage = carFromDB.getImages().get(0);
            carFromDB.setPreviewImageId(previewImage.getId());
        }
        carRepo.save(car);
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
    public void deleteCar(Long id){
        carRepo.deleteById(id);
    }

    public CarModel getCarById(Long id){
        return carRepo.findById(id).orElse(null);
    }

}
