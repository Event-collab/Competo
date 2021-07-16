package com.StartupBBSR.competo.alarmmanager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.StartupBBSR.competo.Activity.MainActivity;
import com.StartupBBSR.competo.R;

public class alarmmanager extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingintent = PendingIntent.getActivity(context, 0, i, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "chatnotification")
            .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("alarm manager")
                .setContentText("this is alarm manager")
                .setContentIntent(pendingintent)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManager notificationmanager = (NotificationManager) context.getSystemService(NotificationManager.class);

        notificationmanager.notify(2, builder.build());
    }
}
