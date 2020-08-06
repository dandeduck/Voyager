package com.navapp.data;

public enum DefaultStoreTable {
    RATE(0)
    ;

    private final int mValue;

    DefaultStoreTable(int value) {
        mValue = value;
    }

    public int intValue() {
        return mValue;
    }

    public static DefaultStoreTable fromIntValue(int value) {
        for (DefaultStoreTable table : values()) {
            if (table.intValue() == value) {
                return table;
            }
        }

        throw new EnumConstantNotPresentException(DefaultStoreTable.class, String.valueOf(value));
    }
}
