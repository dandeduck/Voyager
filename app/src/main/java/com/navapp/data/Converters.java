package com.navapp.data;

import androidx.room.TypeConverter;

public class Converters {
    @TypeConverter
    public static int defaultStoreTableToOrdinal(DefaultStoreTable value) {
        return value.ordinal();
    }
    @TypeConverter
    public static DefaultStoreTable ordinalToDefaultStoreTable(int value) {
        switch (value) {
            case 1:
                return DefaultStoreTable.RATE;
            default:
                throw new EnumConstantNotPresentException(DefaultStoreTable.class,
                        String.valueOf(value));
        }
    }
}
