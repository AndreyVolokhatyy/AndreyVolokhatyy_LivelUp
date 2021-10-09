package ru.levelup.honework_eight.model;

public class PatchUserRequest {

    private String name;

    public PatchUserRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
