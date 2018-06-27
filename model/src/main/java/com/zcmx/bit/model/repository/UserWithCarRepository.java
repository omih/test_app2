package com.zcmx.bit.model.repository;

import com.zcmx.bit.model.model.UserWithCar;

import java.util.List;

import io.reactivex.Observable;

public interface UserWithCarRepository {

    Observable<List<UserWithCar>> loadUsersWithCar();
}
