package ru.levelup.honework_eight.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class CommentsData {

    private String meta;
    private User data;


    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public Long getId() {
        return data.getId();
    }

    public void setId(Long id) {
        data.setId(id);
    }

    public Long getPostId() {
        return data.getPostId();
    }

    public void setPostId(Long id) {
        data.setPostId(id);
    }

    public String getEmail() {
        return data.getEmail();
    }

    public void setEmail(String email) {
        data.setEmail(email);
    }

    public String getName() {
        return data.getName();
    }

    public void setName(String firstName) {
        data.setName(firstName);
    }

    public String getBody() {
        return data.getBody();
    }

    public void setBody(String gender) {
        data.setBody(gender);
    }

    public class User {

        private Long id;
        @JsonProperty("post_id")
        private Long postId;
        private String name;
        private String email;
        private String body;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getPostId() {
            return postId;
        }

        public void setPostId(Long postId) {
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

        public void setBody(String body) {
            this.body = body;
        }
    }
}
