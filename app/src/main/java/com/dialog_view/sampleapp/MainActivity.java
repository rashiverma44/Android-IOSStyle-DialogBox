package com.dialog_view.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dialog_view.customiosdialog.ShowDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button dialog_ok_btn, dialog_ok_cancel_button;
    ShowDialog showDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialog=new ShowDialog();
        dialog_ok_btn = (Button) findViewById(R.id.ok_button);
        dialog_ok_cancel_button = (Button) findViewById(R.id.ok_cancel_button);
        dialog_ok_btn.setOnClickListener(this);
        dialog_ok_cancel_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ok_button :
                showDialog.showAlertMessage(MainActivity.this,"This is dialog box with ok button","Ok Button Dialog",true,false);
                break;

            case R.id.ok_cancel_button :
                showDialog.showAlertMessage(MainActivity.this,"This is dialog box with ok cancel button","OK CANCEL Button Dialog",true,true);
                break;

        }
    }
}
