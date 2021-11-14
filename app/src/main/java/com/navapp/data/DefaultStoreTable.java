package com.navapp.data;

public enum DefaultStoreTable {
    RATE(0) {
        @Override
        long getFromModel(DefaultStoreModel model) {
            return model.getRateId();
        }
        @Override
        void setInModel(DefaultStoreModel model, long rowId) {
            model.setRateId(rowId);
        }
    },
    END_POINT(1) {
        @Override
        long getFromModel(DefaultStoreModel model) {
            return model.getEndPointId();
        }
        @Override
        void setInModel(DefaultStoreModel model, long rowId) {
            model.setEndPointId(rowId);
        }
    }
    ;

    private final int mValue;

    DefaultStoreTable(int value) {
        mValue = value;
    }

    public int intValue() {
        return mValue;
    }

    abstract long getFromModel(DefaultStoreModel model);
    abstract void setInModel(DefaultStoreModel model, long rowId);

    public static DefaultStoreTable fromIntValue(int value) {
        for (DefaultStoreTable table : values()) {
            if (table.intValue() == value) {
                return table;
            }
        }

        throw new EnumConstantNotPresentException(DefaultStoreTable.class, String.valueOf(value));
    }
}
