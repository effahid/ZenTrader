package com.zentrader.register;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserEntity {
    @Id
    private Long id;

    @NotNull
    private String FirstName;

    @Generated(hash = 1719645899)
    public UserEntity(Long id, @NotNull String FirstName) {
        this.id = id;
        this.FirstName = FirstName;
    }

    @Generated(hash = 1433178141)
    public UserEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

   
}