package com.example.takhir.mvp.presentation.register;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.example.takhir.mvp.R;
import com.example.takhir.mvp.data.db.DbHandler;
import com.example.takhir.mvp.data.model.Member;

@SuppressWarnings("WeakerAccess")
public class RegisterPresenter implements RegisterContract.Presenter{

    @NonNull
    RegisterContract.View view;
    String fname, lname, phone, email, pass;
    Context context;
    DbHandler dbHandler;

    public RegisterPresenter(@NonNull RegisterContract.View view, Context mContext){
        this.view = view;
        context = mContext;
        this.view.setPresenter(this);
        dbHandler = new DbHandler(context);
    }

    @Override
    public boolean validateRegisterFields(EditText[] fields) {

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

        fname = fields[0].getText().toString();
        lname = fields[1].getText().toString();
        phone = fields[2].getText().toString();
        email = fields[3].getText().toString();
        pass = fields[4].getText().toString();

        if (savingData(fname, lname, phone, email, pass)){
            view.showSuccessfulRegister(context.getString(R.string.register_success));
        }else{
            view.showErrorRegister(context.getString(R.string.register_error));
        }

    }

    private boolean savingData(String fname, String lname,
                               String phone, String email, String pass){
        Member user = new Member(fname, lname, phone, email, pass);
        return dbHandler.saveUserData(user);
    }

    @Override
    public void start() {}
}

