package com.example.mailapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.mail_detail_activity);
     if(savedInstanceState==null){
         MailDetailFragment fragment = new MailDetailFragment();
         Bundle arguments=new Bundle();
         arguments.putInt(MailDetailFragment.ARG_ITEM_POS,getIntent().getIntExtra(MailDetailFragment.ARG_ITEM_POS,0));
         fragment.setArguments(arguments);
         getSupportFragmentManager().beginTransaction().add(R.id.flMailDetail,fragment).commit();
     }
 }
}
