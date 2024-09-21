package org.example;

public class OnlinePayment implements PaymentStrategy{
    @Override
    public int calculate(int amount) {
        return 5*amount;
    }
}
