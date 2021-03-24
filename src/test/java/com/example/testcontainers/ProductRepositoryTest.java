package com.example.testcontainers;

import com.example.testcontainers.config.ContainersEnvironment;
import com.example.testcontainers.entities.Product;
import com.example.testcontainers.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestcontainersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductRepositoryTest extends ContainersEnvironment {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void When_GetProducts_Expect_EmptyList(){
        List<Product> list = productRepository.findAll();
        assertEquals(0, list.size());
    }
}
