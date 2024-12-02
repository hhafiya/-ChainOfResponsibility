package com.app;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public abstract class Banknote {
    private Banknote nextItem;
    private int banknoteNominale;

    public Banknote(int banknoteNominale) {
        this.banknoteNominale = banknoteNominale;
    }
    
    public void process(int amount) {
        int quantity = amount / banknoteNominale;

        if (nextItem != null) {
            nextItem.process(amount % banknoteNominale);
        } else {
            if (amount % banknoteNominale != 0) {
                throw new IllegalArgumentException(
                    "The amount cannot be issued");
            }
        }
        System.out.format(
            "Please receive %d x %d\n", 
            quantity, banknoteNominale);


    }
}
