package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by MacLap on 3/8/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
