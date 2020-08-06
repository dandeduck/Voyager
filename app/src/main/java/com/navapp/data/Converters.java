package com.navapp.data;

import androidx.room.TypeConverter;

public class Converters {
    @TypeConverter
    public static int defaultStoreTableToOrdinal(DefaultStoreTable value) {
        return value.intValue();
    }
    @TypeConverter
    public static DefaultStoreTable ordinalToDefaultStoreTable(int value) {
        return DefaultStoreTable.fromIntValue(value);
    }
}
