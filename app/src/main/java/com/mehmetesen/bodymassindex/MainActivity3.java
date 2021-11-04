package com.mehmetesen.bodymassindex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity3 extends AppCompatActivity {
    private AdView mAdView;
    EditText editText, editText1;
    String kilo, uzunluk;
    Float weight, height, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText = findViewById(R.id.editTextNumber2);
        editText1 = findViewById(R.id.editTextNumber3);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }





    public void hesapla(View view) {
       kilo=editText.getText().toString();
       uzunluk=editText1.getText().toString();

        if (editText.getText().toString().matches("") || editText1.getText().toString().matches("")) {
            Intent homeIntent = new Intent(MainActivity3.this, MainActivity3.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            Toast.makeText(MainActivity3.this, " Boş Bırakamazsınız", Toast.LENGTH_LONG).show();



        }else if(kilo.matches("0")||uzunluk.matches("0")){

            Intent intent1=new Intent(MainActivity3.this,MainActivity3.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent1);
            Toast.makeText(MainActivity3.this,"Sıfır değerini giremezsiniz",Toast.LENGTH_LONG).show();


        }else{
            kilo = editText.getText().toString();
            uzunluk = editText1.getText().toString();
            weight = Float.parseFloat(kilo);
            height = Float.parseFloat(uzunluk) / 100;
            result = (weight) / (height * height);
            AlertDialog.Builder Alert = new AlertDialog.Builder(this);

            if (result <= 18.5) {
                Alert.setTitle("VKİ Sonucunuz");
                Alert.setMessage("VKİ değeri: " + result + " " + "Boyunuza göre uygun ağırlıkta değilsiniz,Boyunuza göre uygun ağırlığa ulaşmanız için yeterli ve dengeli beslenmelisiniz.");
                Alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                Alert.show();

            } else if (result > 18.5 && result <= 24.9) {
                Alert.setTitle("VKİ Sonucunuz");
                Alert.setMessage("VKİ  değeri: " + result + " " + "Kilonuz Normal Boyunuza göre uygun ağırlıktasınız. Yeterli ve dengeli beslenerek ve düzenli fiziksel aktivite yaparak bu ağırlığınızı korumaya özen gösteriniz.");
                Alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                Alert.show();
            } else if (result >= 25 && result <= 29.9) {
                Alert.setTitle("VKİ Sonucunuz");
                Alert.setMessage("VKİ değeri: " + result + " " + "Normal aralığın üzerindesiniz fazla kilolu olmak pek çok hastalık için risk faktörüdür.");
                Alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                Alert.show();
            } else {
                Alert.setTitle("VKİ Sonucunuz");
                Alert.setMessage("VKİ değeri: " + result + " " + "Obezsiniz Bir sağlık kuruluşuna başvurarak hekim/diyetisyen kontrolünde zayıflayarak normal ağırlığa inmeniz sağlınız için önemlidir.");
                Alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                Alert.show();
            }






        }


    }

}

