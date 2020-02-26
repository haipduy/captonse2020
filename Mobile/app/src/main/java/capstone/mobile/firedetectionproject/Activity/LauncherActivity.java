package capstone.mobile.firedetectionproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import capstone.mobile.firedetectionproject.Global.GlobalValue;
import capstone.mobile.firedetectionproject.R;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LauncherActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask, GlobalValue.SPINER_LOADING_TIME_OUT);
    }
}
