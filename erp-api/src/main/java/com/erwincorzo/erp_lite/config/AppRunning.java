package com.erwincorzo.erp_lite.config;

import com.erwincorzo.erp_lite.persistence.mongo.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class AppRunning implements ApplicationRunner {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========================");
        this.catalogRepository.findAll().forEach(element -> {
            System.out.println(element.getId() + " - " + element.getName() + " - " + element.getDescription());
        });
        System.out.println("========================");
    }
}
