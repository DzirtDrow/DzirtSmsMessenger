package net.dzirt.dzirtsmsmessenger.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.dzirt.dzirtsmsmessenger.Adapters.SmsThreadAdapter;
import net.dzirt.dzirtsmsmessenger.PermissionsHelper;
import net.dzirt.dzirtsmsmessenger.R;
import net.dzirt.dzirtsmsmessenger.SmsThread;
import net.dzirt.dzirtsmsmessenger.SmsThreadsList;

import static android.Manifest.permission.READ_SMS;

public class MainActivity extends AppCompatActivity {

    //TextView txtDebug;
    ListView smsThreadsListView;
    private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //txtDebug = findViewById(R.id.txt_debug);
        smsThreadsListView = findViewById(R.id.sms_threads_listview);
        if (ContextCompat.checkSelfPermission(this, READ_SMS) != PackageManager.PERMISSION_GRANTED) { //
            if (!shouldShowRequestPermissionRationale(Manifest.permission.READ_SMS)) {
                requestPermissions(new String[]{Manifest.permission.READ_SMS}, REQUEST_CODE_ASK_PERMISSIONS);

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, REQUEST_CODE_ASK_PERMISSIONS);
            }
        } else {
            SmsThreadAdapter smsThreadAdapter = new SmsThreadAdapter(this);
            SmsThreadsList smsThreadsList = new SmsThreadsList();

            smsThreadAdapter.setData(smsThreadsList.getThreads(smsThreadsListView.getRootView())); // TODO: ???
            smsThreadsListView.setAdapter(smsThreadAdapter);
            smsThreadAdapter.notifyDataSetChanged();
        }
    }
}
