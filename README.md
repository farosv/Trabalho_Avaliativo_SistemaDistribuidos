# Práticas Fila de Mensagem e Componentes Spring Web .

# Explicação sobre  o código.

- Produtores: Os produtores são responsáveis por criar mensagens de objetos "Veiculo" e enviá-los para uma fila. Cada mensagem contém informações sobre um veículo, como nome do cliente, marca, modelo, ano, valor de venda e dados de publicação. Os produtores podem ser implementados como aplicativos de console independentes.

- Consumidores: Os consumidores são processos que recuperam as mensagens da fila e as processam. No código fornecido, os consumidores consomem as mensagens e adicionam cada objeto "Veiculo" a uma base de dados. Os consumidores também podem ser implementados como aplicativos de console independentes.

- Serviço REST: O sistema também inclui um serviço REST implementado com o Spring Boot. O serviço REST fornece um endpoint (POST) para incluir um veículo classificado na fila. Quando o serviço REST recebe uma permissão para incluir um classificado, ele cria uma mensagem contendo o objeto "Veiculo" e envia para a fila.

- Banco de Dados: O sistema utiliza um banco de dados H2 para armazenar os classificados de veículos. O consumidor recupera as mensagens da fila, processa-as e adiciona os veículos ao banco de dados.

O sistema utiliza uma fila de mensagens (como o RabbitMQ) para garantir o fluxo ordenado de dados entre os produtores, consumidores e o serviço REST.

Essa é uma visão geral do sistema e como as diferentes partes se relacionam para criar um sistema de publicação de anúncios de veículos.

# PASSO A PASSO DE COMO RODAR O CÓDIGO.

1 - Execute o aplicativo de produtor para criar e enviar mensagens contendo objetos Veículo para a fila.

2- Em seguida, inicie o consumidor para recuperar as mensagens da fila, processá-las e adicioná-las ao banco de dados.

3 - Por fim, inicie o serviço REST, que fornecerá o endpoint para inclusão de veículos classificados na fila.

A ordem acima garante que as mensagens sejam enviadas para a fila antes de serem consumidas e que o serviço REST esteja em execução para receber a inscrição de inclusão de classificados.

