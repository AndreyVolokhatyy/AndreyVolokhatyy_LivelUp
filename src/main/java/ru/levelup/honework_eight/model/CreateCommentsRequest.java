package ru.levelup.honework_eight.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCommentsRequest {

    @JsonProperty("post_id")
    private String postId;
    private String name;
    private String email;
    private String body;

    public CreateCommentsRequest(String postId, String name, String email, String body) {
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setGender(String body) {
        this.body = body;
    }
}
