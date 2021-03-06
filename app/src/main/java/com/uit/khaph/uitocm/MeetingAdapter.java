package com.uit.khaph.uitocm;

import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MeetingAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Meeting> listMeeting;
    TextView tvMeetingName;
    TextView tvCreatorName;
    TextView tvInformation;
    FirebaseDatabase database;

    public MeetingAdapter(Context context, int layout, ArrayList<Meeting> listMeeting){
        this.context = context;
        this.layout = layout;
        this.listMeeting = listMeeting;
    }

    @Override
    public int getCount() {
        return listMeeting.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        //mapping
        tvCreatorName = (TextView)convertView.findViewById(R.id.tvCreatorName);
        tvMeetingName = (TextView)convertView.findViewById(R.id.tvMeetingName);
        tvInformation = (TextView)convertView.findViewById(R.id.tvInformation);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imvMeetingPicture);
        //set value
        Meeting meeting = listMeeting.get(position);
        tvMeetingName.setText(meeting.getMeetingName());
        tvInformation.setText(meeting.getInformation());
        if (meeting.getIsEnd().equals("1"))
            tvCreatorName.setText("Cuộc họp đã kết thúc vào ngày " + meeting.getDate());
        else if (meeting.getIsEnd().equals("0")){
            tvCreatorName.setText("Cuộc họp đang diễn ra ");
        }else if (meeting.getIsEnd().equals("2")){
            tvCreatorName.setText("Mới tạo");
        }else{
            imageView.setVisibility(View.GONE);
            tvCreatorName.setVisibility(View.GONE);
        }

        return convertView;
    }
}
