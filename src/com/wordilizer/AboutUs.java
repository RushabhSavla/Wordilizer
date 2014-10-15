package com.wordilizer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends Activity{

	private TextView AboutUs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.about);
		AboutUs= (TextView) findViewById(R.id.about);
		AboutUs.setText("This application has been developed by Rushabh Savla with inputs from Sahil Salunkhe");
		
		
		
	}
	
	
	
}
