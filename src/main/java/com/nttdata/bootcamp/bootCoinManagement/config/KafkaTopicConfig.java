package com.nttdata.bootcamp.bootCoinManagement.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic createClient(){
        return TopicBuilder.name("create_bootcoin_client")
                .build();
    }

    public NewTopic buyBootCoins(){
        return TopicBuilder.name("buy_bootcoin")
                .build();
    }
}
