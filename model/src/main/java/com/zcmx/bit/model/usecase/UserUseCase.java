package com.zcmx.bit.model.usecase;

import com.zcmx.bit.model.repository.UserRepository;

import io.reactivex.Completable;

public class UserUseCase {

    private UserRepository userRepository;

    public UserUseCase(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Completable loadUsers() {
        return userRepository.loadUsers();
    }
}
