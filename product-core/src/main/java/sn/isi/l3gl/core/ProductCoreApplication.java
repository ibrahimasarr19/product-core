package sn.isi.l3gl.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.service.ProductService;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductCoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductService productService) {
        return args -> {
            Product product = new Product("Laptop", "Ordinateur portable", new BigDecimal("1200.00"), 10);
            Product saved = productService.createProduct(product);
            System.out.println("Produit créé avec l'ID : " + saved.getId());
        };
    }
}