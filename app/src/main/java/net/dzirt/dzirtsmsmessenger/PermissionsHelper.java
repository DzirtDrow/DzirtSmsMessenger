package net.dzirt.dzirtsmsmessenger;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import static android.Manifest.permission.READ_SMS;
import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.app.ActivityCompat.shouldShowRequestPermissionRationale;

/**
 * Created by Dzirt on 02.03.2018.
 */

public class PermissionsHelper {

    private Activity activity;
    int REQUEST_CODE_ASK_PERMISSIONS = 123;

    public PermissionsHelper(Activity activity) {
        this.activity = activity;
    }

    public boolean requestSmsReadPermission(){
        if (ContextCompat.checkSelfPermission(activity, READ_SMS)!= PackageManager.PERMISSION_GRANTED) {
//            if (!shouldShowRequestPermissionRationale(READ_SMS)) {
//                requestPermissions(new String[]{READ_SMS}, REQUEST_CODE_ASK_PERMISSIONS);
//
//            } else {
//                ActivityCompat.requestPermissions(activity, new String[]{READ_SMS}, REQUEST_CODE_ASK_PERMISSIONS);
//            }
//            // Permission is not granted


            //textView1.setText("Permission allowed");
        }

        return false;
    }


}
