package com.zcmx.bit.model.usecase;

import com.zcmx.bit.model.repository.CarRepository;

import io.reactivex.Completable;

public class CarUseCase {

    private CarRepository carRepository;

    public CarUseCase(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Completable loadCars() {
        return carRepository.loadCars();
    }
}
