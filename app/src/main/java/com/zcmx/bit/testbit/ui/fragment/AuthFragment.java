package com.zcmx.bit.testbit.ui.fragment;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.zcmx.bit.testbit.R;
import com.zcmx.bit.testbit.viewmodel.AuthViewModel;
import com.zcmx.bit.testbit.viewmodel.StartViewModel;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class AuthFragment extends BaseFragment {

    private CallbackManager callbackManager;

    public static AuthFragment newInstance() {
        return new AuthFragment();
    }

    private AuthViewModel authViewModel;

    private StartViewModel startViewModel;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        authViewModel = ViewModelProviders.of(this).get(AuthViewModel.class);
        startViewModel = ViewModelProviders.of(getActivity()).get(StartViewModel.class);

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        authViewModel.fbAuth();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getContext(), "cancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(getContext(), exception.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button skipBtn = view.findViewById(R.id.skip_btn);

        skipBtn.setOnClickListener(v -> {
            startViewModel.skipAuthScreen();
            authViewModel.skipAuth();
        });

        LoginButton loginButton = view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        loginButton.setFragment(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
