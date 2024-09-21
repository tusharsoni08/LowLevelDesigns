package org.statemachine;

public class NoCoinState implements State {
    VendingMachine vendingMachine;
    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin Inserted");
        vendingMachine.setCurrentState(vendingMachine.getCoinInsertedState());
    }

    @Override
    public void selectItem() {
        System.out.println("Please insert a coin");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please insert a coin");
    }
}
