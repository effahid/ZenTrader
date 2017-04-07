package com.zentrader.register;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserEntity {

    public String Email;

    public String Password;

    @Generated(hash = 1965378423)
    public UserEntity(String Email, String Password) {
        this.Email = Email;
        this.Password = Password;
    }

    @Generated(hash = 1433178141)
    public UserEntity() {
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}