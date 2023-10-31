package com.test.mock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Session {
    private String timestamp;
    private boolean success;

    public Data getData() {
        return data;
    }

    Data data = new Data();

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }


    public static class Data {
        private String signType;
        private String sessionDataRedisHashId;

        public void setSignType() {
            String sign = "NO_SIGN";
            this.signType = sign;
        }

        public String getSignType() {
            return signType;
        }

        public String getSessionDataRedisHashId() {
            return sessionDataRedisHashId;
        }

        public void setSessionDataRedisHashId() {
            String hashId = "e29c3375-bfce-4ba6-bab6-4f3cd13da667";
            this.sessionDataRedisHashId = hashId;
        }
    }
}
