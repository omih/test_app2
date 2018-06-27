package com.zcmx.bit.testbit.ui.fragment;

import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;
import com.zcmx.bit.testbit.R;
import com.zcmx.bit.testbit.ui.dialog.AddPhotoDialog;
import com.zcmx.bit.testbit.viewmodel.ListViewModel;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class ListFragment extends BaseFragment {

    private ListViewModel viewModel;

    private GroupAdapter<ViewHolder> adapter = new GroupAdapter<>();

    private ImageView image;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);

        viewModel.getUserWithCarLiveData().observe(this, this::updateData);
        viewModel.getSelectedPhotoLiveData().observe(this, this::updateImage);
    }

    private void updateImage(final Bitmap bitmap) {
        image.setImageBitmap(bitmap);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView list = view.findViewById(R.id.list_item);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getContext()));

        image = view.findViewById(R.id.image);
        Button addPhotoBtn = view.findViewById(R.id.add_photo);

        addPhotoBtn.setOnClickListener(v -> {
            AddPhotoDialog.newInstance().show(getFragmentManager(), AddPhotoDialog.TAG);
        });

    }

    private void updateData(final List<Item<ViewHolder>> userWithCars) {
        adapter.clear();
        adapter.addAll(userWithCars);
    }
}
