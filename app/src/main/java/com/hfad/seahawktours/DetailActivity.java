package com.hfad.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class DetailActivity extends Activity {
    private Spinner spinner;
    private int myInt;

    private Integer captions [] = {R.string.No_caption, R.string.CIS, R.string.Bear, R.string.Dobo};
    private Integer images [] = {R.drawable.seahawk, R.drawable.cis, R.drawable.bear, R.drawable.dobo};
    private Integer buildDescriptions [] = {R.string.No_header, R.string.CIS_text, R.string.Bear_text, R.string.Dobo_text};

    TextView bannerText= (TextView) findViewById(R.id.banner);
    TextView imageCaption = (TextView) findViewById(R.id.building_caption);
    TextView descriptionText = (TextView) findViewById(R.id.descriptions);
    TextView headerText = (TextView) findViewById(R.id.paragraph_header);
    ImageView image = (ImageView) findViewById(R.id.building_picture);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        int myInt = intent.getIntExtra("building", 0);
        String banner_text = spinner.getItemAtPosition(myInt).toString();


//        if (myInt==0) {
//            bannerText.setText(R.string.banner_text);
//            image.setImageResource(R.drawable.seahawk);
//            imageCaption.setText("");
//            headerText.setText("");
//            descriptionText.setText("");
//        }
//
//        else if (myInt!=0) {
//            bannerText.setText(banner_text);
//            image.setImageResource(images[myInt]);
//            imageCaption.setText(captions[myInt]);
//            headerText.setText(R.string.Header_text);
//            descriptionText.setText(buildDescriptions[myInt]);
//        }
    }

    public void onSpinnerClick (View view) {
        if (myInt==0) {
            bannerText.setText(R.string.banner_text);
            image.setImageResource(R.drawable.seahawk);
            imageCaption.setText("");
            headerText.setText("");
            descriptionText.setText("");
        }

        else if (myInt!=0) {
            image.setImageResource(images[myInt]);
            imageCaption.setText(captions[myInt]);
            headerText.setText(R.string.Header_text);
            descriptionText.setText(buildDescriptions[myInt]);
        }
    }
}
