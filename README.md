# 💳 Compra Service

Este microserviço finaliza as compras recebidas.  
Com a nova integração **RabbitMQ**, ele escuta automaticamente a fila `compra.fila` e processa as compras de forma **assíncrona**, sem depender de requisições diretas.

---

## 🎯 Responsabilidades

- Escutar mensagens de compra enviadas pelo `carrinho_service`
- Validar estoque no `loja_service`
- Reduzir quantidade no catálogo
- Registrar a compra no banco

---

## 🛠️ Tecnologias e Recursos

- Spring Boot + REST API
- Spring Data JPA + MySQL
- Spring Cloud OpenFeign
- Eureka Client
- **Spring AMQP (RabbitMQ)** com listener `@RabbitListener`
- Fila configurada: `compra.fila`

---

## 🌐 Integração

- **Assincronamente**: recebe mensagens do `carrinho_service` via RabbitMQ
- **Sincronamente**: valida estoque com `loja_service` via Feign

---

## 🚀 Funcionamento RabbitMQ

1. O `carrinho_service` envia para a fila `compra.fila` os dados do produto
2. O `CompraListener` consome a mensagem automaticamente
3. O `CompraService` finaliza a compra e registra no banco

---

## 🧠 Aprendizado

- Implementação de consumidores RabbitMQ (`@RabbitListener`)
- Processamento de eventos assíncronos
- Melhoria de desempenho e desacoplamento do fluxo
