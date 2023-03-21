## POC Projeto Swagger API First

Projeto utilizando abordagem API/Contract First

### Ferramentas necessárias para compilação

Para um funcionamento correto do microservice atual são necessárias as seguintes ferramentas instaladas localmente:

- **OpenJDK 11 (Corretto)** *(Java Development Kit).*
- **Apache Maven** *(Versão 3.8.5. Deve estar configurado na varável de ambiente do Windows)*.
- **IDE** *(***IntelliJ IDEA*** ou ***Eclipse STS***).*
- **Swagger** *(Documentação/geração de API).*
- **Git** *(Sistema de controle de versão).*

### Acesso a Documentação da API (Swagger)

Para termos acesso a documentação da *API* localmente podemos acessar o link em seu browser:
```
http://localhost:8099/api/swagger-ui.html/#
```

#### Arquivo de Definição dos contratos das API's
>1. Customers:
    pasta api-contract > customer > customer-api.yml
>2. Pets:
    pasta api-contract > pet > pet-api.yml


#### Local Geração Dos Artefatos
- API's:
target/generated-sources/openapi/swagger/com/company/bff/swagger/api

- Classes de domínio:
target/generated-sources/openapi/swagger/com/company/bff/swagger/domain

#### Ex.: chamadas
```
curl --location --request GET 'localhost:8099/api/customers' \
--data-raw ''
```
```
curl --location --request GET 'localhost:8099/api/pet/1' \
--data-raw ''
```

### Configuração inicial

#### Maven:
>IMPORTANTE: Rodar o comando "mvn clean compile", em seguida "mvn dependency:resolve" 



#### IntelliJ:
>1. Configurar o profile de dev: spring.profiles.active=dev
>2. ***File -> Settings -> Build, Execution, Deployment -> Compiler*** e coloque na opção ***User-local build process VM options (overrides Shared options)***: </br>`-Djps.track.ap.dependencies=false`.
>3. De preferência usar o plugin do swagger (menu File > Settings > Plugins) para facilitar a manutenção dos arquivos yml