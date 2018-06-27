package com.zcmx.bit.data.repository;

import com.zcmx.bit.data.converter.UserWithCarConverter;
import com.zcmx.bit.data.scheduler.SchedulerProvider;
import com.zcmx.bit.data.storage.MainDatabase;
import com.zcmx.bit.model.model.UserWithCar;
import com.zcmx.bit.model.repository.UserWithCarRepository;

import java.util.List;

import io.reactivex.Observable;

public class UserWithCarDataRepository implements UserWithCarRepository {

    private MainDatabase db;

    private SchedulerProvider schedulers;

    public UserWithCarDataRepository(final MainDatabase db, final SchedulerProvider schedulerProvider) {
        this.db = db;
        this.schedulers = schedulerProvider;
    }

    @Override
    public Observable<List<UserWithCar>> loadUsersWithCar() {
        return Observable.fromCallable(() -> db.getUsersWithCarDao().getUsersWithCar())
                .flatMapIterable(userWithCarEntities -> userWithCarEntities)
                .map(UserWithCarConverter::toModel)
                .toList()
                .toObservable()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui());
    }
}
