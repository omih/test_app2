package com.zcmx.bit.model.usecase;

import com.zcmx.bit.model.repository.AuthRepository;

import io.reactivex.Completable;
import io.reactivex.Single;

public class AuthUseCase {

    private AuthRepository repository;

    public AuthUseCase(final AuthRepository repository) {
        this.repository = repository;
    }

    public Single<Boolean> isAuth() {
        return repository.isAuth();
    }

    public Completable skipAuth() {
        return repository.skipAuth();
    }
}
