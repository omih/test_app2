package com.zcmx.bit.testbit.viewmodel;

import com.zcmx.bit.testbit.core.cicerone.Screen;
import com.zcmx.bit.testbit.core.di.DI;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class AddPhotoViewModel extends BaseViewModel {

    @Inject
    protected Router router;

    public AddPhotoViewModel() {
        DI.getComponentManager().getUserComponent().inject(this);
    }


    public void openCamera() {
        router.navigateTo(Screen.CAMERA_SCREEN);
    }

    public void openGallery() {
        router.navigateTo(Screen.GALLERY_SCREEN);
    }
}
