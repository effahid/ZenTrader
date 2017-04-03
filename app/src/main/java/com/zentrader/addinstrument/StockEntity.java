package com.zentrader.addinstrument;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class StockEntity {
    @Id
    private Long id;

    private String name;

    @Generated(hash = 165771779)
    public StockEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1239721677)
    public StockEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}