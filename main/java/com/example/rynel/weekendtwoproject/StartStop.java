package com.example.rynel.weekendtwoproject;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartStop extends Fragment{

    Button buttonStart;
    Button buttonStop;
    int countDownTimer;
    boolean active;

    public StartStop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_stop, container, false);

    }




   /* @Override
    public void onResume() {
        super.onResume();
        if (countDownTimer != 0) {
            countDownTimer.notifyAll();
            Log.i("TIMER", "notify");
        }
    }*/

    //@Override //code for starting clock
    public void onTick(long l) {

    }

    //@Override //code for wrapping up activity... preferably to not close it automatically
    public void onFinish() {

        //reference: https://developer.android.com/reference/android/os/CountDownTimer.html

    }
}
