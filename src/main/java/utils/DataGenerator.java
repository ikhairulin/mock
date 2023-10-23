package utils;

public class DataGenerator {

    private String clientAccountId;
    private String clientInn;

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
    }

    public String getClientAccountId() {
        return clientAccountId;
    }

    public String getClientInn() {
        return clientInn;
    }
}
