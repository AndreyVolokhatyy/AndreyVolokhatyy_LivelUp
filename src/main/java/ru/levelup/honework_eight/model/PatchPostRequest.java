package ru.levelup.honework_eight.model;

public class PatchPostRequest {

    private String title;

    public PatchPostRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
