package com.example.error_check;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class InternetDialog extends Dialog {
    public Activity activity;
    private String lblHeading = "NO INTERNET",
            lblSubtext = "It seem's that you are not connected",
            lottie = "nonet.json";
    private TextView heading, subtext;
    private Button retryButton, canclButton;
    private LottieAnimationView lottieAnimationView;
    private RelativeLayout relativeLayout;
    private int dialogColor = Color.parseColor("#008577");
    private int buttonColor = Color.parseColor("#000000");
    private int buttonTextColor=Color.parseColor("#ffffff");
    private int headingColor=Color.parseColor("#ffffff");


    public InternetDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public InternetDialog(Activity activity, int dialogColor) {
        super(activity);
        this.activity = activity;
        this.dialogColor = dialogColor;
    }

    public InternetDialog(Activity activity, String lottie, int dialogColor, int buttonColor) {
        super(activity);
        this.activity = activity;
        this.dialogColor = dialogColor;
        this.buttonColor = buttonColor;
        this.lottie=lottie;
    }

    public InternetDialog(Activity activity, String lottie, int dialogColor, int buttonColor, int buttonTextColor) {
        super(activity);
        this.activity = activity;
        this.dialogColor = dialogColor;
        this.buttonColor = buttonColor;
        this.lottie=lottie;
        this.buttonTextColor=buttonTextColor;
    }

    public InternetDialog(Activity activity, String lottie, int dialogColor, int buttonColor, int buttonTextColor, int headingColor) {
        super(activity);
        this.activity = activity;
        this.dialogColor = dialogColor;
        this.buttonColor = buttonColor;
        this.lottie=lottie;
        this.buttonTextColor=buttonTextColor;
        this.headingColor=headingColor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        relativeLayout = findViewById(R.id.relativeId);
        heading = findViewById(R.id.dialogHeading);
        subtext = findViewById(R.id.dialogSubtext);
        lottieAnimationView = findViewById(R.id.lottieDialog);
        heading.setText(lblHeading);

        heading.setTextColor(headingColor);
        subtext.setTextColor(headingColor);

        subtext.setText(lblSubtext);
        lottieAnimationView.setAnimation(lottie);


        retryButton = findViewById(R.id.retry);
        retryButton.setBackgroundColor(buttonColor);

        retryButton.setTextColor(buttonTextColor);

        canclButton = findViewById(R.id.Cancel);
        canclButton.setBackgroundColor(buttonColor);
        canclButton.setTextColor(buttonTextColor);

        relativeLayout.setBackgroundColor(dialogColor);

        canclButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

}




