package io.javabrains.danangtravel.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @JsonProperty("userId")
    private Integer userId;

    // user Id Format
    @Column(name = "password")
    @JsonProperty("password")
    private String password;

    // user Name
    @Column(name = "user_name")
    @JsonProperty("userName")
    private String userName;

    // address
    @Column(name = "user_address")
    @JsonProperty("userAddress")
    private String userAddress;

    // Phone
    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    // Mail
    @Column(name = "mail")
    @JsonProperty("mail")
    private String mail;

    @Column(name = "role")
    @JsonProperty("role")
    private String role;

    // Flg Account Lock
    @Column(name = "flg_account_lock")
    @JsonProperty("flgAccountLock")
    private String flgAccountLock = "0";

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFlgAccountLock() {
        return flgAccountLock;
    }

    public void setFlgAccountLock(String flgAccountLock) {
        this.flgAccountLock = flgAccountLock;
    }

    public User() {
    }

    public User(Integer userId, String password, String userName, String userAddress, String phoneNumber, String mail, String roleId, String flgAccountLock) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.role = role;
        this.flgAccountLock = flgAccountLock;
    }
}
