package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.service.ValidatedService;

public interface DecorateMessage extends ValidatedService {
    Message[] decorate(Message[] messages);
}
