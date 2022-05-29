package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class HashMapMessageRepository implements MessageRepository{
    HashMap<UUID, Message> hashMap = new HashMap<UUID, Message>();

    @Override
    public UUID create(Message message) {
        return UUID.randomUUID();
    }

    public void addMessage(Message message){
        var id = create(message);
        message.setId(id);
        hashMap.put(id, message);
    }

    public Message findByPrimaryKey(UUID key){
        return hashMap.get(key);
    }
}
