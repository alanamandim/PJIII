# 2021-02-projeto-pratico-02-alanamandim

Para executar o programa basta, abrir um terminal ir até a pasta do projeto e dar o seguinte comando: ./gradlew bootRun

Para consumir o serviço rest  abra um terminal e utilize os seguintes comando abaixo utilizando o curl:

Obter motoristas 

curl -L -X GET 'http://localhost:8080/motoristas' 

obter motorista especifico

curl -L -X GET 'http://localhost:8080/motoristas/{4C7254D}'

obter solicitações

curl -L -X GET 'http://localhost:8080/solicitacoes'
 

obter solicitação específica de um motorista

curl -L -X GET 'http://localhost:8080/solicitacoes/Joao'

Adiciona Motorista:

curl -L -X POST 'http://localhost:8080/motoristas/Jose?id=5C7254D'

Adiciona solicitações:

curl -L -X POST 'http://localhost:8080/solicitacoes/abastecimento?id=4C7254D'


Aprova solicitações:

curl -L -X PUT 'http://localhost:8080/solicitacoes/abastecimento/aprovado'


deleta/recusa solicitação

curl -L -X DELETE 'http://localhost:8080/solicitacoes/abastecimento'


