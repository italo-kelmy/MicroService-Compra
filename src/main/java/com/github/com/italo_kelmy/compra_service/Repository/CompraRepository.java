package com.github.com.italo_kelmy.compra_service.Repository;

import com.github.com.italo_kelmy.compra_service.Entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {


}
