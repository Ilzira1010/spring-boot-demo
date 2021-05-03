package ru.itis.springbootdemo.services.fileStorage;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.models.FileInfo;
import ru.itis.springbootdemo.repositories.FilesInfoRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FilesInfoRepository filesInfoRepository;

    @Value("${storage.path}")
    private String storagePath;

    @Override
    public Long saveFile(MultipartFile uploadingFile) {

        String storageName = UUID.randomUUID().toString() + "." +
                FilenameUtils.getExtension(uploadingFile.getOriginalFilename());

        FileInfo file = FileInfo.builder()
                .type(uploadingFile.getContentType())
                .originalFileName(uploadingFile.getOriginalFilename())
                .storageFileName(storageName)
                .size(uploadingFile.getSize())
                .url(storagePath + "\\" + storageName)
                .build();

        try {
            Files.copy(uploadingFile.getInputStream(), Paths.get(storagePath, storageName));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        filesInfoRepository.save(file);
        return file.getId();
    }

    @Override
    public void writeFileToResponse(Long id, HttpServletResponse response) {
        FileInfo fileInfo = filesInfoRepository.findById(id).orElse(null);
        response.setContentType(fileInfo.getType());
        try {
            IOUtils.copy(new FileInputStream(fileInfo.getUrl()), response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
