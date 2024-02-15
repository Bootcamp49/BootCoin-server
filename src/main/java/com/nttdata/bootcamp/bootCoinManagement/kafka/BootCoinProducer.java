package com.nttdata.bootcamp.bootCoinManagement.kafka;

import com.nttdata.bootcamp.bootCoinManagement.model.BuyBootCoinEvent;
import com.nttdata.bootcamp.bootCoinManagement.model.ClientEvent;

public interface BootCoinProducer {
    void createBootCoinClient(ClientEvent event);

    void buyBootCoin(BuyBootCoinEvent event);
}
