package com.zcmx.bit.testbit.viewmodel;

import com.zcmx.bit.model.usecase.AuthUseCase;
import com.zcmx.bit.testbit.core.cicerone.Screen;
import com.zcmx.bit.testbit.core.di.DI;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class AuthViewModel extends BaseViewModel {

    @Inject
    protected AuthUseCase authUseCase;

    @Inject
    protected Router router;

    public AuthViewModel() {
        DI.getComponentManager().getUserComponent().inject(this);
    }

    public void skipAuth() {
        router.newRootScreen(Screen.INFO_SCREEN);
    }

    public void fbAuth() {
        safeSubscribe(
                authUseCase.skipAuth()
                        .subscribe(() -> router.newRootScreen(Screen.INFO_SCREEN))
        );
    }

}
