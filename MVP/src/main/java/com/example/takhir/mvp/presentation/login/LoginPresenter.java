package com.example.takhir.mvp.presentation.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.example.takhir.mvp.R;
import com.example.takhir.mvp.data.db.DbHandler;

@SuppressWarnings("WeakerAccess")
public class LoginPresenter implements LoginContract.Presenter{

    @NonNull
    LoginContract.View view;
    Context context;
    String email, pass;
    DbHandler dbHandler;

    public LoginPresenter(@NonNull LoginContract.View view, Context context){
        this.view = view;
        this.view.setPresenter(this);
        this.context = context;
        dbHandler = new DbHandler(context);
    }

    //    проверка полей на пустоту
    @Override
    public boolean validateLoginFields(EditText[] fields) {
        for (EditText field: fields){
            if (field.getText().toString().isEmpty()){
                field.setError("Заполните поле!");
                return false;
            }
        }
        validated(fields);
        return true;
    }

    private void validated(EditText[] fields){
        email = fields[0].getText().toString();
        pass = fields[1].getText().toString();
        checkCredentials(email, pass);
    }

    //    проверка существования пользователя
    private void checkCredentials(String email, String pass){
        if (dbHandler.checkUserCredentials(email, pass)){
            view.showSuccessfulMessage(context.getString(R.string.email_pass_valid_success));
            view.navigateTo(email);
        }else{
            view.showFailedMessage(context.getString(R.string.email_pass_valid_err));
        }
    }

    @Override
    public void start() {}
}
