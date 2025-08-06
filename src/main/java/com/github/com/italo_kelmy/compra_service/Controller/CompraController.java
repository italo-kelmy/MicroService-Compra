package com.github.com.italo_kelmy.compra_service.Controller;

import com.github.com.italo_kelmy.compra_service.Component.Produto;
import com.github.com.italo_kelmy.compra_service.Service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class CompraController {
    private final CompraService service;

    @Autowired
    public CompraController(CompraService service) {
        this.service = service;
    }

    @PostMapping("/finalizar")
    public ResponseEntity<?>finalizar(@RequestBody Produto produto){
        int quantidade = produto.getQuantidade();
        return service.finalizarCompra(produto, quantidade);
    }


}
