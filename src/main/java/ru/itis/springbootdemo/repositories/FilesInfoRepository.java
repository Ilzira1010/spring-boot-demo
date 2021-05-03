package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.FileInfo;

import java.util.Optional;

public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByAndStorageFileName(String fileName);
    Optional<FileInfo> findById(Long id);
}
