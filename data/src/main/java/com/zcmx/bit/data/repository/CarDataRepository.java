package com.zcmx.bit.data.repository;

import com.zcmx.bit.data.converter.CarConverter;
import com.zcmx.bit.data.network.api.Api;
import com.zcmx.bit.data.network.api.ApiActions;
import com.zcmx.bit.data.network.api.response.CarResponse;
import com.zcmx.bit.data.scheduler.SchedulerProvider;
import com.zcmx.bit.data.storage.MainDatabase;
import com.zcmx.bit.model.repository.CarRepository;

import io.reactivex.Completable;

public class CarDataRepository implements CarRepository {

    private MainDatabase db;

    private Api api;

    private SchedulerProvider schedulers;

    public CarDataRepository(final Api api, final MainDatabase db, final SchedulerProvider schedulerProvider) {
        this.api = api;
        this.db = db;
        this.schedulers = schedulerProvider;
    }

    public Completable loadCars() {
        return api.getCars(ApiActions.CARS)
                .map(CarResponse::getCars)
                .flatMapIterable(carDtos -> carDtos)
                .map(CarConverter::toEntity)
                .toList()
                .flatMapCompletable(carEntities -> Completable.fromAction(() -> db.getCarDao().insert(carEntities)))
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui());
    }
}
