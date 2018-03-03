package net.dzirt.dzirtsmsmessenger;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.provider.Telephony;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dzirt on 02.03.2018.
 */

public class SmsThreadsList {
    List<SmsThread> smsThreadsList;

    public SmsThreadsList() {
        smsThreadsList = new ArrayList<>();
    }

    public List<SmsThread> getThreads(View v) {

        Map<Integer, SmsThread> threadMap = new LinkedHashMap<>();

        try {
            Uri uri = Telephony.Sms.CONTENT_URI;//Uri.parse("content://sms");
            Cursor c = v.getContext().getContentResolver().query(uri, new String[]{"thread_id", "person", "date", "body", "address"}, null, null, null);
            smsThreadsList.clear();
            while (c.moveToNext()) {

                String thread_id = c.getString(c.getColumnIndex("thread_id"));
                int thread_id_int = Integer.parseInt(thread_id);

                String body = c.getString(c.getColumnIndex("body"));
                long date = c.getLong(c.getColumnIndex("date"));
                String address = c.getString(c.getColumnIndex("address"));

                SmsThread dialog = new SmsThread(thread_id_int, address, body, Long.toString(date));
                //dialogsList.add(dialog);

                if (!threadMap.containsKey(thread_id_int)) {
                    threadMap.put(thread_id_int, dialog);
                }
                //dialogsList.add(new Dialog(thread_id_int,"test","test","test"));

            }
            for (Map.Entry<Integer, SmsThread> pair : threadMap.entrySet()) {
                smsThreadsList.add(pair.getValue());
            }
        } catch (CursorIndexOutOfBoundsException ee) {
            Toast.makeText(v.getContext(), "Error: " + ee.getMessage(), Toast.LENGTH_LONG).show();
        }
        return smsThreadsList;
    }
}