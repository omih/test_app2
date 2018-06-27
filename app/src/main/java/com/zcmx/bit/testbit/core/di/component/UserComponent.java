package com.zcmx.bit.testbit.core.di.component;

import com.zcmx.bit.testbit.core.di.module.UserModule;
import com.zcmx.bit.testbit.core.di.scope.UserScope;
import com.zcmx.bit.testbit.ui.activity.SingleActivity;
import com.zcmx.bit.testbit.viewmodel.AddPhotoViewModel;
import com.zcmx.bit.testbit.viewmodel.AuthViewModel;
import com.zcmx.bit.testbit.viewmodel.CameraViewModel;
import com.zcmx.bit.testbit.viewmodel.ListViewModel;
import com.zcmx.bit.testbit.viewmodel.PhotoGalleryViewModel;
import com.zcmx.bit.testbit.viewmodel.StartViewModel;

import dagger.Subcomponent;

@UserScope
@Subcomponent(modules = {UserModule.class})
public interface UserComponent {

    void inject(ListViewModel listViewModel);

    @Subcomponent.Builder
    interface Builder {

        Builder userModule(UserModule module);

        UserComponent build();

    }

    void inject(AddPhotoViewModel addPhotoViewModel);

    void inject(PhotoGalleryViewModel photoGalleryViewModel);

    void inject(CameraViewModel cameraViewModel);

    void inject(AuthViewModel authViewModel);

    void inject(SingleActivity singleActivity);

    void inject(StartViewModel startViewModel);

}

