package org.statemachine;

public class OutOfStockState implements State {
    VendingMachine vendingMachine;
    public OutOfStockState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Out of stock");
    }

    @Override
    public void selectItem() {
        System.out.println("Out of stock");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Out of stock");
    }
}
