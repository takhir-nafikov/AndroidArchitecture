package com.example.takhir.mvp.presentation.register;

import android.widget.EditText;

import com.example.takhir.mvp.base.BasePresenter;
import com.example.takhir.mvp.base.BaseView;

@SuppressWarnings("WeakerAccess")
public interface RegisterContract {

    interface View extends BaseView<Presenter> {
        void showSuccessfulRegister(String message);
        void showErrorRegister(String message);
        void navigateTo();
    }

    interface Presenter extends BasePresenter {
        boolean validateRegisterFields(EditText[] fields);
    }
}
