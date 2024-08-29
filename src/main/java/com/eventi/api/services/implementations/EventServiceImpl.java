package com.eventi.api.services.implementations;

import com.amazonaws.services.s3.AmazonS3;
import com.eventi.api.domain.event.Event;
import com.eventi.api.domain.event.dto.EventRequestDto;
import com.eventi.api.mappers.EventMapper;
import com.eventi.api.repositories.EventRepository;
import com.eventi.api.services.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    @Value("${spring.aws.bucket.name}")
    private String bucketName;

    private final EventMapper mapper;
    private final EventRepository eventRepository;
    private final AmazonS3 s3Client;

    @Override
    @Transactional
    public Event createEvent(EventRequestDto dto) {
        String imgUrl = null;
        if(dto.image() != null) {
            imgUrl = this.uploadImg(dto.image());
        }
        Event entity = mapper.toEntity(dto, imgUrl);
        eventRepository.save(entity);
        return entity;
    }

    private String uploadImg(MultipartFile multipartFile) {
        String filename = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        try {
            File file = this.convertMultipartToFile(multipartFile);
            s3Client.putObject(bucketName, filename, file);
            file.delete();
            return s3Client.getUrl(bucketName, filename).toString();

        } catch (Exception e) {
            log.error("Erro ao enviar arquivo para o S3 Bucket.");
        }
        return null;
    }

    private File convertMultipartToFile(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
