package ru.levelup.honework_eight.model;

public class PatchCommentsRequest {

    private String name;

    public PatchCommentsRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
