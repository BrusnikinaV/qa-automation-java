package com.tcs.edu.decorator;

import com.tcs.edu.service.ValidatedService;

public interface DecorateMessage extends ValidatedService {
    String[] decorate(String[] strings);
}
