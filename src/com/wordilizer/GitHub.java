package com.wordilizer;
//import com.nhaarman.listviewanimations.swinginadapters.prepared.SwingRightInAnimationAdapter;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class GitHub extends ListActivity {

	private Cursor employees;
	private MyDatabase db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		db = new MyDatabase(this);
		employees = db.getEmployees(); // you would not typically call this on the main thread


		@SuppressWarnings("deprecation")
		ListAdapter adapter = new SimpleCursorAdapter(this, 
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
						String returnedWord=hon.getWord(id);
						String returnedMeaning=hon.getMeaning(id);
						String returnedOwn=hon.getOwn(id);
					//	Log.d(returnedOwn, "own returned");
					//	String returnedID=hon.getID(id);
					//	Log.d(returnedID, "id returned");
						hon.close();
						
						Intent myIntent = new Intent(this, WordShow.class);
						Log.d(returnedWord, "Class called");
						myIntent.putExtra("wrd",returnedWord);
						Log.d(returnedWord, "word  called");
						myIntent.putExtra("meang",returnedMeaning);
						Log.d(returnedWord, "meang called");
						myIntent.putExtra("ownmeang",returnedOwn);
						Log.d(returnedOwn, "ownmeang called");
						//myIntent.putExtra("ids",returnedID);
					//	Log.d(returnedWord, "id called");
					    startActivity(myIntent);
					    Log.d(returnedWord, "Activity started");
					    getListView().setItemChecked(position, true);
						
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
