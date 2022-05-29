package com.tcs.edu.service;

import com.tcs.edu.enums.Severity;

public interface ValidatedService {
    void isArgsValid(Severity level, String message, String... messages);
}
