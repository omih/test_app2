package com.zcmx.bit.testbit.viewmodel;

import com.zcmx.bit.testbit.core.di.DI;
import com.zcmx.bit.testbit.core.model.ResultCode;

import android.net.Uri;

import java.io.File;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class CameraViewModel extends BaseViewModel {

    @Inject
    protected Router router;

    public CameraViewModel() {
        DI.getComponentManager().getUserComponent().inject(this);
    }

    public void sendPhoto(File file) {
//        router.exitWithResult(ResultCode.SELECTED_PHOTO, file.getAbsolutePath());
        router.exitWithResult(ResultCode.SELECTED_PHOTO, Uri.fromFile(file));
    }
}
