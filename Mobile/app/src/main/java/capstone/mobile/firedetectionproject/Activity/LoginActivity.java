package capstone.mobile.firedetectionproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import capstone.mobile.firedetectionproject.R;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText editUsername, editPassword;
    private TextView txtToSignUp;
    private Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //anh xa
        txtToSignUp = findViewById(R.id.txtToSignUp);
        btnSignIn = findViewById(R.id.btnSignIn);
    }

    @Override
    protected void onStart() {
        super.onStart();

        txtToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSignUp();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void toSignUp(){
        Intent intentToSignUpActivity = new Intent(this,SignUpActivity.class);
        startActivity(intentToSignUpActivity);
        finish();
    }

    private void signIn(){
        Intent intentBtnOnclick= new Intent(this, HomeActivity.class);
        startActivity(intentBtnOnclick);
        finish();
    }

}
