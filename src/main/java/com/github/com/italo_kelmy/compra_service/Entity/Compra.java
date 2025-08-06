package com.github.com.italo_kelmy.compra_service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "compra_de_cliente")
public class Compra {
    @Id
    @NotNull(message = "Id obrigátorio para finalizar a compra")
    private Long produto_id;
    private Long usuario_id;
    @NotNull(message = "Quantidade obrigátorio para poder finalizar a comora")
    private int quantidade;


    public Compra(){

    }

    public Compra(Long produto_id,int quantidade) {
        this.produto_id = produto_id;
        this.quantidade = quantidade;
    }


    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
