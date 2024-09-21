package org.statemachine;

public class CoinInsertedState implements State {
    VendingMachine vendingMachine;
    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Already coin inserted");
    }

    @Override
    public void selectItem() {
        System.out.println("Item is selected");
        vendingMachine.setCurrentState(vendingMachine.getDispensedState());
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please select the item");
    }
}
