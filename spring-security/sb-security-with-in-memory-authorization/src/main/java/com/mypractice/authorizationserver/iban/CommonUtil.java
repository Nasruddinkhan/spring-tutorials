package com.mypractice.iban;

import java.util.Optional;

public interface CommonUtil {
    int COUNTRY_CODE_INDEX = 0;
    int MAX = 999999999;
    int MOD = 97;
    int COUNTRY_CODE_LENGTH = 2;
    int CHECK_DIGIT_INDEX = 2;
    int CHECK_DIGIT_LENGTH = 2;
    int BBAN_INDEX = CHECK_DIGIT_INDEX + CHECK_DIGIT_LENGTH;

     static String getDigits() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var ch = '0'; ch <='9'; ch++) stringBuilder.append(ch);
        return stringBuilder.toString();
    }

     static String getCharacter() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var ch = 'A'; ch <='Z'; ch++) stringBuilder.append(ch);
        return stringBuilder.toString();
    }

    public static String getCountryCode(String value) {
        return value.substring(COUNTRY_CODE_INDEX, COUNTRY_CODE_INDEX + COUNTRY_CODE_LENGTH);
    }

    public static String getCheckDigit(String value) {
        return value.substring(CHECK_DIGIT_INDEX, CHECK_DIGIT_INDEX + CHECK_DIGIT_LENGTH);
    }

    public static String getAccountNumber(String value) {
        return extractIbanEntry(value, IbanEntryType.ACCOUNT_NUMBER);
    }


    public static String getBankCode(String value) {
        return extractIbanEntry(value, IbanEntryType.BANK_CODE);
    }

    public static String getBranchCode(String value) {
        return extractIbanEntry(value, IbanEntryType.BRANCH_CODE);
    }

    private static String extractIbanEntry(final String iban, IbanEntryType entryType) {
        final String bban = getIban(iban);
        final IbanStructure structure = getIbanStructure(iban);
        int ibnEntryOffSet = 0;
        for (final IbanStructureEntry ibanStructure : structure.getEntries()) {
            final int entryLength = ibanStructure.getLength();
            final String entryValue = bban.substring(ibnEntryOffSet, ibnEntryOffSet + entryLength);
            ibnEntryOffSet = ibnEntryOffSet + ibnEntryOffSet;
            if (ibanStructure.getIbanEntryType() == entryType) return entryValue;
        }
        return null;
    }

    private static IbanStructure getIbanStructure(String iban) {
        final String countryCode = getCountryCode(iban);
        return getIbanStructure(CountryCode.getByCode(countryCode));
    }

    private static IbanStructure getIbanStructure(final CountryCode countryCode) {
        return IbanStructure.forCountry(countryCode);
    }

    private static String getIban(final String iban) {
        return iban.substring(BBAN_INDEX);
    }


    public static void validate(String iban) {
        validateEmpty(iban);
        validateCountryCode(iban);
        validateCheckDigitPresent(iban);
        final IbanStructure ibanStructure = getIbanStructure(iban);
        validateIbanLength(iban, ibanStructure);
        validateIbanEntries(iban, ibanStructure);
        validateCheckDigit(iban);
    }

    private static void validateCheckDigit(String iban) {
        if (calculateMod(iban) != 1) {
            final String checkDigits = getCheckDigit(iban);
            final String expectedCheckDigit = calculateCheckDigit(iban);
            throw new RuntimeException(String.format("[%s] has invalid check digit: %s, expected check digit is : %s", iban, checkDigits, expectedCheckDigit));
        }
    }

    public static String calculateCheckDigit(String iban) {
        final String reformattedIban =  replaceCheckDigit(iban, Iban.DEFAULT_CHECK_DIGIT);
        final int modResult = calculateMod(reformattedIban);
        final int checkDigitIntValue = (98 - modResult);
        final String checkDigit =  Integer.toString(checkDigitIntValue);
        return checkDigitIntValue > 9 ? checkDigit : "0" +checkDigit;
    }

    public static String replaceCheckDigit(String iban, String defaultCheckDigit) {
        return getCountryCode(iban) + defaultCheckDigit + getIban(iban);
    }

    private static int calculateMod(String iban) {
        final String reformattedIban = getIban(iban) + getCountryCodeAndCheckDigit(iban);
        long total = 0;
        for (int i = 0; i < reformattedIban.length(); i++) {
            final int numericValue = Character.getNumericValue(reformattedIban.charAt(i));
            if (numericValue < 0 || numericValue > 35)
                throw new RuntimeException(String.format("invalid character [%d] = '%d'", i, numericValue));
            total = (numericValue > 9 ? total * 100 : total * 10) + numericValue;
            if (total > MAX) total = (total % MOD);
        }
        return (int) (total % MOD);
    }

    private static String getCountryCodeAndCheckDigit(String iban) {
        return iban.substring(COUNTRY_CODE_INDEX, COUNTRY_CODE_INDEX + COUNTRY_CODE_LENGTH + CHECK_DIGIT_LENGTH);
    }

    private static void validateIbanEntries(String iban, IbanStructure ibanStructure) {
        final String bban = getIban(iban);
        int bbanEntryOffset = 0;
        for (final IbanStructureEntry entry : ibanStructure.getEntries()) {
            final int entryLength = entry.getLength();
            final String entryValue = bban.substring(bbanEntryOffset, bbanEntryOffset + entryLength);
            bbanEntryOffset = bbanEntryOffset + entryLength;
            validateIbanEntryCharacterType(entry, entryValue);
        }
    }

    private static void validateIbanEntryCharacterType(IbanStructureEntry entry, String entryValue) {
        switch (entry.getCharacterType()) {
            case A:
                for (var ch : entryValue.toCharArray())
                    if (!Character.isUpperCase(ch)) throw new RuntimeException("Only upper case is allowed");
                break;

            case C:
                for (var ch : entryValue.toCharArray())
                    if (!Character.isLetterOrDigit(ch))
                        throw new RuntimeException("Only upper & digit case is allowed");
                break;
            case N:
                for (var ch : entryValue.toCharArray())
                    if (!Character.isDigit(ch)) throw new RuntimeException("Only digit is  is allowed");
                break;
        }
    }

    private static void validateIbanLength(String iban, IbanStructure ibanStructure) {
        final int expectIbanLength = ibanStructure.getIbnLength();
        final String bban = getIban(iban);
        final int bbanLength = bban.length();
        if (expectIbanLength != bbanLength)
            throw new RuntimeException(String.format("[%s] length is %d and expected length is: %d", bban, bbanLength, expectIbanLength));
    }

    private static void validateCheckDigitPresent(String iban) {
        if (iban.length() < COUNTRY_CODE_LENGTH + CHECK_DIGIT_LENGTH)
            throw new RuntimeException("Iban must contains 2 digits");
        final String checkDigits = getCheckDigit(iban);
        System.out.println(checkDigits);
        if (!Character.isDigit(checkDigits.charAt(0)) ||
                !Character.isDigit(checkDigits.charAt(1)))
            throw new RuntimeException("iban must contain only 2 digit");
    }

    private static void validateCountryCode(String iban) {
        if (iban.length() < COUNTRY_CODE_LENGTH) throw new RuntimeException("Iban must contain only 2 character");
        final String countryCode = getCountryCode(iban);
        if (!countryCode.equals(countryCode.toUpperCase()) ||
                !Character.isLetter(countryCode.charAt(0)) ||
                !Character.isLetter(countryCode.charAt(1)))
            throw new RuntimeException("country must be contains in upper case");
    }

    private static void validateEmpty(final String iban) {
        Optional.ofNullable(iban).orElseThrow(() -> new RuntimeException("IBN Cannot not null or empty"));
    }
}
