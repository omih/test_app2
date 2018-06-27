package com.zcmx.bit.testbit.core.di.module;

import com.zcmx.bit.data.network.api.Api;
import com.zcmx.bit.data.repository.AuthDataRepository;
import com.zcmx.bit.data.repository.CarDataRepository;
import com.zcmx.bit.data.repository.UserDataRepository;
import com.zcmx.bit.data.repository.UserWithCarDataRepository;
import com.zcmx.bit.data.scheduler.SchedulerProvider;
import com.zcmx.bit.data.storage.MainDatabase;
import com.zcmx.bit.model.repository.AuthRepository;
import com.zcmx.bit.model.repository.CarRepository;
import com.zcmx.bit.model.repository.UserRepository;
import com.zcmx.bit.model.repository.UserWithCarRepository;
import com.zcmx.bit.model.usecase.AuthUseCase;
import com.zcmx.bit.model.usecase.CarUseCase;
import com.zcmx.bit.model.usecase.UserUseCase;
import com.zcmx.bit.model.usecase.UserWithCarUseCase;
import com.zcmx.bit.testbit.core.di.scope.UserScope;

import android.content.ContentResolver;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    @UserScope
    public UserWithCarUseCase getUserWithCarUseCase(UserWithCarRepository repository) {
        return new UserWithCarUseCase(repository);
    }

    @Provides
    @UserScope
    public UserWithCarRepository getUserWithCarRepository(MainDatabase db, SchedulerProvider schedulerProvider) {
        return new UserWithCarDataRepository(db, schedulerProvider);
    }

    @Provides
    @UserScope
    public UserUseCase provideUserUseCase(UserRepository userRepository) {
        return new UserUseCase(userRepository);
    }

    @Provides
    @UserScope
    public UserRepository provideUserDataRepository(Api api, MainDatabase db, SchedulerProvider schedulerProvider) {
        return new UserDataRepository(api, db, schedulerProvider);
    }

    @Provides
    @UserScope
    public CarUseCase provideCarUseCase(CarRepository carRepository) {
        return new CarUseCase(carRepository);
    }

    @Provides
    @UserScope
    public CarRepository provideCarDataRepository(Api api, MainDatabase db, SchedulerProvider schedulerProvider) {
        return new CarDataRepository(api, db, schedulerProvider);
    }

    @Provides
    @UserScope
    public ContentResolver provideContentResolver(Context context) {
        return context.getContentResolver();
    }

    @Provides
    @UserScope
    public AuthRepository provideAuthDataRepository(Api api, MainDatabase db, SchedulerProvider schedulerProvider) {
        return new AuthDataRepository(api, db, schedulerProvider);
    }

    @Provides
    @UserScope
    public AuthUseCase provideAuthUseCase(AuthRepository repository) {
        return new AuthUseCase(repository);
    }
}
