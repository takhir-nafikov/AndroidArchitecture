package com.example.takhir.mvp.presentation.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

import com.example.takhir.mvp.R;
import com.example.takhir.mvp.base.BaseActivity;
import com.example.takhir.mvp.presentation.member.MemberActivity;
import com.example.takhir.mvp.presentation.register.RegisterActivity;
import com.example.takhir.mvp.utils.NavUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.email_input)
    EditText et_email;
    @BindView(R.id.pass_input) EditText et_pass;

    LoginContract.Presenter mPresenter;
    LoginPresenter loginPresenter;

    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);

    }

    @OnClick({R.id.btn_register, R.id.btn_login})
    public void buttonClicked(View v){
        switch (v.getId()){
            case R.id.btn_login:
                loginPresenter.validateLoginFields(new EditText[]{et_email, et_pass});
                break;
            case R.id.btn_register:
                NavUtil.startActivity(this,
                        RegisterActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
        }
    }

    @Override
    public void showSuccessfulMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void showFailedMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }

    @Override
    public void navigateTo(String email) {
        NavUtil.startActivity(this,
                MemberActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP,
                email);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter = new LoginPresenter(this, this);
    }
}
