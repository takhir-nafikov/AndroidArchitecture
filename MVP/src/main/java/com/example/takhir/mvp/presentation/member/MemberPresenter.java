package com.example.takhir.mvp.presentation.member;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.example.takhir.mvp.R;
import com.example.takhir.mvp.data.db.DbHandler;
import com.example.takhir.mvp.data.model.Member;

@SuppressWarnings("WeakerAccess")
public class MemberPresenter implements MemberContract.Presenter{

    @NonNull
    MemberContract.View view;
    Context context;
    DbHandler dbHandler;
    String fname, lname, phone, email, pass;

    public MemberPresenter(@NonNull MemberContract.View view, Context context){
        this.view = view;
        this.context = context;
        this.view.setPresenter(this);
        dbHandler = new DbHandler(context);
    }

    @Override
    public void getUserEmail(String email) {
        dbHandler.getUserDetails(email);
        getUserDetail(dbHandler.getUserDetails(email));
    }

    @Override
    public void getUserDetail(Member user) {
        view.loadUserDetail(user);
    }

    @Override
    public void deleteAccount(String email) {
        dbHandler.deleteAccount(email);
        if (!dbHandler.deleteAccount(email)){
            view.showSuccess(context.getString(R.string.delete_success));
            view.navigateToNextPage();
        }else{
            view.showFailed(context.getString(R.string.delete_error));
        }
    }

    @Override
    public boolean validateUpdateFields(EditText[] fields) {
        for (EditText fieldsCounter: fields) {
            if (fieldsCounter.getText().toString().isEmpty()){
                fieldsCounter.setError("Заполните поле!");
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

        if (updateUserData(fname, lname, phone, email, pass) == 1){
            view.showSuccess(context.getString(R.string.update_success));
            view.refreshPage(email);
        }else{
            view.showFailed(context.getString(R.string.update_error));
        }

    }

    @Override
    public void logOut(String email) {
        if (email != null){
            view.logOut();
        }
    }

    private int updateUserData(String fname, String lname, String phone, String email, String pass){
        Member user = new Member(fname, lname, phone, email, pass);
        return dbHandler.updateUserData(user, email);
    }

    @Override
    public void start() {}
}
