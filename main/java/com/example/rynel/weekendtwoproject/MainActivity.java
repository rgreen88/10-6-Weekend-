package com.example.rynel.weekendtwoproject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    public void buttonPressed(View view) {

        switch (view.getId()) {

            //referencing switch/case to pdf button
            case R.id.buttonGoToPDF:

                Intent intent = new Intent(this, PDFActivity.class);
                startActivity(intent);
                break;


            case R.id.buttonGoToDialog:

                //Creating FragmentManager class object and DialogPictureFragment java object
                //to display picture from DialogPictureFragment()
                FragmentManager fm = getSupportFragmentManager();
                final DialogPictureFragment dialogPictureFragment = DialogPictureFragment.newInstance("Pikachu");
                dialogPictureFragment.show(fm, "Pikachu");

                //adding dismiss handler and runnable for 3000 ms = 3 sec
                final Handler handler = new Handler();
                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (dialogPictureFragment.getShowsDialog()) {

                            dialogPictureFragment.dismiss();

                        }
                    }
                };

                //stating the beginning of timed execution
                fm.executePendingTransactions();

                //setting the dismissal
                dialogPictureFragment.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                        //retrieves dismissal signal from runnable
                        handler.removeCallbacks(runnable);

                    }
                });
                //handler executes runnable to dismiss after 3 seconds
                handler.postDelayed(runnable, 3000);
                break;


            case R.id.buttonAlertDialog1:

                AlertDialog.Builder builder;

                //Checking android version to use appropriate dialog support for respective versions
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(this);
                }

                //Dialog choice hit yes for continuing and no for no activity
                builder.setTitle("Alert")
                        .setMessage("Got Milk?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

                break;


            case R.id.buttonAlertDialog2:

                //Alert fragment class turned to object class and used to display custom alert
                DialogAlert customAlertFragment = DialogAlert
                        .newInstance(R.string.alert_2);
                customAlertFragment.show(getSupportFragmentManager(), "dialog");
                break;


            case R.id.buttonAlertDialog3:

                //Alert 3 with a list of options of game genres
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                // Set the dialog title
                builder3.setTitle("Pick Your Game Genres")
                        // Specify the list array, the items to be selected by default (null for none),
                        // and the listener through which to receive callbacks when items are selected
                        .setMultiChoiceItems(R.array.genre, null,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which,
                                                        boolean isChecked) {
                                    }//allows user to select among different genres in xml array list
                                })
                        // Set the action buttons
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //Clicking OK saves mSelected
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //
                            }
                        })
                        .show();
                break;


            case R.id.buttonSendNotification:

                //Using notification builder class
                String CHANNEL_ID = "Yoshi_channel_17";
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.icon1)
                                .setContentTitle("Yoshi Notification System")
                                .setContentText("Yoshi!")
                                .setChannel(CHANNEL_ID);

                //Creating implicit intent for pushing activity on notification
                Intent notiIntent = new Intent();

                // TaskStackBuilder provides a backward-compatible way to obey the correct
                // conventions around cross-task navigation on the device's version of the
                // platform.
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

                //creating an activity that jumps from notification to activity with backstack
                stackBuilder.addParentStack(PDFActivity.class);

                // Adds the Intent that starts the Activity to the top of the stack
                stackBuilder.addNextIntent(notiIntent);

                //r = result
                PendingIntent rpi;

                //PendingIntent for launching task constructed by builder
                rpi = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                //setting intent from mBuilder to mNoti
                mBuilder.setContentIntent(rpi);
                NotificationManager mNoti;
                mNoti = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                // mNotificationId (parameter1) is a unique integer your app uses to identify the
                // notification. For example, to cancel the notification, you can pass its ID
                // number to NotificationManager.cancel().
                mNoti.notify(5, mBuilder.build());
                break;


            //case R.id.buttonSendText:

               /*EditText name;
                EditText phone;

                //bind name and phone
                name = (EditText) findViewById(R.id.etName);
                phone = (EditText) findViewById(R.id.etNum);

                //SmsManager class object to text phone from app
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phone, null, name, null, null);//check vid */

        }

    }

    public void sendSms(EditText name, EditText phone) {

        phone = (EditText) findViewById(R.id.etNum);
        name = (EditText) findViewById(R.id.etName);

        // Get the default instance of SmsManager
        SmsManager smsManager = SmsManager.getDefault();

        // Send a text based SMS
        //smsManager.sendTextMessage(name, null, phone, null, null) <--- error

    }
}


/*

Week 2 Weekend:
Create an android application which
x 1. Have a splash screen when you start the application. Splash screen should have an image like a logo displayed to 2 secs and then go to the main activity.
x 2. Have a pdf file viewer. You can save the pdf file in the res folder.
x 3. Have dialog fragment shows a picture for 3 secs.
x 4. Have a AlertDialog.  
    -with default layout 
    -with custom layout
	-with a list of options to select from (passing xml array)
x 5. Have a feature to send a notification using the NotificationManager and PendingIntent classes. Be creative (the user should be able to go to another activity by clicking on the notification)
6. Have a feature to send text directly from the app with inputs(Edittext) as “Text” and “Phone Number”. Use SmsManager class.
7. Have a activity with two fragments:
Fragment1: two buttons (Start and Stop)
Fragment2: textview
When clicked on the Start, Fragment two should start the counter, when clicked stop the counter should be stopped. Use Timer class/TimerTask

 */