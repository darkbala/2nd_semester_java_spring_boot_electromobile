package com.courseWork.electomobile.Controllers;

import com.courseWork.electomobile.Models.ImageModel;
import com.courseWork.electomobile.Repo.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepo imageRepo;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) throws IOException {
        ImageModel image = imageRepo.findById(id).orElse(null);

        // Сжатие изображения
        int targetWidth = 800;
        int targetHeight = 600;

        String format = image.getContentType().split("/")[1]; // Получение формата из contentType

        // Преобразование байтов в BufferedImage
        ByteArrayInputStream inputStream = new ByteArrayInputStream(image.getBytes());
        BufferedImage bufferedImage = ImageIO.read(inputStream);

        // Изменение размеров изображения
        Image resizedImage = bufferedImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);

        // Создание нового BufferedImage с новыми размерами
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resizedImage, 0, 0, null);

        // Преобразование BufferedImage в байты
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(outputImage, format, outputStream);

        return ResponseEntity.ok()
                .header("fileName", image.getOriginFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(outputStream.size())
                .body(new InputStreamResource(new ByteArrayInputStream(outputStream.toByteArray())));
    }
}
