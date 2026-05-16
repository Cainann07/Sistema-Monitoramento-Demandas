# Sistema de Monitoramento de Demandas

Este é um sistema Full-Stack de nível profissional desenvolvido para gerenciar e monitorar o fluxo de demandas de forma dinâmica. A aplicação resolve problemas clássicos de sincronização de estado, contando com um front-end moderno e totalmente reativo em **Angular** (com **PrimeNG**) e um back-end robusto e escalável construído em **Java com Spring Boot**, utilizando **MySQL** para a persistência dos dados.

---

## 🚀 Tecnologias Utilizadas

### Front-End
* **Angular 18+** (Componentes Standalone, Ciclo de Vida Avançado e Arquitetura Reativa)
* **PrimeNG & PrimeIcons** (Interface moderna com componentes de alta performance como `p-select`, `p-button` e `p-dialog`)
* **RxJS** (Gerenciamento de estado de fluxo contínuo com `BehaviorSubject`)
* **SASS/SCSS** (Estilização modular e estruturada)

### Back-End
* **Java 21**
* **Spring Boot 3+**
    * *Spring Data JPA* (Mapeamento objeto-relacional e abstração de consultas)
    * *Spring Web* (Criação de API RESTful padronizada)
* **Hibernate 7+** (Validação estrita de integridade, tratamento de Enums e persistência)
* **Lombok** (Produtividade e eliminação de código boilerplate)

### Banco de Dados
* **MySQL** (Armazenamento relacional estável)

---

## 📐 Arquitetura e Diferenciais Técnicos

### 1. Comunicação Reativa com Sincronização em Primeiro Clique
O front-end foi arquitetado utilizando **`BehaviorSubject`** do RxJS, estabelecendo um canal contínuo e imutável de dados entre a API e a interface. 
* **O Problema Resolvido:** A reatribuição direta de um *Observable* tradicional quebrava a inscrição (`| async`) do HTML, exigindo cliques duplos do utilizador para forçar o Angular a atualizar a árvore de componentes após inserções ou edições.
* **A Solução:** O template HTML fica permanentemente inscrito no mesmo fluxo de dados. Quando uma ação de Criar, Editar ou Excluir é concluída com sucesso, o método `listarDemandas()` apenas injeta a nova lista no canal ativo usando `.next()`, atualizando a tabela instantaneamente no primeiro clique, sem recarregar a página e sem falhas de renderização.

### 2. Isolamento de Estado nos Modais (Deep Cloning)
Para garantir a integridade visual da aplicação, as telas de inserção e edição trabalham com escopos completamente isolados:
* Na edição, o componente realiza uma cópia profunda (*deep clone*) do registro selecionado utilizando o operador spread (`this.demandaEditada = { ...demandaSelecionada };`).
* Isso impede que alterações pendentes ou digitações parciais dentro do modal do PrimeNG se reflitam incorretamente na tabela antes que o utilizador clique de facto em "Salvar".

### 3. Casamento de Contratos e Enums Estritos (Back-to-Front)
* **No Java:** O status das demandas é regido por um Enum (`StatusDemanda`), mapeado de forma estrita como String no banco de dados com `@Enumerated(EnumType.STRING)`.
* **No Banco de Dados:** Garante a consistência impedindo strings inválidas, caixas mistas (`Em andamento`) ou campos em branco, usando rotinas de higienização de dados:

## 📦 Estrutura do Projeto

```text
├── backend/
│   ├── src/main/java/com/grupo2/sistemamonitoramento/
│   │   ├── controller/      # Endpoints da API REST
│   │   ├── model/           # Entidades e Enums (Demanda, StatusDemanda)
│   │   ├── repository/      # Interfaces de acesso ao banco (Spring Data)
│   │   └── service/         # Camada de regras de negócio
│   └── src/main/resources/  # Configurações (application.properties)
│
├── frontend/
│   ├── src/app/
│   │   ├── enums/           # Enums TypeScript equivalentes ao Back-End
│   │   ├── model/           # Interfaces de tipagem dos dados (Demanda)
│   │   ├── pages/           # Componentes de tela (TelaPrincipal)
│   │   └── services/        # Consumo da API HTTP com HttpClient
│   └── angular.json         # Pipeline de build e injeção do PrimeIcons
````
# 🔧 Como Executar o Projeto

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- **Java 21**
- **Node.js** (versão 18 ou superior) e **npm**
- **MySQL Server** configurado e em execução

---

## 1. Configurando o Banco de Dados

Acesse o terminal do MySQL ou uma ferramenta de gerenciamento, como **MySQL Workbench** ou **DBeaver**, e crie o schema do projeto:

```sql
CREATE DATABASE sistema_monitoramento;
```

> **Nota:** Caso o MySQL Workbench bloqueie atualizações em massa devido ao **Safe Update Mode**, a sessão pode ser ajustada dinamicamente com:

```sql
SET SQL_SAFE_UPDATES = 0;
```

---

## 2. Executando o Back-End (Spring Boot)

1. Navegue até a pasta raiz do **back-end**.

2. Configure o usuário e a senha do MySQL no arquivo:

```text
src/main/resources/application.properties
```

3. Inicie a aplicação:

```bash
./mvnw spring-boot:run
```

O servidor da API será iniciado em:

```text
http://localhost:8080
```

---

## 3. Executando o Front-End (Angular)

1. Navegue até a pasta raiz do **front-end**.

2. Instale as dependências e os pacotes necessários:

```bash
npm install
```

3. Inicie o servidor Angular:

```bash
ng serve
```

Abra o navegador no endereço:

```text
http://localhost:4200
```

---

# 🛠️ Endpoints Principais da API (REST)

### `GET /api/demandas`

Recupera a lista completa de demandas monitoradas.

### `POST /api/demandas`

Cria uma nova demanda no sistema.

- O **ID é gerado automaticamente** de forma incremental.

### `PUT /api/demandas`

Atualiza todos os dados e o status de uma demanda existente.

- É necessário informar um **ID válido**.

### `DELETE /api/demandas/{id}`

Remove permanentemente uma demanda do sistema através do ID informado.

---

# 💡 Destaques Técnicos do Projeto

Este projeto contempla melhorias arquiteturais e correções importantes implementadas durante o desenvolvimento:

## ✅ Gerenciamento de Estado no Angular

Foi utilizada uma abordagem baseada em **`BehaviorSubject`**, permitindo fluxos contínuos de dados entre componentes e evitando problemas relacionados ao duplo clique ou perda de atualização de estado.

## ✅ Validação e Higienização de Dados

Foi implementada validação para evitar inconsistências entre **Enums do Hibernate/MySQL e Angular**, prevenindo falhas de desserialização no **Spring Boot**.

## ✅ Organização Arquitetural

A estrutura do projeto está organizada por responsabilidades, separando:

- **`model`** → modelos de dados  
- **`services`** → comunicação HTTP com a API  
- **`pages`** → regras de apresentação e interface  

---

## 🚀 Projeto Pronto para Execução

Após configurar o banco de dados, iniciar o back-end e executar o front-end, o sistema estará disponível localmente e pronto para utilização.
