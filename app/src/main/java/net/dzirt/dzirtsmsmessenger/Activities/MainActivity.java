package net.dzirt.dzirtsmsmessenger.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.dzirt.dzirtsmsmessenger.Adapters.SmsThreadAdapter;
import net.dzirt.dzirtsmsmessenger.OneThreadActivity;
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

        smsThreadsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SmsThread currentThread = (SmsThread) adapterView.getItemAtPosition(i);

                //Toast.makeText(getApplicationContext(),currentThread.getTitle() + " Clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, OneThreadActivity.class);
                intent.putExtra("thread_id", currentThread.getId());
                startActivity(intent);
            }
        });

        smsThreadsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SmsThread currentThread = (SmsThread) adapterView.getItemAtPosition(i);

                Toast.makeText(getApplicationContext(),currentThread.getTitle() + "  Long Click", Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        if (ContextCompat.checkSelfPermission(this, READ_SMS) != PackageManager.PERMISSION_GRANTED) { //Requesting permissions for reading sms
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
