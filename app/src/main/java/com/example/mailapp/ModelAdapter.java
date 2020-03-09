package com.example.mailapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ModelAdapter extends BaseAdapter {
private Context context;
private List<Mails> mails;

public ModelAdapter (Context context, List<Mails> mails){
    this.context=context;
    this.mails=mails;

}
    @Override
    public int getCount() {
        return mails.size();
    }

    @Override
    public Object getItem(int position) {
        return mails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mails.indexOf(getItem(position));
    }
private class ViewHolder{
    TextView tvName;
    TextView tvDescription;
    TextView tvTime;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Mails mail=mails.get(position);
        if (convertView == null) {

            convertView=inflater.inflate(R.layout.mail_list_item, null);
            holder=new ViewHolder();
            holder.tvName=(TextView)convertView.findViewById(R.id.tvName);
            holder.tvDescription=(TextView)convertView.findViewById(R.id.tvDesc);
            holder.tvTime=(TextView)convertView.findViewById(R.id.tvTime);

            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder)convertView.getTag();
        }
        holder.tvName.setText(mail.getName());
        holder.tvDescription.setText(mail.getDescription());
        holder.tvTime.setText(mail.getTime());
        return convertView;
        }
    }

