package com.mypractice.iban;


import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;


public class IbanStructure {

    private final IbanStructureEntry[] entries;

    public IbanStructure(IbanStructureEntry... entries) {
        this.entries = entries;
    }

    private static final EnumMap<CountryCode, IbanStructure> structures;

    static {
        structures = new EnumMap<>(CountryCode.class);
        structures.put(CountryCode.SA, new IbanStructure(
                IbanStructureEntry.bankCode(4, 'A'),
                IbanStructureEntry.branchCode(6, 'N'),
                IbanStructureEntry.accountNumber(8, 'N')));
    }

    public static IbanStructure forCountry(final CountryCode countryCode) {
        return structures.get(countryCode);
    }


    public List<IbanStructureEntry> getEntries() {
        return List.of(entries);
    }

    public int getIbnLength() {
        int length = 0;
        for (IbanStructureEntry entry: entries) {
            System.out.println(entry.getLength());
            length+= entry.getLength();
        }
        return length;
    }
}
