package com.navapp.data;

import java.util.List;

public class AddressRepository {

    private final AppDatabase mDatabase;
    private final AddressDao mAddressDao;

    public AddressRepository(AppDatabase database) {
        mDatabase = database;
        mAddressDao = database.addressDao();
    }

    public List<Address> getAll() {
        return mAddressDao.getAll();
    }

    public void insert(Address... addresses) {
        mDatabase.executeWrite(()-> {
            mAddressDao.insert(addresses);
        });
    }
    public void update(Address... addresses) {
        mDatabase.executeWrite(()-> {
            mAddressDao.update(addresses);
        });
    }
    public void delete(Address... addresses) {
        mDatabase.executeWrite(()-> {
            mAddressDao.delete(addresses);
        });
    }

    public List<Address> getAddressesInRoute(Route route) {
        return mAddressDao.getByRouteId(route.getId());
    }

    public void addAddressToRoute(Route route, Address address) {
        address.setRouteId(route.getId());
        update(address);
    }

    public void removeAddressFromRoute(Address address) {
        address.setRouteId(-1);
        update(address);
    }
}
