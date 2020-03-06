package com.example.error_check;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ErrorDialog extends Dialog {
    public Activity activity;
    private String lblHeading = "ERROR OCCURRED", lblSubtext = "It seem's that some error have been occurred", lottie = "error1.json";
    private TextView heading, subtext;
    private Button retryButton, canclButton;
    private LottieAnimationView lottieAnimationView;
    private RelativeLayout relativeLayout;

    private int dialogColor;
    private int buttonColor=getContext().getColor(R.color.colorAccent);
    private int buttonTextColor=getContext().getColor(R.color.white);
    private int headingColor=getContext().getColor(R.color.white);


    public ErrorDialog(Activity activity) {
        super(activity);
        this.activity = activity;
        this.lblHeading = lblHeading;
        this.lblSubtext = lblSubtext;
        this.lottie = lottie;
    }

    public ErrorDialog(Activity activity, String lblHeading, String lblSubtext, String lottie, int dialogColor) {
        super(activity);
        this.activity = activity;
        this.lblHeading = lblHeading;
        this.lblSubtext = lblSubtext;
        this.lottie = lottie;
        this.dialogColor =dialogColor;
    }

    public ErrorDialog(Activity activity, String lblHeading, String lblSubtext, String lottie, int dialogColor, int buttonColor) {
        super(activity);
        this.activity = activity;
        this.lblHeading = lblHeading;
        this.lblSubtext = lblSubtext;
        this.lottie = lottie;
        this.dialogColor =dialogColor;
        this.buttonColor=buttonColor;
    }

    public ErrorDialog(Activity activity, String lblHeading, String lblSubtext, String lottie, int dialogColor, int buttonColor,
                       int buttonTextColor) {
        super(activity);
        this.activity = activity;
        this.lblHeading = lblHeading;
        this.lblSubtext = lblSubtext;
        this.lottie = lottie;
        this.dialogColor =dialogColor;
        this.buttonColor=buttonColor;
        this.buttonTextColor=buttonTextColor;
    }

    public ErrorDialog(Activity activity, String lblHeading, String lblSubtext, String lottie, int dialogColor, int buttonColor,
                       int buttonTextColor, int headingColor) {
        super(activity);
        this.activity = activity;
        this.lblHeading = lblHeading;
        this.lblSubtext = lblSubtext;
        this.lottie = lottie;
        this.dialogColor =dialogColor;
        this.buttonColor=buttonColor;
        this.buttonTextColor=buttonTextColor;
        this.headingColor=headingColor;
    }

    private boolean isNetworkConnected() {

        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_layout);

//        init();

        relativeLayout = findViewById(R.id.relativeId);
        relativeLayout.setBackgroundColor(dialogColor);

        heading = findViewById(R.id.dialogHeading);
        subtext = findViewById(R.id.dialogSubtext);

        heading.setTextColor(headingColor);
        subtext.setTextColor(headingColor);

        lottieAnimationView = findViewById(R.id.lottieDialog);

        retryButton = findViewById(R.id.retry);
        retryButton.setBackgroundColor(buttonColor);
        retryButton.setTextColor(buttonTextColor);

        canclButton = findViewById(R.id.Cancel);
        canclButton.setBackgroundColor(buttonColor);
        canclButton.setTextColor(buttonTextColor);

        canclButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
//                activity.finish();
            }
        });

        if (isNetworkConnected()) {
            heading.setText(lblHeading);
            subtext.setText(lblSubtext);
            lottieAnimationView.setAnimation(lottie);
        } else {
            heading.setText("NO INTERNET");
            subtext.setText("It seem's that you are not connected");
            lottieAnimationView.setAnimation("nonet.json");
        }


        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();

//                activity.finish();
//                activity.overridePendingTransition(0, 0);
//                activity.startActivity(activity.getIntent());
//                activity.overridePendingTransition(0, 0);

            }
        });
    }

    public void init(){

        dialogColor =getContext().getColor(R.color.colorPrimaryDark);
        buttonColor=getContext().getColor(R.color.colorAccent);
        buttonTextColor=getContext().getColor(R.color.white);
        headingColor=getContext().getColor(R.color.white);

    }

}




