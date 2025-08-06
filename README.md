# 💳 Compra Service

Este microserviço representa o momento final da compra. Ele recebe os dados do carrinho e consulta o `loja_service` para validar a quantidade em estoque e registrar a compra no banco de dados.

---

## 🎯 Responsabilidades

- Validar a compra
- Reduzir estoque no catálogo
- Registrar os dados da compra no banco

---

## 🛠️ Tecnologias e Recursos

- Spring Boot + REST API
- Spring Data JPA + MySQL
- Feign Client (comunicação com `loja_service`)
- Eureka Client

---

## 🌐 Integração

- Recebe os dados de um produto do cliente
- Se comunica com o `loja_service` para verificar e descontar a quantidade
- Registra no banco a quantidade e o ID da compra

---

## 🚀 Endpoint Principal

- `POST /produto/finalizar` → Finaliza a compra

---

## 🧠 Aprendizado

- Requisições seguras entre serviços com Feign
- Validação de regras de negócio antes de salvar dados
- Fluxo realista de finalização de uma compra
