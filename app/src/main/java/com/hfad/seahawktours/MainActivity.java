package com.hfad.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{
    private Spinner spinner;

    private Integer captions [] = {R.string.No_caption, R.string.CIS, R.string.Bear, R.string.Dobo};
    private Integer images [] = {R.drawable.seahawk, R.drawable.cis, R.drawable.bear, R.drawable.dobo};
    private Integer buildDescriptions [] = {R.string.No_header, R.string.CIS_text, R.string.Bear_text, R.string.Dobo_text};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.building_choices);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.spinner_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0, false);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(this, DetailActivity.class);
//        intent.putExtra("selection", position);
//        startActivity(intent);

        TextView bannerText= (TextView) findViewById(R.id.banner);
        TextView imageCaption = (TextView) findViewById(R.id.building_caption);
        TextView descriptionText = (TextView) findViewById(R.id.descriptions);
        TextView headerText = (TextView) findViewById(R.id.paragraph_header);
        ImageView image = (ImageView) findViewById(R.id.building_picture);
        String banner_text = spinner.getItemAtPosition(position).toString();

        if (position==0){
            bannerText.setText(R.string.banner_text);
            image.setImageResource(R.drawable.seahawk);
            imageCaption.setText("");
            headerText.setText("");
            descriptionText.setText("");
        }

        else if (parent.getId()==spinner.getId()) {
            bannerText.setText(banner_text);
            image.setImageResource(images[position]);
            imageCaption.setText(captions[position]);
            headerText.setText(R.string.Header_text);
            descriptionText.setText(buildDescriptions[position]);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
