package net.dzirt.dzirtsmsmessenger;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import net.dzirt.dzirtsmsmessenger.Adapters.OneThreadAdapter;
import net.dzirt.dzirtsmsmessenger.Adapters.SmsThreadAdapter;

import java.util.ArrayList;
import java.util.List;

public class OneThreadActivity extends AppCompatActivity {
    ListView oneThreadListView;

    List<SmsData> smsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_thread);
        oneThreadListView = findViewById(R.id.one_thread_list_view);

        smsList = getSms(getIntent().getIntExtra("thread_id",0));

        OneThreadAdapter oneThreadAdapter = new OneThreadAdapter(this);
        oneThreadAdapter.setData(smsList);
        oneThreadListView.setAdapter(oneThreadAdapter);
        oneThreadAdapter.notifyDataSetChanged();
    }

    public List<SmsData> getSms(int threadId) {
        List<SmsData> resultSmsList = new ArrayList<>();
        View v = oneThreadListView.getRootView();
//        for (int i = 0; i < 10; i++){
//            resultSmsList.add(String.valueOf("Test Number : " + i + "  :  " + threadId));
//        }
        try {
            Uri uri = Telephony.Sms.CONTENT_URI;//Uri.parse("content://sms");
            Cursor c = v.getContext().getContentResolver().query(uri, new String[]{"_id","address","type","date", "body"},
                    "thread_id = ?",new String[] {String.valueOf(threadId)}, null);
            resultSmsList.clear();
            while (c.moveToNext()) {
                String body     = c.getString(c.getColumnIndex("body"));
                String address  = c.getString(c.getColumnIndex("address"));
                long    date   = c.getLong(c.getColumnIndex("date"));
                int     type   = c.getInt(c.getColumnIndex("type"));
                int     id     = c.getInt(c.getColumnIndex("_id"));
                SmsData currentData = new SmsData(id,address,body,date,type);
                resultSmsList.add(currentData);
            }
        } catch (CursorIndexOutOfBoundsException ee) {
        Toast.makeText(v.getContext(), "Error: " + ee.getMessage(), Toast.LENGTH_LONG).show();
    }

        return resultSmsList;
    }
}
