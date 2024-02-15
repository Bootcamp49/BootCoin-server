package com.nttdata.bootcamp.bootCoinManagement.kafka;

import com.google.gson.Gson;
import com.netflix.discovery.converters.Auto;
import com.nttdata.bootcamp.bootCoinManagement.model.BuyBootCoinEvent;
import com.nttdata.bootcamp.bootCoinManagement.model.ClientEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class BootCoinProducerImpl implements BootCoinProducer{
    @Autowired
    KafkaTemplate<String, ClientEvent> kafkaClientTemplate;
    @Autowired
    KafkaTemplate<String, BuyBootCoinEvent> kafkaBuyTemplate;

    @Autowired
    NewTopic createClient;

    @Autowired
    NewTopic buyBootCoins;
    @Override
    public void createBootCoinClient(ClientEvent event) {
        String eventMessage = eventToJsonString(event);
        Message<String> message = MessageBuilder
                .withPayload(eventMessage)
                .setHeader(KafkaHeaders.TOPIC, createClient.name())
                .build();
        kafkaClientTemplate.send(message);
    }

    @Override
    public void buyBootCoin(BuyBootCoinEvent event) {
        String eventMessage = eventToJsonString(event);
        Message<String> message = MessageBuilder
                .withPayload(eventMessage)
                .setHeader(KafkaHeaders.TOPIC, buyBootCoins.name())
                .build();
        kafkaBuyTemplate.send(message);
    }

    private <T>String eventToJsonString(T event){
        Gson gson = new Gson();
        return gson.toJson(event);
    }
}
