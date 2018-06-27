package com.zcmx.bit.testbit.viewmodel;

import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;
import com.zcmx.bit.model.model.UserWithCar;
import com.zcmx.bit.model.usecase.CarUseCase;
import com.zcmx.bit.model.usecase.UserUseCase;
import com.zcmx.bit.model.usecase.UserWithCarUseCase;
import com.zcmx.bit.testbit.core.di.DI;
import com.zcmx.bit.testbit.core.model.ResultCode;
import com.zcmx.bit.testbit.ui.item.UserWithCarItem;

import android.arch.lifecycle.MutableLiveData;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.result.ResultListener;

public class ListViewModel extends BaseViewModel implements ResultListener {

    private MutableLiveData<List<Item<ViewHolder>>> userWithCarLiveData = new MutableLiveData<>();

    private MutableLiveData<Bitmap> selectedPhotoLiveData = new MutableLiveData<>();

    @Inject
    protected UserWithCarUseCase userWithCarUseCase;

    @Inject
    protected UserUseCase userUseCase;

    @Inject
    protected CarUseCase carUseCase;

    @Inject
    protected Router router;

    @Inject
    protected ContentResolver contentResolver;

    public ListViewModel() {
        DI.getComponentManager().getUserComponent().inject(this);

        loadUsersWithCar();

        router.setResultListener(ResultCode.SELECTED_PHOTO, this);
    }

    public void loadUsersWithCar() {
        safeSubscribe(
                userUseCase.loadUsers()
                        .mergeWith(carUseCase.loadCars())
                        .andThen(userWithCarUseCase.loadUsersWithCar())
                        .map(this::convertToUiItems)
                        .subscribe(userWithCarLiveData::setValue,
                                throwable -> userWithCarLiveData.setValue(new ArrayList<>()))
        );
    }

    @Override
    public void onResult(final Object resultData) {
        try {
            final InputStream imageStream = contentResolver.openInputStream((Uri) resultData);
            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            selectedPhotoLiveData.setValue(selectedImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Item<ViewHolder>> convertToUiItems(final List<UserWithCar> users) {
        List<Item<ViewHolder>> items = new ArrayList<>();

        if (users != null) {
            for (UserWithCar user : users) {
                items.add(new UserWithCarItem(user));
            }
        }
        return items;
    }

    public MutableLiveData<Bitmap> getSelectedPhotoLiveData() {
        return selectedPhotoLiveData;
    }

    public MutableLiveData<List<Item<ViewHolder>>> getUserWithCarLiveData() {
        return userWithCarLiveData;
    }
}
