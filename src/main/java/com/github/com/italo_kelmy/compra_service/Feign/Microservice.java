package com.github.com.italo_kelmy.compra_service.Feign;

import com.github.com.italo_kelmy.compra_service.Component.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "loja-service", url = "https://loja-service:8443", path = "produtos")
public interface Microservice {


    @PostMapping("/comprarProduto")
    Produto comprar(@RequestBody Produto eletronico);

}
