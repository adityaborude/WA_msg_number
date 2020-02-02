package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ET1;
    String Text;
    EditText ET2;
    Button B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B1 = findViewById(R.id.B1);
        ET1 = findViewById(R.id.ET1);
        ET2 = findViewById(R.id.ET2);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String phone = "+91 ";
                    String number;
                    PackageManager manager = getApplicationContext().getPackageManager();
                    Text = ET1.getText().toString();
                    number = ET2.getText().toString();
                    String url = "https://api.whatsapp.com/send?phone="+phone+number+"&text="+Text;
                    Intent I1 = new Intent(Intent.ACTION_VIEW);
                    //I1.putExtra("text", Text);
                    I1.setPackage("com.whatsapp");
                    I1.setData(Uri.parse(url));
                    if(I1.resolveActivity(manager)!=null)
                        startActivity(I1);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
