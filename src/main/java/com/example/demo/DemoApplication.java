package com.example.demo;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.destination.BeanFactoryDestinationResolver;

@SpringBootApplication
@ImportResource("classpath:integration.xml")
@EnableJms
@ComponentScan({ "com.example.demo.dao", "com.example.demo.transformers" })
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = new SpringApplication(DemoApplication.class).run(args);
        System.out.println("Hit Enter to terminate");
        System.in.read();
        ctx.close();
    }

    @Bean
    @Primary
    public CachingConnectionFactory jmsConnectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setTargetConnectionFactory(targetConnectionFactory());
        return factory;
    }

    @Bean
    public ActiveMQConnectionFactory targetConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://localhost:61616");
        return factory;
    }

    @Bean
    public BeanFactoryDestinationResolver destinationResolver() {
        return new BeanFactoryDestinationResolver();
    }

    @Bean
    public DefaultMessageListenerContainer jmsContainer() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(jmsConnectionFactory());
        container.setDestination(visitQueue());
        container.setConcurrency("5");
        return container;
    }

    @Bean
    public Queue visitQueue() {
        return new ActiveMQQueue("VisitQueue");
    }

}
