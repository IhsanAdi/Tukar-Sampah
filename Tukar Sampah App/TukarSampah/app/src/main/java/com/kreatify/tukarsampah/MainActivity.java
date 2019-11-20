package com.kreatify.tukarsampah;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout btnQR;
    LinearLayout btnElectric;

    RecyclerView news_list;
    EventAdapter eventAdapter;
    List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQR = (LinearLayout) findViewById(R.id.btnQR);
        btnElectric = (LinearLayout) findViewById(R.id.electricBtn);

        btnElectric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElectricity();
            }
        });

        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp();
            }
        });

        news_list = findViewById(R.id.news_list);

        eventList = new ArrayList<>();
        eventList.add(
                new Event(
                        "Ecotourism with a Master Boo",
                        "WORKSHOP",
                        R.drawable.picone
                )
        );

        eventList.add(
                new Event(
                        "Cooking with Me and Julie",
                        "CLASSES",
                        R.drawable.pictwo
                )
        );

        eventList.add(
                new Event(
                        "Learn Gratitude from Priest",
                        "SEMINAR",
                        R.drawable.picone
                )
        );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        news_list.setLayoutManager(linearLayoutManager);
        news_list.setHasFixedSize(true);

        eventAdapter = new EventAdapter(this, eventList);
        news_list.setAdapter(eventAdapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(news_list);

    }

    public void showPopUp(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("QR Code");
        dialog.setMessage("Show QR Code to Our Staff");
        dialog.setCancelable(true);

        LayoutInflater inflater = this.getLayoutInflater();
        View qr_code = inflater.inflate(R.layout.qr_code, null);

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        dialog.setView(qr_code);
        dialog.show();
    }

    public void openElectricity() {
        Intent intent = new Intent(this, Electricity.class);
        startActivity(intent);
    }

    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}
