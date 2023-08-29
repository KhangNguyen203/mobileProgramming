package com.example.datlichtocapp.DTO;

public class UserDTO {
    private String username, email, password;

    public UserDTO(String username,String email,String password){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
