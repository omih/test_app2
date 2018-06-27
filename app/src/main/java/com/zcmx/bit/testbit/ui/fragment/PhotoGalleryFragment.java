package com.zcmx.bit.testbit.ui.fragment;

import com.zcmx.bit.testbit.viewmodel.PhotoGalleryViewModel;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;

public class PhotoGalleryFragment extends Fragment {

    private static final int RESULT_LOAD_IMG = 2;

    private PhotoGalleryViewModel viewModel;

    public static PhotoGalleryFragment newInstance() {
        return new PhotoGalleryFragment();
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(PhotoGalleryViewModel.class);

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            final Uri imageUri = data.getData();
            viewModel.sendPhoto(imageUri);
        } else {
            Toast.makeText(getContext(), "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }
}
