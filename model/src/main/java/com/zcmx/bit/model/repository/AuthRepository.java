package com.zcmx.bit.model.repository;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface AuthRepository {

    Single<Boolean> isAuth();

    Completable skipAuth();

}
