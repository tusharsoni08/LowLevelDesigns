package org.example;

public class CashPayment implements PaymentStrategy {
    @Override
    public int calculate(int amount) {
        return 10*amount;
    }
}
