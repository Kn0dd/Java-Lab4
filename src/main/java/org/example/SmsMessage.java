package org.example;

import lombok.Value;

@Value
public class SmsMessage {
    String phoneNumber;
    String message;
}
