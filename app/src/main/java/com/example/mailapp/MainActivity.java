package com.example.mailapp;
//import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements MailListFragment.MailListListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("All mails");
        toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Mails.generate();
        }
        MailListFragment frg = new MailListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.flMovieList, frg).commit();
        if (findViewById(R.id.flMailDetail) != null) {
            Bundle arguments = new Bundle();
            arguments.putInt(MailDetailFragment.ARG_ITEM_POS, 0);
            MailDetailFragment fragment = new MailDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.flMailDetail, fragment).commit();
        }

    }


    @Override
    public void itemClicked(int pos) {
        if (findViewById(R.id.flMailDetail) == null) {
            Intent detailIntent = new Intent(this, DetailActivity.class);
            detailIntent.putExtra(MailDetailFragment.ARG_ITEM_POS, pos);
            startActivity(detailIntent);
        } else {
            Bundle arguments = new Bundle();
            arguments.putInt(MailDetailFragment.ARG_ITEM_POS, pos);
            MailDetailFragment fragment = new MailDetailFragment();
            fragment.setArguments(arguments);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMailDetail, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
