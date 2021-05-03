package ru.itis.springbootdemo.services.fileStorage;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;

@Component
public interface FileStorageService {
    Long saveFile(MultipartFile file);
    void writeFileToResponse(Long id, HttpServletResponse response);

}
