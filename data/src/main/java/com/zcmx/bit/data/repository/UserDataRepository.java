package com.zcmx.bit.data.repository;

import com.zcmx.bit.data.converter.UserConverter;
import com.zcmx.bit.data.network.api.Api;
import com.zcmx.bit.data.network.api.ApiActions;
import com.zcmx.bit.data.network.api.response.UserResponse;
import com.zcmx.bit.data.scheduler.SchedulerProvider;
import com.zcmx.bit.data.storage.MainDatabase;
import com.zcmx.bit.model.repository.UserRepository;

import io.reactivex.Completable;

public class UserDataRepository implements UserRepository {

    private MainDatabase db;

    private Api api;

    private SchedulerProvider schedulers;

    public UserDataRepository(final Api api, final MainDatabase db, final SchedulerProvider schedulerProvider) {
        this.api = api;
        this.db = db;
        this.schedulers = schedulerProvider;
    }

    public Completable loadUsers() {
        return api.getUsers(ApiActions.USERS)
                .map(UserResponse::getUsers)
                .flatMapIterable(userDtos -> userDtos)
                .map(UserConverter::toEntity)
                .toList()
                .flatMapCompletable(userEntities -> Completable.fromAction(() -> db.getUserDao().insert(userEntities)))
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui());
    }
}
