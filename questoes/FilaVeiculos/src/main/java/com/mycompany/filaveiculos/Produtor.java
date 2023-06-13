package com.mycompany.filaveiculos;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Session;
import java.io.Serializable;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class Produtor {
    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "filaVeiculos";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(QUEUE_NAME);
            MessageProducer producer = session.createProducer(destination);

            // Criar um objeto Veiculo
            Veiculo veiculo = new Veiculo("João da Silva", "Fiat Uno", 2022, 25000.0);

            // Criar a mensagem com o objeto Veiculo
            ObjectMessage message = session.createObjectMessage((Serializable) veiculo);

            // Enviar a mensagem para a fila
            producer.send(message);

            System.out.println("Mensagem enviada: " + message.getObject());

            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
