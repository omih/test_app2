package com.zcmx.bit.data.repository;

import com.zcmx.bit.data.model.entity.AuthorizationEntity;
import com.zcmx.bit.data.network.api.Api;
import com.zcmx.bit.data.scheduler.SchedulerProvider;
import com.zcmx.bit.data.storage.MainDatabase;
import com.zcmx.bit.model.repository.AuthRepository;

import io.reactivex.Completable;
import io.reactivex.Single;

public class AuthDataRepository implements AuthRepository {

    private Api api;

    private MainDatabase db;

    private SchedulerProvider schedulers;


    public AuthDataRepository(final Api api, final MainDatabase db, final SchedulerProvider schedulerProvider) {
        this.api = api;
        this.db = db;
        schedulers = schedulerProvider;
    }

    @Override
    public Single<Boolean> isAuth() {
        return Single.fromCallable(() -> db.getAuthDao().getAuth())
                .map(authorizationEntity -> authorizationEntity.skipAuth)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui());
    }

    @Override
    public Completable skipAuth() {
        return Completable.fromCallable(() -> db.getAuthDao().insert(new AuthorizationEntity(true)))
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui());
    }
}
