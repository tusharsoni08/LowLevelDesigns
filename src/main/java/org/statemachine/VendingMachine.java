package org.statemachine;

public class VendingMachine {
    private State currentState;

    private State noCoinState;
    private State coinInsertedState;
    private State dispensedState;
    private State outOfStockState;

    int quantity = 0;

    public VendingMachine(int quantity) {
        this.noCoinState = new NoCoinState(this);
        this.coinInsertedState = new CoinInsertedState(this);
        this.dispensedState = new DispenseState(this);
        this.outOfStockState = new OutOfStockState(this);

        this.currentState = outOfStockState;
        this.quantity += quantity;
        if(quantity > 0) {
            this.currentState = noCoinState;
        }
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void selectItem() {
        currentState.selectItem();
    }

    public void dispenseItem() {
        currentState.dispenseItem();
    }

    public boolean updateQuantity() {
        quantity--;
        if(quantity == 0) {
            currentState = outOfStockState;
            return false;
        }
        return true;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
        if(quantity > 0) {
            this.currentState = noCoinState;
        }
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getCoinInsertedState() {
        return coinInsertedState;
    }

    public State getDispensedState() {
        return dispensedState;
    }

    public State getOutOfStockState() {
        return outOfStockState;
    }
}
