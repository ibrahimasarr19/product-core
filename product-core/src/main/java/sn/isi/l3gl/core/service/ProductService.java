package sn.isi.l3gl.core.service;

import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Méthode pour créer un produit (version 0.0.1-SNAPSHOT)
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}