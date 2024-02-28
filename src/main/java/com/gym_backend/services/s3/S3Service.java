package com.gym_backend.services.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.gym_backend.models.Membre;
import com.gym_backend.repository.MembreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3 s3Client;
    private final MembreRepository membreRepository;

    @Value("${application.bucket.name}")
    private String bucketName;
    public void uploadtos3(MultipartFile file, Long id) throws IOException {

        Membre membre = membreRepository.findById(id).get();

        String imageName = file.getOriginalFilename()+ "_" + System.currentTimeMillis();

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());
        objectMetadata.setContentLength(file.getSize());

        PutObjectRequest request = new PutObjectRequest(bucketName, imageName, file.getInputStream(), objectMetadata);
        s3Client.putObject(request);

        membre.setImage(imageName);
        membreRepository.save(membre);
    }
}
