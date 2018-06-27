package com.zcmx.bit.testbit.viewmodel;

import com.zcmx.bit.testbit.core.di.DI;
import com.zcmx.bit.testbit.core.model.ResultCode;

import android.net.Uri;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class PhotoGalleryViewModel extends BaseViewModel {

    @Inject
    protected Router router;

    public PhotoGalleryViewModel() {
        DI.getComponentManager().getUserComponent().inject(this);
    }

    public void sendPhoto(Uri imageUri) {
        router.exitWithResult(ResultCode.SELECTED_PHOTO, imageUri);
    }
}
