package com.zcmx.bit.testbit.ui.fragment;

import com.zcmx.bit.testbit.R;
import com.zcmx.bit.testbit.viewmodel.CameraViewModel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.io.File;

import io.fotoapparat.Fotoapparat;
import io.fotoapparat.view.CameraView;

import static io.fotoapparat.selector.LensPositionSelectorsKt.back;

public class CameraFragment extends Fragment {

    private Fotoapparat fotoapparat;

    private CameraViewModel viewModel;

    private static final String FILE_NAME = "photo.jpg";

    private File file;

    private ProgressBar progress;

    public static CameraFragment newInstance() {
        return new CameraFragment();
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(CameraViewModel.class);
        File dir = getContext().getFilesDir();
        dir.mkdirs();
        file = new File(dir, FILE_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CameraView cameraView = view.findViewById(R.id.camera_view);
        fotoapparat = Fotoapparat
                .with(getContext())
                .into(cameraView)
                .lensPosition(back())
                .build();

        ImageButton button = view.findViewById(R.id.snapshot);
        progress = view.findViewById(R.id.progress);

        button.setOnClickListener(v -> takePicture());
    }

    private void takePicture() {
        progress.setVisibility(View.VISIBLE);
        fotoapparat.takePicture()
                .saveToFile(file)
                .whenDone(unit -> viewModel.sendPhoto(file));
    }


    public void onStart() {
        super.onStart();
        fotoapparat.start();
    }

    public void onStop() {
        super.onStop();
        fotoapparat.stop();
    }
}
