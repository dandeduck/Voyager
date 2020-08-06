package com.navapp.data;

import com.navapp.util.Optional;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EndPointRepository {
    
    private final AppDatabase mDatabase;
    private final EndPointDao mEndPointDao;
    private final DefaultStoreDao mDefaultStoreDao;

    private final ReadWriteLock mDefaultLock;

    public EndPointRepository(AppDatabase database) {
        mDatabase = database;
        mEndPointDao = database.endPointDao();
        mDefaultStoreDao = database.defaultStoreDao();

        mDefaultLock = new ReentrantReadWriteLock();
    }

    public List<EndPoint> getAll() {
        return mEndPointDao.getAll();
    }

    public void insert(EndPoint... endPoints) {
        mDatabase.executeWrite(()-> {
            mEndPointDao.insert(endPoints);
        });
    }
    public void update(EndPoint... endPoints) {
        mDatabase.executeWrite(()-> {
            mEndPointDao.update(endPoints);
        });
    }
    public void delete(EndPoint... endPoints) {
        mDatabase.executeWrite(()-> {
            mDefaultLock.writeLock().lock();
            try {
                DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.END_POINT);
                for (EndPoint endPoint : endPoints) {
                    if (store != null && store.getRowId() == endPoint.getId()) {
                        mDefaultStoreDao.delete(store);
                    }
                }

                mEndPointDao.delete(endPoints);
            } finally {
                mDefaultLock.writeLock().unlock();
            }
        });
    }

    public Optional<EndPoint> getDefault() {
        mDefaultLock.readLock().lock();
        try {
            DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.END_POINT);
            if (store == null) {
                return Optional.empty();
            }
            EndPoint endPoint = mEndPointDao.getById(store.getRowId());
            return Optional.ofNullable(endPoint);
        } finally {
            mDefaultLock.readLock().unlock();
        }
    }

    public void setDefault(EndPoint endPoint) {
        mDatabase.executeWrite(()-> {
            mDefaultLock.writeLock().lock();
            try {
                DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.END_POINT);
                if (store == null) {
                    store = new DefaultStore(DefaultStoreTable.END_POINT, endPoint.getId());
                    mDefaultStoreDao.insert(store);
                } else {
                    store.setRowId(endPoint.getId());
                    mDefaultStoreDao.update(store);
                }
            } finally {
                mDefaultLock.writeLock().unlock();
            }
        });
    }
}
