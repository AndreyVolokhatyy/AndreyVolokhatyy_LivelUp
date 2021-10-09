package ru.levelup.honework_eight.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class PostData {

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

    public void setUserId(Long id) {
        data.setUserId(id);
    }

    public Long getUserId() {
        return data.getUserId();
    }

    public String getTitle() {
        return data.getTitle();
    }

    public void setTitle(String title) {
        data.setTitle(title);
    }

    public String getBody() {
        return data.getBody();
    }

    public void setBody(String body) {
        data.setBody(body);
    }

    public class User {

        private Long id;
        @JsonProperty("user_id")
        private Long userId;
        private String title;
        private String body;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long user_id) {
            this.userId = user_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}
