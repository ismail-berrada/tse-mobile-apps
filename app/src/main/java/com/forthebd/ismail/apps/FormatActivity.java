package com.forthebd.ismail.apps;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormatActivity extends AppCompatActivity {
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    private Intent i;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_format);

        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);

        animationDrawable  = (AnimationDrawable) myLayout.getBackground();

        animationDrawable.setEnterFadeDuration(3000);

        animationDrawable.setExitFadeDuration(3000);

        animationDrawable.start();

        editText = findViewById(R.id.activity_format_text);

        Button buttonBack = findViewById(R.id.activity_format_retour);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                DataManager.getInstance().addName(editText.getText().toString());

                finish();
            }
        });
    }
}
