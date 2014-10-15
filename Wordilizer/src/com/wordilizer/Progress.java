package com.wordilizer;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Progress extends Activity {
	 private ProgressBar progressBar,progressBar1,progressBar2,progressBar3;
	 private TextView textView,textView1,textView2,textView6,textView3;
	 private EditText Days;
	 private Button Calculate;
	 private int done=0;
	 public int list,lister,longlister;
	// private Handler handler = new Handler();

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.progress);
	  progressBar = (ProgressBar) findViewById(R.id.progressBarTotal);
	  textView = (TextView) findViewById(R.id.textViewTotal);
	  
	  Calculate= (Button) findViewById(R.id.button1);
	  
	  
	  progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
	  textView1 = (TextView) findViewById(R.id.textView1);
	  
	  
	  progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
	  textView2 = (TextView) findViewById(R.id.textView2);
	  
	  
	  progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
	  textView3 = (TextView) findViewById(R.id.textView3);
	  
	/*  progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
	  textView4 = (TextView) findViewById(R.id.textView4);  
	  
	  progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);
	  textView7 = (TextView) findViewById(R.id.textView7);
	  */ 
	   
	  textView6 = (TextView) findViewById(R.id.textView6);
	  Days = (EditText) findViewById(R.id.editText1);
	  
	  
	  
	  // Start long running operation in a background thread
/*	  new Thread(new Runnable() {
	     public void run() {
	        while (progressStatus < 100) {
	           progressStatus += 1;
	    // Update the progress bar and display the 
	                         //current value in the text view
	    handler.post(new Runnable() {
	    public void run() {
	       progressBar.setProgress(progressStatus);
	       textView.setText(progressStatus+"/"+progressBar.getMax());
	    }
	        });
	        try {
	           // Sleep for 200 milliseconds. 
	                         //Just to display the progress slowly
	           Thread.sleep(200);
	        } catch (InterruptedException e) {
	           e.printStackTrace();
	        }
	     }
	  }
	  }).start();*/
	  
	  try{
	    DataBig enter= new DataBig(Progress.this);
		enter.open();
		//long list=enter.countdb();
		long easydb=enter.countdbeasy();
		long mediumdb=enter.countdbmedium();
		long difficultdb=enter.countdbdifficult();
		//long lister=enter.countdb800();
		//long longlister=enter.countdb4000();
		enter.close(); 
		//int firstlist=333-(int) list;
		//int longlist=800-(int)lister;
		//int longlisterite=4759-(int)longlister;
        done= (int)easydb+(int)mediumdb+(int)difficultdb;
		int easy=(int)easydb;
		int medium=(int)mediumdb;
		int difficult=(int)difficultdb;
	  
		
		
/*     progressBar.setMax(333); 
	 progressBar.setProgress(firstlist);
     textView.setText("From High Frequency 333 :"+ firstlist+"/"+"333");
     
     progressBar1.setMax(799);
	 progressBar1.setProgress(longlist);
     textView1.setText("From High Frequency 800 :"+ longlist+"/"+"800");
	
     progressBar5.setMax(4579);
   	 progressBar5.setProgress(longlisterite);
        textView7.setText("For total words :"+ longlisterite+"/"+"4759");*/
     
     progressBar.setMax(done);
	 progressBar.setProgress(easy);
     textView.setText("Words in the Easy deck: "+easy+"/"+done);
	 
     progressBar1.setMax(done);
	 progressBar1.setProgress(medium);
     textView1.setText("Words in the Medium deck: "+medium+"/"+done);
	
     progressBar2.setMax(done);
   	 progressBar2.setProgress(difficult);
     textView2.setText("Words in the Difficult deck: "+difficult+"/"+done);
     
     progressBar3.setMax(4759);
   	 progressBar3.setProgress(done);
     textView3.setText("Total words done: "+done+"/"+4759);
     
     
     Calculate.setOnClickListener(new View.OnClickListener() {
    	 
         @Override
         public void onClick(View arg0) {try{
 		//	long lRow = Long.parseLong(ids);
        	  int day=Integer.parseInt(Days.getText().toString());
 			Log.d(""+day, "Button pressed"); 			
 			textView6.setText("To complete  333 words you have to study "+ ((333-done)/day)+" words per day  \n"
 					        + "To complete  800 words you have to study "+ ((800-done)/day)+" words per day   \n"
 					        + "To complete 4000 words you have to study "+ ((4000-done)/day)+" words per day  ");
 	        
 			}
 			
 			catch (Exception e)
 			{//tester= false;
 		
 		}}
     

     });
     
     
   
	  }
		catch( Exception e)
		{
			String error=e.toString();
			Dialog d = new Dialog(this);
			d.setTitle("Dang !");
			TextView tv = new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();
			
			
			
		}
     
	 
	 }

	}