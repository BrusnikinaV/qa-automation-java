package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

public class HashMapMessageRepository implements MessageRepository{
    HashMap<UUID, Message> hashMap = new HashMap<UUID, Message>();

    public HashMap<UUID, Message>  create(Message message){
        var id = UUID.randomUUID();
        message.setId(id);
        hashMap.put(id, message);
        return hashMap;
    }

    public Message findByPrimaryKey(UUID key){
        return hashMap.get(key);
    }

    public Collection<Message> findAll() {
        return hashMap.values();
    }

    public Collection<Message> findAll(HashMap<UUID, Message> hashMap) {
        return hashMap.values();
    }

    public Collection<Message> findBySeverity(Severity by) {
        var messageCollection = findAll();
        return messageCollection.stream().filter(ms->ms.getLevel().equals(by)).collect(Collectors.toList());
    }
}
