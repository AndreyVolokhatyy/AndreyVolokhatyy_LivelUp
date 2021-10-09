package ru.levelup.honework_eight.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class UserData {

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

    public String getGender() {
        return data.getGender();
    }

    public void setGender(String gender) {
        data.setGender(gender);
    }

    public String getStatus() {
        return data.getStatus();
    }

    public void setStatus(String status) {
        data.setStatus(status);
    }

    public class User {

        private Long id;
        private String name;
        private String email;
        private String gender;
        private String status;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String firstName) {
            this.name = firstName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, email, gender, status);
        }

        @Override
        public String toString() {
            return "UserData{"
                + "id=" + id
                + ", name='" + name
                + ", email='" + email + '\''
                + '\'' + ", gender='" + gender + '\''
                + ", status='" + status + '\''
                + '}';
        }
    }
}
