package org.example;

import java.util.*;

public class User {
    private int id;
    public User(int id) {
        this.id = id;
    }
}

class Parent implements MyInterface{
    public int age;
    int[] arr;

    public Parent(int age) {
        this.age = age;
        arr = new int[age];
    }

    protected String getAge() {
        return hello;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parent)) return false;
        Parent parent = (Parent) o;
        return age == parent.age;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(age);
    }

    @Override
    public void sayHello() {
        Queue<String> queue = new LinkedList<>();
        Queue<String> pq = new PriorityQueue<>();
        pq.offer("A8");
        String poll = queue.poll();
        boolean a1 = queue.contains("A1");
        Deque<String> dq = new LinkedList<>();
        dq.offerLast("A1");
        dq.offerLast("A2");
        dq.offerLast("A3");
        while(!dq.isEmpty()) {
            System.out.println(dq.pollLast());
        }
        String name = "Hello";
        "Hello".compareTo(name);
        if("Hello".equals(name)) {
            System.out.println("Hello");
        }

        String str = new String("Hello");
        System.out.println(str.hashCode());
        System.out.println(name.hashCode());
        System.out.println("Hello".hashCode()%15);

        long result = 1;
        for(char ch : name.toCharArray()) {
            result = result*31 + ch;
        }
        System.out.println(result);
        System.out.println(Objects.hash(age, name));
    }
}

class Child extends Parent {

    public Child(int age) {
        super(age);
    }

    @Override
    public void sayHello() {
        Level level = Level.HIGH;
        super.age = 10;

        switch (level) {
            case HIGH   :  break;
            case MEDIUM : break;
            case LOW    : break;
        }
    }
}

class SubChild extends Child {

    public SubChild(int age) {
        super(age);
    }
}

