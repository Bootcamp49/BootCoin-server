package com.nttdata.bootcamp.bootCoinManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyBootCoinEvent {
    private String message;
    private String status;
    private BuyBootCoin buyBootCoin;
}
