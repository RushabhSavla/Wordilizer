package com.wordilizer;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class GitHub4000 extends ListActivity {

	private Cursor employees;
	private MyDatabase db;
	private ListAdapter adapter;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		db = new MyDatabase(this);
		employees = db.getEmployees4000(); // you would not typically call this on the main thread

		       adapter = new SimpleCursorAdapter(this, 
				R.layout.lister, 
				employees, 
				new String[] {"words","meaning"}, 
				new int[] {android.R.id.text1,android.R.id.text2});
				getListView().setAdapter(adapter);
				
	}
	
	
				
				@Override
				protected void onListItemClick(ListView l, View v, int position, long id) {
					// TODO Auto-generated method stub
					
					super.onListItemClick(l, v, position, id);
					
					try {
						//long let = (long)position+1;
						DataBig hon= new DataBig(this);
						hon.open();
						String returnedWord=hon.getWord4000(id);
						String returnedMeaning=hon.getMeaning4000(id);
						String returnedOwn=hon.getOwn4000(id);
						hon.close();
						
						Intent myIntent = new Intent(this, WordShow.class);
						myIntent.putExtra("wrd",returnedWord);
						myIntent.putExtra("meang",returnedMeaning);
						myIntent.putExtra("ownmeang",returnedOwn);
					    startActivity(myIntent);
						
					}
					catch (Exception e)
					{//tester= false;
						String error=e.toString();
						Dialog di = new Dialog(this);
						di.setTitle("Word already segregated !");
						TextView tv = new TextView(this);
						tv.setText("You have already shifted this word to one of the lists\n"+error);
						di.setContentView(tv);
						di.show();
				}
					
				
	}
	
	
	
	
				@Override
				protected void onRestart() {
					// TODO Auto-generated method stub
					super.onRestart();
				employees.requery();

				}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		employees.close();
		db.close();
	}

}
