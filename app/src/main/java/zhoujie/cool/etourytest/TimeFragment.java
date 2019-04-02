package zhoujie.cool.etourytest;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

public class TimeFragment extends Fragment {

    private TextView time_text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.time_fragment, container, false);
        time_text = view.findViewById(R.id.time_text);
        return view;
    }

    public void updateTime(String time, Animation animation) {
        time_text.setText(time);
        time_text.startAnimation(animation);
    }
}

