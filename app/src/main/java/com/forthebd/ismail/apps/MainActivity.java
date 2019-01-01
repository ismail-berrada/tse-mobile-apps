package com.forthebd.ismail.apps;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListenerNameItem {
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    AnimationDrawable telecom;

    private Button buttonNext;
    private Intent intent;
    private RecyclerView recyclerView;
    private AdapterListName adapterListName;


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        telecom.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView)findViewById(R.id.image);
        imageView.setBackgroundResource(R.drawable.personalized2);
        telecom=(AnimationDrawable)imageView.getBackground();


        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);

        animationDrawable  = (AnimationDrawable) myLayout.getBackground();

        animationDrawable.setEnterFadeDuration(3500);

        animationDrawable.setExitFadeDuration(3500);

        animationDrawable.start();



        adapterListName =new AdapterListName(this);

        //textViewName = findViewById(R.id.lbl);
        buttonNext = findViewById(R.id.activity_main_suivant);
        recyclerView = findViewById(R.id.recyclerViewList);


        final LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterListName);

        intent = new Intent(this,FormatActivity.class);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        List nameList = DataManager.getInstance().getNameList();
        adapterListName.updateData(nameList);
    }




    @Override
    public void onClickItem(String name) {
        Toast.makeText(this,name,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickCross(String name) {
        Toast.makeText(this,"t'as cliqué juste sur  " + name,Toast.LENGTH_LONG).show();
    }
}
