# Sistema de Pedidos – Design Patterns com Spring Boot

Projeto simples de **API de pedidos** usando **Spring Boot**, criado para praticar **Design Patterns de POO** em um cenário realista, sem overengineering.

---

## Objetivo

* Aplicar Design Patterns na prática
* Organizar o código por responsabilidade
* Usar eventos internos do Spring
* Facilitar manutenção e evolução

---

## Visão geral da arquitetura

```
Controller → Service → Repository
                ↓
             Event
                ↓
            Listener
                ↓
        Payment Service
```

O pedido não conhece a lógica de pagamento, reduzindo acoplamento.

---

## Design Patterns utilizados

### Service Layer

**Onde:** `OrderService`, `PaymentService`

**Uso:** concentra regras de negócio, mantendo o controller apenas como camada de entrada.

**Exemplo:** criação do pedido e atualização do status.

---

### Repository

**Onde:** `OrderRepository`

**Uso:** abstrai o acesso ao banco de dados e evita dependência direta do JPA no restante da aplicação.

---

### DTO (Data Transfer Object)

**Onde:** `OrderRequestDTO`, `OrderResponseDTO`

**Uso:** controla o que entra e sai da API, evitando expor entidades JPA.

---

### Domain Event

**Onde:** `PaymentEvent`

**Uso:** representa o evento de “pedido criado”, desacoplando pedido e pagamento.

**Exemplo:** pedido criado → evento publicado.

---

### Observer (Event Listener)

**Onde:** `PaymentEventListener`

**Uso:** reage ao evento de pagamento sem que o service precise chamar outro diretamente.

---

### Strategy

**Onde:** `PaymentStrategy`, `PixPayment`, `CreditCardPayment`

**Uso:** encapsula regras de pagamento diferentes sem `if/else`.

**Exemplo:**

```java
strategy.pay(amount);
```

---

### Factory (via Spring)

**Onde:** injeção automática das estratégias no `PaymentService`

**Uso:** o Spring gerencia e fornece as implementações sem instanciação manual.
