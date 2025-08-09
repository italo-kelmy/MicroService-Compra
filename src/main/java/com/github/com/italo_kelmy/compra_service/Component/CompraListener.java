package com.github.com.italo_kelmy.compra_service.Component;

import com.github.com.italo_kelmy.compra_service.Configuration.RabbitMQConfig;
import com.github.com.italo_kelmy.compra_service.Service.CompraService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraListener {
    private final CompraService compraService;

    @Autowired
    public CompraListener(CompraService compraService) {
        this.compraService = compraService;
    }

    @RabbitListener(queues = RabbitMQConfig.FILA_COMPRA)
    public void receberCompra(Produto produto) {
        int quantidade = produto.getQuantidade();
        compraService.finalizarCompra(produto, quantidade);
    }
}
