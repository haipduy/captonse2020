package capstone.mobile.firedetectionproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import capstone.mobile.firedetectionproject.R;

public class SignUpActivity extends AppCompatActivity {
    private TextInputEditText editUsername, editPassword;
    private TextView txtToSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtToSignIn = findViewById(R.id.txtToSignIn);
    }

    @Override
    protected void onStart() {
        super.onStart();

        txtToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSignIn();
            }
        });
    }

    private void toSignIn(){
        Intent intentToSignIn = new Intent(this, LoginActivity.class);
        startActivity(intentToSignIn);
        finish();
    }
}
