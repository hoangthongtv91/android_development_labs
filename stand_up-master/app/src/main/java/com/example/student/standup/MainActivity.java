package com.example.student.standup;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import javax.net.ssl.ManagerFactoryParameters;

public class MainActivity extends AppCompatActivity {
    private ToggleButton alarmToggle;
    private NotificationManager mManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String CHANNEL_ID = "Notification_channel";
    private Button toastButton;
    private long timeUntilNextAlarm;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmToggle = findViewById(R.id.toggle_button);
        toastButton = findViewById(R.id.toast_button);
        mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent notifyIntent = new Intent(this, AlarmReceiver.class);

        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast(this,
                NOTIFICATION_ID,
                notifyIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String message;
                if (isChecked) {
                    message = "Stand up alarm on";
                    // deliverNotification(MainActivity.this);

                    long repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES / 1000;
                    long triggerTime = SystemClock.elapsedRealtime() + repeatInterval;
                    alarmManager.setInexactRepeating(
                            AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            triggerTime,
                            repeatInterval,
                            notifyPendingIntent);

                } else {
                    message = "stand up alarm off";
                    mManager.cancelAll();
                    if (alarmManager != null) {
                        alarmManager.cancel(notifyPendingIntent);
                    }
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        createNotificationChannel();
        }

    public void createNotificationChannel() {
        mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Stand up notification", NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.setLightColor(Color.BLUE);
            channel.enableVibration(true);
            channel.setDescription("notification for every 15min to stand up");
            mManager.createNotificationChannel(channel);
        }
    }


    public void getNextTime(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            AlarmManager.AlarmClockInfo time = alarmManager.getNextAlarmClock();
            time.getTriggerTime();
            Toast.makeText(MainActivity.this, "" + time, Toast.LENGTH_SHORT).show();
        }
    }
}
