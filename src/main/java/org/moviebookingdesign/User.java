package org.moviebookingdesign;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
class User {
    String userId;
    String password;
    String firstName;
    boolean isPremium;

    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    User(String password, String firstName, boolean isPremium) {
        this.userId = "user-" + ID_COUNTER.incrementAndGet();
        this.password = password;
        this.firstName = firstName;
        this.isPremium = isPremium;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
