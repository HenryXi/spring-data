package com.henryxi.springdata.keyvalue;


import org.springframework.data.annotation.Id;

public class Person {
    @Id
    private Integer id;
    private String name;
    private Integer chatId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
