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

    // 1. Créer un produit
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // 2. Lister tous les produits
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    // 3. Mettre à jour la quantité
    @Transactional
    public Product updateQuantity(Long id, int newQuantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + id));
        product.setQuantity(newQuantity);
        return product; // grâce à @Transactional, la modification est automatiquement persistée
    }

    // 4. Compter les produits avec stock faible (quantité ≤ seuil)
    public long countLowStockProducts(int threshold) {
        return productRepository.findAll().stream()
                .filter(p -> p.getQuantity() <= threshold)
                .count();
    }
}