package com.test.mock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ClientData {
    private String message;
    private String accountId;
    private String inn;
    private String hiddenAccountId;
    private String hiddenInn;

    public void setClientAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setClientInn(String inn) {
        this.inn = inn;
    }

    public String getHiddenInn() {
        return hiddenInn;
    }
    public String getHiddenAccountId() {
        return hiddenAccountId;
    }

    public void setHiddenInn(String hiddenInn) {
        System.out.println(hiddenInn);
        this.hiddenInn = hiddenInn;
    }
    public void setHiddenAccountId(String hiddenAccountId) {
        this.hiddenAccountId = hiddenAccountId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void hideData() {
        setHiddenInn(hideCharacters(inn));
        setHiddenAccountId(hideCharacters(accountId));
        }

    public String hideCharacters(String data) {

        int len = data.length() - 4;

        StringBuilder sb = new StringBuilder(data);
        for (int i = 0; i < len; i++) {
            sb.setCharAt(i, '*');
        }
        return sb.toString();
    }


}
