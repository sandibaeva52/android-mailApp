package com.example.mailapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MailDetailFragment extends Fragment {
    public static final String ARG_ITEM_POS ="mailPOS" ;
private Mails mail;
    public void setArguments(Bundle arguments) {
    }

    public class ARG_ITEM_POS {
    }
    public MailDetailFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_POS)) {
            mail = Mails.items.get(getArguments().getInt(ARG_ITEM_POS));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v =inflater.inflate(R.layout.mail_detail_fragment,container,false);

    if(mail!=null){
        TextView tvName=(TextView)v.findViewById(R.id.tvName);
        tvName.setText(mail.getName());

        TextView tvDesc=(TextView)v.findViewById(R.id.tvDesc);
        tvDesc.setText(mail.getDescription());
    }
    return v;
    }



}
