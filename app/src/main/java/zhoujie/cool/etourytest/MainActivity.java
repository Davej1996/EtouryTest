package zhoujie.cool.etourytest;

import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button start;

    private FragmentTransaction transaction;

    Fragment fragment = new TimeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        start.setVisibility(View.GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.time_fragment, fragment);
        transaction.commit();

        CountDownTimer countDownTimer = new CountDownTimer(6 * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                long mf = Math.round((double) millisUntilFinished / 1000);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.time_anim);
                TimeFragment timeFragment = (TimeFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.time_fragment);
                if (timeFragment != null) {
                    timeFragment.updateTime(String.valueOf((int) mf - 1), animation);
                }
            }

            @Override
            public void onFinish() {
                start.setVisibility(View.VISIBLE);
                start.setText("结束");
                FragmentManager fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.remove(fragment);
                transaction.commit();
            }
        };
        countDownTimer.start();
    }

}
