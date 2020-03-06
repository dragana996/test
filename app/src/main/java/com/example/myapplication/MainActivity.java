package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/* public class MainActivity extends AppCompatActivity {

    private TextView mhello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mhello = (TextView) findViewById(R.id.hello);
    }

}
*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import CTOS.CtPrint;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String TAG = "Saturn 1000 Print demo";
        mButton = findViewById(R.id.cancel_button);
        mText = findViewById(R.id.bar_textview);
        final CtPrint print = new CtPrint();

        String print_font;
        int print_x = 0;
        int print_y = 36;
        int Currently_high = 20;
        final int[] ret = {0};
        Bitmap bitmap = null;

        print.initPage(200);
        bitmap = print.encodeToBitmap("12ASDFSS34", print.QR_CODE, 150, 150);
        print.drawImage(bitmap,0,0);
        //print.printPage();

        ret[0] = print.roll(10);
        Log.d(TAG, String.format("Roll ret = %d", ret[0]));

        ret[0] = print.status();
        Log.d(TAG, String.format("status ret = %d", ret[0]));

        print.setHeatLevel(2);

        print.initPage(100);

        print_font = "PRINT TESTING";
        print.drawText(0, print_y + Currently_high, print_font, print_y, 1, true, (float) 0, false, false);
        Currently_high += print_y;

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                print.printPage();
                int status = print.status();
                Log.e(TAG, String.format("STATUS IS %d", status));
                if(status == 0) {
                    mText.setText("Success");
                }


            }
        });

     //   print.printPage();
    }
}