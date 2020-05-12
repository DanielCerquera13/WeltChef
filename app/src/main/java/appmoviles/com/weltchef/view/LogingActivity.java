package appmoviles.com.weltchef.view;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

import appmoviles.com.weltchef.R;
import appmoviles.com.weltchef.control.viewcontrollers.LoginController;

public class LogingActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginBtn;
    private LoginButton loginFacebookBtn;
    private Button registerTextButton;
    private TextView loginTxt;
    private boolean isLoggedInFacebook;
    private CallbackManager callbackManager;
    private LoginController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);
        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginBtn = findViewById(R.id.loginBtn);
        registerTextButton = findViewById(R.id.registerTextButton);
        loginTxt = findViewById(R.id.loginTxt);

        controller = new LoginController(this);

        /** Facebook login  **/
        isLoggedInFacebook = (Boolean) this.getIntent().getExtras().get("facebookLogin");
        callbackManager = CallbackManager.Factory.create();
        loginFacebookBtn = findViewById(R.id.loginFacebookBtn);
        loginFacebookBtn.setReadPermissions("email", "public_profile");
        loginFacebookBtn.registerCallback(callbackManager, controller);
        /** End Facebook Login **/



    }

    public EditText getUserNameEditText() {
        return userNameEditText;
    }

    public void setUserNameEditText(EditText userNameEditText) {
        this.userNameEditText = userNameEditText;
    }

    public EditText getPasswordEditText() {
        return passwordEditText;
    }

    public void setPasswordEditText(EditText passwordEditText) {
        this.passwordEditText = passwordEditText;
    }

    public Button getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(Button loginBtn) {
        this.loginBtn = loginBtn;
    }

    public Button getRegisterTextButton() {
        return registerTextButton;
    }

    public boolean isLoggedInFacebook() {
        return isLoggedInFacebook;
    }

    public void setRegisterTextButton(Button registerTextButton) {
        this.registerTextButton = registerTextButton;
    }

    public TextView getLoginTxt() {
        return loginTxt;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode, data);

    }

    @Override
    protected void onResume() {
        super.onResume();
        controller.onResume();
    }

}
