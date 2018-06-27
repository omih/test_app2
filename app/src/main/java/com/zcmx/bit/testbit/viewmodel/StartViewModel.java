package com.zcmx.bit.testbit.viewmodel;

import com.zcmx.bit.model.usecase.AuthUseCase;
import com.zcmx.bit.testbit.core.cicerone.Screen;
import com.zcmx.bit.testbit.core.di.DI;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class StartViewModel extends BaseViewModel {

    @Inject
    protected Router router;

    @Inject
    protected AuthUseCase authUseCase;

    private boolean isSkippedAuth = false;

    public StartViewModel() {
        DI.getComponentManager().getUserComponent().inject(this);
    }

    public void openStartScreen() {
        if (isSkippedAuth) {
            router.newRootScreen(Screen.INFO_SCREEN);
        } else {
            safeSubscribe(
                    authUseCase.isAuth()
                            .subscribe(isAuth -> {
                                        if (isAuth) {
                                            router.newRootScreen(Screen.INFO_SCREEN);
                                        } else {
                                            router.newRootScreen(Screen.AUTH_SCREEN);
                                        }
                                    }, throwable -> router.newRootScreen(Screen.AUTH_SCREEN)
                            )
            );
        }
    }

    public void skipAuthScreen() {
        isSkippedAuth = true;
    }
}
