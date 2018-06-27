package com.zcmx.bit.model.usecase;

import com.zcmx.bit.model.model.UserWithCar;
import com.zcmx.bit.model.repository.UserWithCarRepository;

import java.util.List;

import io.reactivex.Observable;

public class UserWithCarUseCase {

    private UserWithCarRepository repository;

    public UserWithCarUseCase(final UserWithCarRepository repository) {
        this.repository = repository;
    }

    public Observable<List<UserWithCar>> loadUsersWithCar() {
        return repository.loadUsersWithCar();
    }
}
