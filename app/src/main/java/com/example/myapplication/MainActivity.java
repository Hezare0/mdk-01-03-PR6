package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button lastimg;
    private Button nextimg;
    private ImageView img;
    private TextView textView;
    private int[] p = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
    private int Index = 0;
    private int count = p.length - 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        lastimg = (Button) findViewById(R.id.buttonLast);
        lastimg.setOnClickListener( this);
        nextimg = (Button) findViewById(R.id.buttonNext);
        nextimg.setOnClickListener( this);
        img = (ImageView) findViewById(R.id.imageViewCurrent);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLast:
                if (Index == 0) {
                    Index = count;
                } else {
                    Index = Index - 1;
                }
                break;
            case R.id.buttonNext:
                if(Index == count){
                    Index = 0;

                }else{
                    Index = Index +1;
                }
                break;
            default:
                break;
        }
        img.setImageResource(p[Index]);
        textView.setText(Integer.toString(Index+1) + "/" + p.length);
    }
}