package com.mypractice.iban;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum CountryCode {
    SA("Saudi Arbia", "SAU");
    private final String name;
    private final String alpha3Char;


    private static Map<String, CountryCode> alpha3Map;

    static {
        alpha3Map = Arrays.stream(values()).collect(Collectors.toMap(CountryCode::getAlpha3Char, c -> c));
    }


    public static CountryCode getByCode(final String code) {
        return Optional.ofNullable(code).map(String::toUpperCase).map(CountryCode::getByAlphaCode).orElseThrow(() -> new RuntimeException("country code cannot be null either"));
    }


    private static CountryCode getByAlphaCode(final String code) {
        switch (code.length()) {
            case 2:
                return getByAlpha2(code);
            case 3:
                return getByAlpha3(code);
            default:
                throw new RuntimeException("Passing invalid Alpha code! alpha code should be either 2 digit or 3 digit");
        }

    }

    private static CountryCode getByAlpha3(String code) {
        return alpha3Map.entrySet().stream().filter(s -> s.getKey().equals(code)).map(m -> m.getValue()).findFirst()
                .orElseThrow(() -> new RuntimeException("passing invalid Alpha code"));
    }

    private static CountryCode getByAlpha2(String code) {
        try {
            return Enum.valueOf(CountryCode.class, code);
        } catch (Exception e) {
            throw new RuntimeException("passing invalid Alpha code");
        }
    }

    public String getByAlpha2() {
        return name();
    }
}


