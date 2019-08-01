package com.example.takhir.mvp.presentation.login;

import android.widget.EditText;

import com.example.takhir.mvp.base.BasePresenter;
import com.example.takhir.mvp.base.BaseView;

@SuppressWarnings("WeakerAccess")
public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void showSuccessfulMessage(String message);
        void showFailedMessage(String message);
        void navigateTo(String email);
    }

    interface Presenter extends BasePresenter {
        boolean validateLoginFields(EditText[] fields);
    }
}
