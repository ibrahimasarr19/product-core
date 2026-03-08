package sn.isi.l3gl.core.service;

import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Créer un produit (0.0.1-SNAPSHOT)
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Lister tous les produits (0.1.0-SNAPSHOT)
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    // Mettre à jour la quantité (0.2.0-SNAPSHOT)
    @Transactional
    public Product updateQuantity(Long id, int newQuantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + id));
        product.setQuantity(newQuantity);
        return product;
    }

    // Compter les produits en stock faible (0.3.0-SNAPSHOT)
    public long countLowStockProducts(int threshold) {
        return productRepository.findAll().stream()
                .filter(p -> p.getQuantity() <= threshold)
                .count();
    }
}