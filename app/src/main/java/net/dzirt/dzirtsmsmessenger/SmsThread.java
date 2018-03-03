package net.dzirt.dzirtsmsmessenger;

/**
 * Created by Dzirt on 02.03.2018.
 */

public class SmsThread {

    private int id;
    private String title;
    private String lastSms;
    private String lastSmsTime;

    public SmsThread(int id, String title, String lastSms, String lastSmsTime) {
        this.id = id;
        this.title = title;
        this.lastSms = lastSms;
        this.lastSmsTime = lastSmsTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastSms() {
        return lastSms;
    }

    public void setLastSms(String lastSms) {
        this.lastSms = lastSms;
    }

    public String getLastSmsTime() {

        return lastSmsTime;
    }

    public void setLastSmsTime(String lastSmsTime) {
        this.lastSmsTime = lastSmsTime;
    }
}
