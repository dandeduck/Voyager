package com.navapp.data;

import java.util.List;

public class RouteRepository {

    private final AppDatabase mDatabase;
    private final RouteDao mRouteDao;

    public RouteRepository(AppDatabase database) {
        mDatabase = database;
        mRouteDao = database.routeDao();
    }

    public List<Route> getAllRoutes() {
        return mRouteDao.getAll();
    }

    public void insert(Route... routes) {
        mDatabase.executeWrite(()-> {
            mRouteDao.insert(routes);
        });
    }
    public void update(Route... routes) {
        mDatabase.executeWrite(()-> {
            mRouteDao.update(routes);
        });
    }
    public void delete(Route... routes) {
        mDatabase.executeWrite(()-> {
            mRouteDao.delete(routes);
        });
    }
}
