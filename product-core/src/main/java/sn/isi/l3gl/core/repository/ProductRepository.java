package sn.isi.l3gl.core.repository;

import sn.isi.l3gl.core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si besoin
}