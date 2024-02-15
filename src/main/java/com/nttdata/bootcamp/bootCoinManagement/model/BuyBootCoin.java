package com.nttdata.bootcamp.bootCoinManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyBootCoin {
    private String clientIdBuy;
    private Double amount;
    private String paymentMethod;
    private Boolean isAccepted;
    private String clientIdSeller;
}
