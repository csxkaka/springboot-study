package com.csxkaka.springbootstudy.upload.controller;

import com.csxkaka.springbootstudy.upload.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLine5 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }

    @Bean
    public CommandLineRunner init(StorageService storageService) {
        return args -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
