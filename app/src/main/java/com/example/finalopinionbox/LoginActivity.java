package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    public String dbName;

    private static final String TAG = "LoginRegisterActivity";
    int AUTHUI_REQUEST_CODE  = 2910 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (FirebaseAuth.getInstance().getCurrentUser() != null ){
            Toast.makeText(this , " Hi, Welcome Back Again :) " , Toast.LENGTH_LONG).show();
            startActivity(new Intent(this , Main_Menue_Activity.class));
            this.finish();  // user will not come from main activity by back button
        }
    }

    public void handleLoginRegister(View view) {

        List<AuthUI.IdpConfig> provider = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
//                new AuthUI.IdpConfig.PhoneBuilder().build(),
//                new AuthUI.IdpConfig.AppleBuilder().build(),
//                new AuthUI.IdpConfig.FacebookBuilder().build(),
//                new AuthUI.IdpConfig.TwitterBuilder().build(),
//                new AuthUI.IdpConfig.MicrosoftBuilder().build()
        );

        Intent intent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(provider)
                .setTheme(R.style.GreenTheme)
                .setLogo(R.mipmap.ic_launcher)
                .setTosAndPrivacyPolicyUrls("https://example.com/terms.html",
                        "https://example.com/privacy.html")
                .setIsSmartLockEnabled(false)
                .build();

        startActivityForResult(intent , AUTHUI_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == AUTHUI_REQUEST_CODE ){
            if ( resultCode == RESULT_OK ){
                // for login user or new use
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // new user

                if (Objects.requireNonNull(user.getMetadata()).getCreationTimestamp()  == user.getMetadata().getLastSignInTimestamp()){
                    Toast.makeText(this , " Welcome new user " ,Toast.LENGTH_LONG).show();
                    startActivity(new Intent( this , GetInfoActivity.class));
                    finish();
                } else {
                    Toast.makeText(this , " Welcome back again " ,Toast.LENGTH_LONG).show();
                    startActivity(new Intent( this , Main_Menue_Activity.class));
                    finish();
                }

                Log.d(TAG , "onActivityResult: " + user.getEmail());
                Log.d(TAG , "onActivityResult: " + user.getDisplayName());
                Log.d(TAG , "onActivityResult: " + user.getPhoneNumber());
                Log.d(TAG , "onActivityResult: " + user.getUid());

                dbName = (String) user.getDisplayName();
//                startActivity(new Intent( this , MainActivity.class));
//                finish();

            } else {
                // login is failed
                IdpResponse response = IdpResponse.fromResultIntent(data);
                if (response == null){
                    Log.d(TAG, "onActivityResult: the user has cancelled login request");
                } else {
                    Log.e(TAG, "onActivityResult: ",  response.getError());
                }
            }
        }
    }

}
