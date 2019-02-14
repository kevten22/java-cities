package com.lambdaschool.javacities;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaCitiesApplication {
    public static final String EXCHANGE_NAME = "LambdaServer";
    public static final String QUEUE_NAME_SECRET = "SecretQueue";
    public static final String QUEUE_NAME_CITIES1 = "Cities1Queue";
    public static final String QUEUE_NAME_CITIES2 = "Cities2Queue";

    public static void main(String[] args) {
        SpringApplication.run(JavaCitiesApplication.class, args);
    }

    @Bean
    public TopicExchange appExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue appQueueSecret(){
        return new Queue(QUEUE_NAME_SECRET);
    }

    @Bean
    public Binding declareBindingSecret(){
        return BindingBuilder.bind(appQueueSecret()).to(appExchange()).with(QUEUE_NAME_SECRET);
    }
@Bean
    public Queue appQueueCitiesOne(){
        return new Queue(QUEUE_NAME_CITIES1);
    }

    @Bean
    public Binding declareBindingCitiesOne(){
        return BindingBuilder.bind(appQueueCitiesOne()).to(appExchange()).with(QUEUE_NAME_CITIES1);
    }
@Bean
    public Queue appQueueCitiesTwo(){
        return new Queue(QUEUE_NAME_CITIES2);
    }

    @Bean
    public Binding declareBindingCitiesTwo(){
        return BindingBuilder.bind(appQueueCitiesTwo()).to(appExchange()).with(QUEUE_NAME_CITIES2);
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}

