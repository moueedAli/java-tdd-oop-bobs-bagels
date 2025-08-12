package com.booleanuk.core;

public class MemberOfPublic extends User {

    private String name;
    private Basket basket;

    public MemberOfPublic(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }
}

