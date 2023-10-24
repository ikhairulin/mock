package utils;

public class DataGenerator {

    private String clientAccountId;
    private String clientInn;

    private String message;

    private void generateClientAccountId() {
        AccountID accountID = new AccountID();
        this.clientAccountId = accountID.getAccountID();
    }

    private void generateClientInn() {
        Inn inn = new Inn();
        this.clientInn = inn.getInn();
    }

    public void generateRandomData() {
        generateClientAccountId();
        generateClientInn();
        setMessage();
    }

    public void setMessage() {
        this.message = this.clientAccountId + "," + this.clientInn;
    }

    public String getClientAccountId() {
        return clientAccountId;
    }

    public String getClientInn() {
        return clientInn;
    }

    public String getMessage() {
        return message;
    }
}