package com.dialog_view.customdialogios;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rashi on 21/3/18.
 */

public class ShowDialog {
    public static Typeface type, type2, type3;

    public static Dialog showAlertMessage(final Context context, final String message, final String title, Boolean is_msg_header, Boolean is_ok_cancel_button) {
        final Dialog dialog = new Dialog(context);
        type = Typeface.createFromAsset(context.getAssets(),
                "SourceSansPro-Regular.ttf");
        type2 = Typeface.createFromAsset(context.getAssets(),
                "SourceSansPro-Bold.ttf");
        type3 = Typeface.createFromAsset(context.getAssets(),
                "SourceSansPro-Light.ttf");

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_alert_msg);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView msg_header = (TextView) dialog.findViewById(R.id.msg_header);
        TextView msg = (TextView) dialog.findViewById(R.id.msg);
        Button ok_btn = (Button) dialog.findViewById(R.id.ok_btn);
        Button cancel_btn = (Button) dialog.findViewById(R.id.cancel_btn);
        msg_header.setVisibility(View.GONE);
        cancel_btn.setVisibility(View.GONE);
        ok_btn.setText("OK");
        if (is_msg_header) {
            msg_header.setVisibility(View.VISIBLE);
        }

        if (is_ok_cancel_button) {
            cancel_btn.setText("No");
            ok_btn.setText("Yes");
            cancel_btn.setVisibility(View.VISIBLE);
            cancel_btn.setTypeface(type3, Typeface.BOLD);
            ok_btn.setTypeface(type3, Typeface.BOLD);
        }
        msg_header.setText(title);
        msg_header.setTypeface(type3);
        msg.setTypeface(type3);
        msg.setText(message);

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              dialog.dismiss();
                                          }
                                      }
        );
//        dialog.show();

        try {
            if (context != null && !((Activity) context).isFinishing()) {
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dialog;
    }


}
