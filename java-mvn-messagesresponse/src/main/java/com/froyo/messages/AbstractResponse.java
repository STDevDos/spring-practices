package com.froyo.messages;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractResponse {

    private List<MessagePair> messagePairList = new ArrayList<>();

    public List<MessagePair> getMessagePairList() {
        return messagePairList;
    }

    public void setMessagePairList(List<MessagePair> messagePairList) {
        this.messagePairList = messagePairList;
    }

    public void addMessagePair(MessagePair messagePair) {
        this.messagePairList.add(messagePair);
    }
}

