package com.froyo.messages;

public class MessagePair {
    private String code;
    private String message;
    private MessagePairTypeCode type;

    public MessagePair() {
    }

    public MessagePair(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public MessagePair(String code, String message, MessagePairTypeCode type) {
        this.code = code;
        this.message = message;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

