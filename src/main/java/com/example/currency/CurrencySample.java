package com.example.currency;

import java.util.*;
import java.util.stream.Collectors;

public class CurrencySample {
    public static void viewCurrencyList() {
        Locale.setDefault(Locale.getDefault()); // Set output locale for Currency

        // Get Specific Locale Currency
        Currency currency = Currency.getInstance(Locale.JAPAN);

        // Output All Currency List
        for (Currency c : Currency.getAvailableCurrencies().stream()
                .sorted(Comparator.comparing(Currency::getDisplayName)).collect(Collectors.toList())) {
            System.out.println(c.getDisplayName() + "/" +
                    c.getSymbol() + "/" +
                    c.getCurrencyCode() + "/" +
                    c.getNumericCode() + "/" +
                    c.getDefaultFractionDigits());
        }
    }
}
