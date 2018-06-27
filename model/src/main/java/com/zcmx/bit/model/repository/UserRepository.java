package com.zcmx.bit.model.repository;

import io.reactivex.Completable;

public interface UserRepository {

    Completable loadUsers();
}
