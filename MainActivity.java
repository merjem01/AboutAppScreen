package com.example.aboutapppage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.icu.util.RangeValueIterator;
import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.sax.Element;
import android.sax.RootElement;
import android.view.View;
import android.widget.Toast;

import java.lang.annotation.ElementType;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simulateDayNight(/*DAY*/0);
        Element adsElement=new Element();
        adsElement.setTitle("Advertise with us");
        View aboutPage=new AboutPage(context: this)
                .isRTL(false)
                .setImage(R.drawable.subscribe)
                .addItem(new Element().setTitle ("version 6.2"))
                .addItem(adsElement)
                .addGroup("Contact with us")
                .addEmail("sample@gmail.com")
                .addWebsite("sample.com")
                .addFacebook("sample")
                .addTwitter("sample")
                .addYoutube("sample")
                .addPlayStore("sample")
                .addInstagram("sample")
                .addGitHub("sample")
                .addItem(getCopyRightElement())
                .create();
        setContentView(aboutPage);
    }

    private void simulateDayNight(int currentsettings) {
        int DAY=0;
        int NIGHT=1;
        int FOLLOW_SYSTEM=3;
        int currentNightmode=getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentsettings==DAY && currentNightmode !=Configuration.UI_MODE_NIGHT_NO){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        else if(currentsettings==NIGHT && currentNightmode !=Configuration.UI_MODE_NIGHT_YES){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else if(currentsettings==FOLLOW_SYSTEM){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }

    Element setCopyRightElement(){
        Element copyRightsElement=new Element();
        @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) final String copyrights=String.format(getString(R.string.app_name), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.subscribe);
        copyRightsElement.setIvonTint(dom.zdravlja..aboutpage.R.color.about_about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }
}
