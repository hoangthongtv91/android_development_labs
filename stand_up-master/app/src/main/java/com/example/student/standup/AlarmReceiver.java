package com.example.student.standup;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    private static final int NOTIFICATION_ID = 0;
    private static final String CHANNEL_ID = "Notification_channel";
    private NotificationManager mManager;

    public void deliverNotification(Context context){
        Intent intent = new Intent (context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                NOTIFICATION_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_stand_up)
                .setContentTitle("Stand up alert")
                .setContentText("You should stand up and walk around now")
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        mManager.notify(NOTIFICATION_ID, builder.build());
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        mManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        deliverNotification(context);
    }
}
