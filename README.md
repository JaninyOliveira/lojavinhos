# lojavinhos

Foi criado um servico REST para buscar as informacões solicitadas referentes a loja de vinho. A aplicação utiliza Spring Boot para 
disponibilizar o serviço, implementar regras de negócio e utilizei embedded H2 database para trabalhar com o JPA. Os endpoints da 
API rest provida estão configurados no arquivo application.properties.



Instalacao:

Instalar JDK 8 + Maven + (JAVA_HOME and PATH)

Clonar repositorio

Abrir CMD

Rodar cd PASTA_CLONADA

Rodar mvn package

Rodar java -jar target/lojavinhos-1.0.0.jar


Endpoints (GET):

# 1 - Liste os clientes ordenados pelo maior valor total em compras.

http://localhost:8080/listarClientesValorTotal

# 2 - Mostre o cliente com maior compra única no último ano (2016).

http://localhost:8080/buscarClienteCompraUnicaAno

# 3 - Liste os clientes mais fiéis.

http://localhost:8080/listarClienteFieis

# 4 - Recomende um vinho para um determinado cliente a partir do histórico de compras.
*** Para este serviço, primeiro busco o produto mais comprado pelo cliente, após busco algum outro produto 
com mesma VARIEDADE. Caso não exista, busco algum produto com a mesma SAFRA.

http://localhost:8080/recomendarProduto/{clienteId}
