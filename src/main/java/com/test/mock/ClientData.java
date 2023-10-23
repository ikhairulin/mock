package com.test.mock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientData {

    String clientAccountId;
    String clientInn;


    private void setClientAccountId() {
        AccountID accountID = new AccountID();
        this.clientAccountId = accountID.getAccountID();
    }

    private void setClientInn() {
        Inn inn = new Inn();
        this.clientInn = inn.getInn();
    }

    public void collectData() {
        setClientAccountId();
        setClientInn();
    }

    public String getClientAccountId() {
        return clientAccountId;
    }

    public String getClientInn() {
        return clientInn;
    }
}