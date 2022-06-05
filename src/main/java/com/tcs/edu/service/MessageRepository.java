package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

import java.util.HashMap;
import java.util.UUID;

public interface MessageRepository {
    UUID addMessage(Message message);
}
