package utils;

public class Inn {
    String region = "51";
    String department = "01";
    String recordNum = AccountID.generateRandomDigits(5);
    String safeKey = calculateSafeKey();
    String InnNum = region + department + recordNum + safeKey;


    public String calculateSafeKey() {

        int preSafeKey = Integer.parseInt(region) + Integer.parseInt(department) + Integer.parseInt(recordNum);

        preSafeKey = AccountID.sumDigits(preSafeKey);

        while (preSafeKey > 9) {
            preSafeKey = AccountID.sumDigits(preSafeKey);
        }
        return Integer.toString(preSafeKey);
    }

    public String getInn() {
        return this.InnNum;
    }
}