# Práticas Fila de Mensagem e Componentes Spring Web .

#Passo a passo  de como rodar o código.

1 - Execute o aplicativo de produtor para criar e enviar mensagens contendo objetos Veículo para a fila.

2- Em seguida, inicie o consumidor para recuperar as mensagens da fila, processá-las e adicioná-las ao banco de dados.

3 - Por fim, inicie o serviço REST, que fornecerá o endpoint para inclusão de veículos classificados na fila.

A ordem acima garante que as mensagens sejam enviadas para a fila antes de serem consumidas e que o serviço REST esteja em execução para receber a inscrição de inclusão de classificados.

