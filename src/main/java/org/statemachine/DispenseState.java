package org.statemachine;

public class DispenseState implements State {
    VendingMachine vendingMachine;
    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted");
    }

    @Override
    public void selectItem() {
        System.out.println("Item already selected");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Dispensing item...");
        boolean stockAvailable = vendingMachine.updateQuantity();
        if(!stockAvailable) return;
        vendingMachine.setCurrentState(vendingMachine.getNoCoinState());
    }
}
