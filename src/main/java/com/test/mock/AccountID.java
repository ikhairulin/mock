package com.test.mock;

import java.util.Random;

public class AccountID {
    String category = "407";
    String purpose = "02";
    String currency = "810";
    String safeKey = calculateSafeKey();
    String department = generateRandomDigits(4);
    String algorithm = generateRandomDigits(7);
    String  AccountIDNum = calculateAccountID();

    public String calculateSafeKey() {
        int preSafeKey = Integer.parseInt(category) + Integer.parseInt(purpose) + Integer.parseInt(currency);

        preSafeKey = sumDigits(preSafeKey);

        while (preSafeKey > 9) {
            preSafeKey = sumDigits(preSafeKey);
            };

        return Integer.toString(preSafeKey);
    }

    public String calculateAccountID() {
        AccountIDNum = category + purpose + currency + safeKey + department + algorithm;
        return AccountIDNum;
    }
    public String getAccountID() {
        return this.AccountIDNum;
    }

    public static int sumDigits(int number){
        int sum = 0;
        String numString = String.valueOf(number);

        for (int i = 0; i < numString.length(); i++) {
            char digitChar = numString.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            sum += digit;
        }

        return sum;

    }

    public static String generateRandomDigits(int count) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }


}
