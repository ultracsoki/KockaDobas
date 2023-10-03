package com.example.kockadobas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewElso;
    private ImageView imageViewMasodik;
    private Button buttonEgyKocka;
    private Button buttonKettoKocka;
    private Button buttonDobas;
    private Button buttonReset;
    private TextView textViewResult;
    private Random random;
    private int randomNumber1;
    private int randomNumber2;
    private String eredmeny;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonEgyKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewMasodik.setVisibility(View.GONE);
            }
        });

        buttonKettoKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewMasodik.setVisibility(View.VISIBLE);
            }
        });

        buttonDobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KockakBeallitasa();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.create().show();
            }
        });
    }

    public void init()
    {
        imageViewElso = findViewById(R.id.imageViewElso);
        imageViewMasodik = findViewById(R.id.imageViewMasodik);
        buttonEgyKocka = findViewById(R.id.buttonEgyKocka);
        buttonKettoKocka = findViewById(R.id.buttonKettoKocka);
        buttonDobas = findViewById(R.id.buttonDobas);
        buttonReset = findViewById(R.id.buttonReset);
        textViewResult = findViewById(R.id.textViewResult);
        random = new Random();
        eredmeny = "";
        alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Reset")
                .setMessage("Biztos, hogy törölni szeretné az eddigi dobásokat?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetResult();
                    }
                })
                .setCancelable(false);
    }

    public void KockakBeallitasa()
    {
        randomNumber1 = random.nextInt(6);
        randomNumber2 = random.nextInt(6);
        switch (randomNumber1)
        {
            case 0:
                imageViewElso.setImageResource(R.drawable.kocka1);
                break;
            case 1:
                imageViewElso.setImageResource(R.drawable.kocka2);
                break;
            case 2:
                imageViewElso.setImageResource(R.drawable.kocka3);
                break;
            case 3:
                imageViewElso.setImageResource(R.drawable.kocka4);
                break;
            case 4:
                imageViewElso.setImageResource(R.drawable.kocka5);
                break;
            case 5:
                imageViewElso.setImageResource(R.drawable.kocka6);
                break;
        }
        if (imageViewMasodik.getVisibility() == View.VISIBLE)
        {
            randomNumber2 = random.nextInt(6);
            switch (randomNumber2)
            {
                case 0:
                    imageViewMasodik.setImageResource(R.drawable.kocka1);
                    break;
                case 1:
                    imageViewMasodik.setImageResource(R.drawable.kocka2);
                    break;
                case 2:
                    imageViewMasodik.setImageResource(R.drawable.kocka3);
                    break;
                case 3:
                    imageViewMasodik.setImageResource(R.drawable.kocka4);
                    break;
                case 4:
                    imageViewMasodik.setImageResource(R.drawable.kocka5);
                    break;
                case 5:
                    imageViewMasodik.setImageResource(R.drawable.kocka6);
                    break;
            }
            eredmeny += String.format("%d (%d+%d)\n",randomNumber1+randomNumber2+2,randomNumber1+1,randomNumber2+1);
            textViewResult.setText(eredmeny);
            Toast.makeText(this, String.valueOf(randomNumber1+randomNumber2+2), Toast.LENGTH_SHORT).show();
        }
        else
        {
            eredmeny += String.format("%d\n",randomNumber1+1);
            textViewResult.setText(eredmeny);
        }
    }

    public void resetResult()
    {
        eredmeny = "";
        textViewResult.setText(eredmeny);
    }
}