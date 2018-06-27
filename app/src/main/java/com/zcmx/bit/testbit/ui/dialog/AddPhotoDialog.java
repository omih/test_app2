package com.zcmx.bit.testbit.ui.dialog;

import com.zcmx.bit.testbit.R;
import com.zcmx.bit.testbit.viewmodel.AddPhotoViewModel;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class AddPhotoDialog extends DialogFragment {

    public static final String TAG = AddPhotoDialog.class.getName();

    public static AddPhotoDialog newInstance() {
        return new AddPhotoDialog();
    }

    private AddPhotoViewModel viewModel;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(AddPhotoViewModel.class);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(final Dialog dialog, final int style) {
        super.setupDialog(dialog, style);

        View view = LayoutInflater.from(dialog.getContext()).inflate(R.layout.dialog_take_photo, null);

        dialog.setContentView(view);

        TextView camera = view.findViewById(R.id.create_snapshot);
        TextView gallery = view.findViewById(R.id.open_gallery);

        camera.setOnClickListener(v -> {
            AddPhotoDialogPermissionsDispatcher.openCameraWithPermissionCheck(this);
        });

        gallery.setOnClickListener(v -> {
            viewModel.openGallery();
            dismiss();
        });
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    public void openCamera() {
        viewModel.openCamera();
        dismiss();
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AddPhotoDialogPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
