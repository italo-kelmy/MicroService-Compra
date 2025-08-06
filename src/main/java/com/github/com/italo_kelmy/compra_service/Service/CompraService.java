package com.github.com.italo_kelmy.compra_service.Service;

import com.github.com.italo_kelmy.compra_service.Component.Produto;
import com.github.com.italo_kelmy.compra_service.Entity.Compra;
import com.github.com.italo_kelmy.compra_service.Feign.Microservice;
import com.github.com.italo_kelmy.compra_service.Repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private final CompraRepository repository;
    private final Microservice microservice;

    @Autowired
    public CompraService(CompraRepository repository, Microservice microservice) {
        this.repository = repository;
        this.microservice = microservice;
    }

    public ResponseEntity<?> finalizarCompra(Produto produtoId, int quantidade) {
        Produto produtos = microservice.comprar(produtoId);


        Compra compra = new Compra(
                produtos.getId(),
                quantidade
        );


        if (produtos.getQuantidade() < quantidade) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Quantidade insuficiente");
        }

        if (produtos.getQuantidade() <= 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Apenas quantidade maior que 0");
        }


        repository.save(compra);
        return ResponseEntity.ok("Produto comprado com sucesso");
    }

}
