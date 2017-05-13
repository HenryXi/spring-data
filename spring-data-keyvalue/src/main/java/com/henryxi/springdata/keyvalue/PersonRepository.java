package com.henryxi.springdata.keyvalue;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByChatIdOrderBySequenceNumberAsc(String chatId);
    List<Person> removeByChatId(Integer chatId);
    Long deleteByChatId(Integer chatId);
}
