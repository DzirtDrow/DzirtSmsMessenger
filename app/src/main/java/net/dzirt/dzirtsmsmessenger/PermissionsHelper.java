package net.dzirt.dzirtsmsmessenger;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import static android.Manifest.permission.READ_SMS;
import static android.support.v4.app.ActivityCompat.shouldShowRequestPermissionRationale;

/**
 * Created by Dzirt on 02.03.2018.
 */

public class PermissionsHelper {

    private Context context;

    public PermissionsHelper(Context context) {
        this.context = context;
    }

    public boolean requestSmsReadPermission(){
        if (ContextCompat.checkSelfPermission(context, READ_SMS)!= PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted


            //textView1.setText("Permission allowed");
        }

        return false;
    }


}
