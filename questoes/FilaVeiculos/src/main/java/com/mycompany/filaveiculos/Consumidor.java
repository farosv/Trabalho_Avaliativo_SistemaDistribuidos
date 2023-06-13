package com.mycompany.filaveiculos;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Session;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class Consumidor {
    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "filaVeiculos";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(QUEUE_NAME);
            MessageConsumer consumer = session.createConsumer(destination);

            // Receber a mensagem da fila
            Message message = consumer.receive();

            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Veiculo veiculo = (Veiculo) objectMessage.getObject();

                // Adicionar o veículo na base de dados
                adicionarVeiculoNoBanco(veiculo);

                System.out.println("Veículo adicionado no banco de dados: " + veiculo);
            }

            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private static void adicionarVeiculoNoBanco(Veiculo veiculo) {
        // Lógica para adicionar o veículo no banco de dados
    }
}
