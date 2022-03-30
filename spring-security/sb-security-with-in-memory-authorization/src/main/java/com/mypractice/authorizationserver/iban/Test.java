package com.mypractice.iban;

//SA55BUKB12345600123377
public class Test {
    public static void main(String[] args) {
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.SA)
                .bankCode("BUKB")
                .branchCode("123456")
                .accountNumber("00123377").build();

        System.out.println(iban);
        System.out.println(Iban.valueOf("SA55BUKB12345600123377"));
    }
}
