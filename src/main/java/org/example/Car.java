package org.example;

public class Car {
    private String engine;
    private int wheels;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
    }

    public static class Builder {
        private String engine;
        private int wheels;

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
