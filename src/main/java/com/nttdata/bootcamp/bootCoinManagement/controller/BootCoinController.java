package com.nttdata.bootcamp.bootCoinManagement.controller;

import com.netflix.discovery.converters.Auto;
import com.nttdata.bootcamp.bootCoinManagement.kafka.BootCoinProducer;
import com.nttdata.bootcamp.bootCoinManagement.model.BuyBootCoin;
import com.nttdata.bootcamp.bootCoinManagement.model.BuyBootCoinEvent;
import com.nttdata.bootcamp.bootCoinManagement.model.Client;
import com.nttdata.bootcamp.bootCoinManagement.model.ClientEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BootCoinController {
    @Autowired
    private BootCoinProducer bootCoinProducer;

    @PostMapping("/createbootcoin")
    public Mono<String> createBootCoinClient(@RequestBody Client client){
        ClientEvent event = new ClientEvent();
        event.setStatus("pending");
        event.setMessage("client status is in pending state");
        event.setClient(client);
        bootCoinProducer.createBootCoinClient(event);
        return Mono.just("Client created successfully");
    }

    public Mono<String> buyBootCoin(@RequestBody BuyBootCoin buyBootCoin){
        BuyBootCoinEvent event = new BuyBootCoinEvent();
        event.setStatus("pending");
        event.setMessage("buy status is in pending state");
        event.setBuyBootCoin(buyBootCoin);
        bootCoinProducer.buyBootCoin(event);
        return Mono.just("Buying bootcoins");
    }
}
