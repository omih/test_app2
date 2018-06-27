package com.zcmx.bit.model.repository;

import io.reactivex.Completable;

public interface CarRepository {

    Completable loadCars();
}
