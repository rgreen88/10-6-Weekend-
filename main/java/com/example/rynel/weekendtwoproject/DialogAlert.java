package com.example.rynel.weekendtwoproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;

public class DialogAlert extends DialogFragment {

    private static final String TAG = "Simple alert";

    //empty constructor
    public void customAlertFragment() {

    }

    static DialogAlert newInstance(int title) {
        DialogAlert dialogAlert = new DialogAlert();

        //number input
        Bundle args = new Bundle();
        args.putInt("title", title);
        dialogAlert.setArguments(args);

        //returns num to dialogAlert
        return dialogAlert;
    }

    @Override
    //LayoutInflator object created to retrieve alert activity and number above
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");

        Log.d(TAG, "onCreateDialog: " + title);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(getActivity());

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.activity_dialog_alert, null))

                // Add listeners for sign in button
                .setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                //add listener to cancel button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DialogAlert.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
