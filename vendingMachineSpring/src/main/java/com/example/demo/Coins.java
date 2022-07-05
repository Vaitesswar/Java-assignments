package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;

public enum Coins {
	
	QUARTERS (new BigDecimal(0.25).setScale(2, RoundingMode.HALF_UP), "Quarters", 0),
    DIMES (new BigDecimal(0.10).setScale(2, RoundingMode.HALF_UP), "Dimes", 0),
    NICKELS (new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP), "Nickels", 0),
    PENNIES (new BigDecimal(0.01).setScale(2, RoundingMode.HALF_UP), "Pennies", 0);
	
	@Autowired
    final BigDecimal amount;
    final String name;
    int quantity;

    Coins(BigDecimal amount, String name, int quantity){
        this.amount = amount;
        this.name = name;
        this.quantity = quantity;
    }

}


