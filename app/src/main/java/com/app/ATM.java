package com.app;

public class ATM {
    public ATM() {
        firstItem = new Banknote100(new Banknote50(new Banknote5(null)));
    }

    private Banknote firstItem;

    public void process(int amount) {
        firstItem.process(amount);
    }
}
