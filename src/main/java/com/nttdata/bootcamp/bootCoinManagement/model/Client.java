package com.nttdata.bootcamp.bootCoinManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String documentNumber;
    private String cellPhoneNumber;
    private String email;
}
