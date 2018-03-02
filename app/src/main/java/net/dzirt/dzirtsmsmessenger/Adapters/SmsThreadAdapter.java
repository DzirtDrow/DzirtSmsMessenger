package net.dzirt.dzirtsmsmessenger.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.dzirt.dzirtsmsmessenger.R;
import net.dzirt.dzirtsmsmessenger.SmsThread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dzirt on 02.03.2018.
 */

public class SmsThreadAdapter extends BaseAdapter {
    private List<SmsThread> data = new ArrayList<>();  //Dialogs list
    private LayoutInflater inflater;

    public SmsThreadAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //Инфлейтер чтобы получить View из XML
    }

    public void setData(List<SmsThread> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public SmsThread getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SmsThread currentItem = getItem(i);
        view = inflater.inflate(R.layout.sms_thread_list_item, null);
        TextView.class.cast(view.findViewById(R.id.txt_lastSms)).setText(currentItem.getLastSms());
        TextView.class.cast(view.findViewById(R.id.txt_title)).setText(currentItem.getTitle());
        TextView.class.cast(view.findViewById(R.id.txt_time)).setText(currentItem.getLastSmsTime());




        return view;
    }
}
