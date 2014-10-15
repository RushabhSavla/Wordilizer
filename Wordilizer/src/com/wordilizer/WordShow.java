package com.wordilizer;

import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class WordShow extends Activity implements TextToSpeech.OnInitListener{
	
	private TextToSpeech ttss;
	private ImageButton speak;
	private TextView word;
	private String wrd;
	private String meang;
	private String ownmeang;
	//private String ids;
	private String TAG="Wordshow";
	private Button easy;
	private Button medium;
	private Button difficult;
	private Button own;
	private EditText ownedit;
	
	
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word);
        getWindow().setSoftInputMode(
        		WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        speak=(ImageButton) findViewById(R.id.button5);
        easy= (Button) findViewById(R.id.button1);
        medium= (Button) findViewById(R.id.button2);
        difficult= (Button) findViewById(R.id.button3);
        own= (Button) findViewById(R.id.button4);
        ttss = new TextToSpeech(this, this);
       
        
        
        
        Intent myIntent = getIntent(); // gets the previously created intent
        wrd = myIntent.getStringExtra("wrd"); // will return "FirstKeyValue"
        meang= myIntent.getStringExtra("meang");
        Log.d(meang, "word meang called");
        ownmeang=myIntent.getStringExtra("ownmeang");
        Log.d(ownmeang, "ownmeang");
      //  ids=myIntent.getStringExtra("ids");
      //  Log.d(ids, "id called?");
        
        
    
       
        	ownedit= (EditText) findViewById(R.id.editText1);
            word = (TextView) findViewById(R.id.word);
            TextView definition = (TextView) findViewById(R.id.definition);
            final TextView owndefinition = (TextView) findViewById(R.id.owndefinition);
            word.setText(wrd);
            definition.setText(meang);
            owndefinition.setText(ownmeang);
            ownedit.setText(ownmeang);
            
            easy.setOnClickListener(new View.OnClickListener() {

           	 
                @Override
                public void onClick(View arg0) {
            		
            		// TODO Auto-generated method stub
            		
                	
            			
            			boolean didItWork=true;
            			try{
            			DataBig entry= new DataBig(WordShow.this);
            			entry.open();
            			entry.addEasy(wrd,meang,ownmeang);
            			entry.close();
            			
            			}catch (Exception e){
            				didItWork=false;
            				String error=e.toString();
            				Log.d(TAG, error);
            			/*	Dialog d = new Dialog(this);
            				d.setTitle("Dang !");
            				TextView tv = new TextView(this);
            				tv.setText(error);
            				d.setContentView(tv);
            				d.show();*/
            			}finally{
            				if(didItWork){
            					Log.d(TAG,"Added to Easy !");
            					medium.setBackgroundColor(Color.GRAY);
                				difficult.setBackgroundColor(Color.GRAY);
                				easy.setBackgroundColor(Color.GREEN);
            					final AlertDialog alert = new AlertDialog.Builder(WordShow.this).create();
                                alert.setTitle("Added");
                                alert.setMessage("Word added to Easy !");
                                alert.show();
                                final Handler handler  = new Handler();
                                final Runnable runnable = new Runnable() {
                                    @Override
                                    public void run() {
                                        if (alert.isShowing()) {
                                            alert.dismiss();
                                        }
                                    }
                                };
                               handler.postDelayed(runnable, 1000);
            		
            			}
            			}
            			
            			
            		}
            

            });
          
            
            
            medium.setOnClickListener(new View.OnClickListener() {
              	 
                @Override
                public void onClick(View arg0) {
            		
            		// TODO Auto-generated method stub
                	
            		
            		
            			
            			boolean didItWork=true;
            			try{
            				
            			DataBig entry= new DataBig(WordShow.this);
            			entry.open();
            			entry.addMedium(wrd,meang,ownmeang);
            			entry.close();
            			
            			}catch (Exception e){
            				didItWork=false;
            				String error=e.toString();
            				Log.d(TAG, error);
            		
            			}finally{
            				if(didItWork){
            					Log.d(ownmeang,"Added to Medium !");
            					easy.setBackgroundColor(Color.GRAY);
                				difficult.setBackgroundColor(Color.GRAY);
                				medium.setBackgroundColor(Color.YELLOW);
                    			final AlertDialog alert = new AlertDialog.Builder(WordShow.this).create();
                                alert.setTitle("Added");
                                alert.setMessage("Word added to Medium !");
                                alert.show();
                                final Handler handler  = new Handler();
                                final Runnable runnable = new Runnable() {
                                    @Override
                                    public void run() {
                                        if (alert.isShowing()) {
                                            alert.dismiss();
                                        }
                                    }
                                };
                                handler.postDelayed(runnable, 1000);
            		
            			}
            			}
            			
            			
            		}
            

            });
        
            
            
            difficult.setOnClickListener(new View.OnClickListener() {
             	 
                @Override
                public void onClick(View arg0) {
            		
            		// TODO Auto-generated method stub
            		
            		
            			
            			boolean didItWork=true;
            			try{
            				
            				            		
            			DataBig entry= new DataBig(WordShow.this);
            			entry.open();
            			entry.addDifficult(wrd,meang,ownmeang);
            			entry.close();
            			
            			}catch (Exception e){
            				didItWork=false;
            				String error=e.toString();
            				Log.d(TAG, error);
            			/*	Dialog d = new Dialog(this);
            				d.setTitle("Dang !");
            				TextView tv = new TextView(this);
            				tv.setText(error);
            				d.setContentView(tv);
            				d.show();*/
            			}finally{
            				if(didItWork){
            					Log.d(TAG,"Added to Difficult !");
            					easy.setBackgroundColor(Color.GRAY);
                				medium.setBackgroundColor(Color.GRAY);
                				difficult.setBackgroundColor(Color.RED);
                				final AlertDialog alert = new AlertDialog.Builder(WordShow.this).create();
                                alert.setTitle("Added");
                                alert.setMessage("Word added to Difficult !");
                                alert.show();
                                final Handler handler  = new Handler();
                                final Runnable runnable = new Runnable() {
                                    @Override
                                    public void run() {
                                        if (alert.isShowing()) {
                                            alert.dismiss();
                                        }
                                    }
                                };
                               handler.postDelayed(runnable, 1000);
                    
            			}
            			}
            			
            			
            		}
            

            });
        
    
            own.setOnClickListener(new View.OnClickListener() {
            	 
                @Override
                public void onClick(View arg0) {try{
        		//	long lRow = Long.parseLong(ids);
        			String ownmeaning=ownedit.getText().toString();
        			DataBig ex = new DataBig(WordShow.this);
        			ex.open();
        			ex.updateOwn(wrd,meang,ownmeaning);
        			ex.close();
        			Log.d(ownmeaning, "Button pressed");
        			owndefinition.setText(ownmeaning);
        			ownmeang=ownmeaning;
        			
        			
        	        
        			}
        			
        			catch (Exception e)
        			{//tester= false;
        		
        		}}
            

            });
        
            
            speak.setOnClickListener(new View.OnClickListener() {
            	 
                @Override
                public void onClick(View arg0) {
                    speakOut();
                }
     
            });
            
        }
        private void speakOut() {
        
            try{
            ttss.speak(wrd,TextToSpeech.QUEUE_FLUSH, null);
            }
            catch(Exception e)
            {
            	
            	String error=e.toString();
            	Log.d(wrd,error);
            	
            	
            }
            
         
        }
        
        public void onDestroy() {
            // Don't forget to shutdown tts!
      
            if (ttss != null) {
                ttss.stop();
                ttss.shutdown();
            }
            super.onDestroy();
        }

        
        
        @Override
    	public void onInit(int status) {
    		// TODO Auto-generated method stub
    		if (status == TextToSpeech.SUCCESS) {
    			 
                int result = ttss.setLanguage(Locale.US);
                ttss.setPitch((float) 1.5);
                ttss.setSpeechRate((float) 1);
                Log.d("TTS", "init");
     
                if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "This Language is not supported");
                } else {
                    speak.setEnabled(true);
                  
                }
     
            } else {
                Log.e("TTS", "Initilization Failed!");
            }
    		
    	}
    
    }

    
    
