package com.mypractice.authorizationserver.iban;

public class Test {
    public static void main(String[] args) {
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.SA)
                .bankCode("BUPB")
                .branchCode("123456")
                .accountNumber("00123377").build();

        System.out.println(iban);
        System.out.println(Iban.valueOf("SA55BUKB12345600223377").getIbanValue());
    }
}
