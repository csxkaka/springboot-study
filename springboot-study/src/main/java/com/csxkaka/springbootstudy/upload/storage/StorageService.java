package com.csxkaka.springbootstudy.upload.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void deleteAll();

    void init();

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String fileName);

    void store(MultipartFile file);
}
