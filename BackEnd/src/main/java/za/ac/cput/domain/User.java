/*
 * User.java
 * Entity for user entity
 * Author: Sinethemba Sithela (219112940)
 * Date: 26/08/2023
 */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;

    protected User() {
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.phone = builder.phone;
        this.password=builder.password;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static class Builder {
        private int userId;
        private String name;
        private String surname;
        private String email;
        private String phone;
        private String password;
        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.name = user.name;
            this.surname = user.surname;
            this.email = user.email;
            this.phone = user.phone;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
