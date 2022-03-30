package com.mypractice.iban;


import java.util.Optional;

public final class Iban {

    static final String DEFAULT_CHECK_DIGIT = "00";
    private String value;

    private Iban(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public CountryCode getCountryCode() {
        return CountryCode.getByCode(CommonUtil.getCountryCode(value));
    }

    public String getCheckDigit() {
        return CommonUtil.getCheckDigit(value);
    }

    public String getAccountNumber() {
        return CommonUtil.getAccountNumber(value);
    }

    public String getBankCode() {
        return CommonUtil.getBankCode(value);
    }

    public String getBranchCode() {
        return CommonUtil.getBranchCode(value);
    }

    public static Iban valueOf(final String iban) {
        CommonUtil.validate(iban);
        return new Iban(iban);
    }

    public final static class Builder {

        private CountryCode countryCode;
        private String bankCode;
        private String branchCode;
        private String accountNumber;

        public Builder() {
        }

        public Builder countryCode(final CountryCode countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder bankCode(final String bankCode) {
            this.bankCode = bankCode;
            return this;
        }

        public Builder branchCode(final String branchCode) {
            this.branchCode = branchCode;
            return this;
        }

        public Builder accountNumber(final String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Iban build() {
            return build(true);
        }

        public Iban build(boolean validate) {
            // require(countryCode, bankCode, accountNumber, branchCode);
            Optional.ofNullable(countryCode).orElseThrow(() -> new RuntimeException("Country Code cannot be null"));
            Optional.ofNullable(bankCode).orElseThrow(() -> new RuntimeException("bank Code cannot be null"));
            Optional.ofNullable(branchCode).orElseThrow(() -> new RuntimeException("branch Code cannot be null"));
            Optional.ofNullable(accountNumber).orElseThrow(() -> new RuntimeException("account number cannot be null"));

            final String formattedIban = formatIban();
            final String checkDigit = CommonUtil.calculateCheckDigit(formattedIban);
            final String ibanValue = CommonUtil.replaceCheckDigit(formattedIban, checkDigit);
            if (validate) CommonUtil.validate(ibanValue);

            return new Iban(ibanValue);
        }

        private String formatIban() {
            final StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(countryCode.getByAlpha2());
            stringBuilder.append(DEFAULT_CHECK_DIGIT);
            stringBuilder.append(formatBban());
            return stringBuilder.toString();
        }

        private String formatBban() {
            final StringBuilder sb = new StringBuilder();
            final IbanStructure structure = IbanStructure.forCountry(countryCode);
            Optional.ofNullable(structure)
                    .orElseThrow(() -> new RuntimeException("country code is not support"));
            for (final IbanStructureEntry entry : structure.getEntries()) {
                switch (entry.getIbanEntryType()) {
                    case BANK_CODE:
                        sb.append(bankCode);
                        break;

                    case BRANCH_CODE:
                        sb.append(branchCode);
                        break;

                    case ACCOUNT_NUMBER:
                        sb.append(accountNumber);
                        break;
                }
            }
            return sb.toString();
        }
    }
}
