package com.wordilizer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	String classes[] = {"DeckSize","SearchableDictionary","GitHubDifficult","GitHubMedium","GitHubEasy","Progress","AboutUs","SpecialList"};
	String names[]={"Select Deck Size","Search Word","Difficult","Medium","Easy","Progress","About Us","Beta test"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1, names));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		String cheese= classes[position];
		@SuppressWarnings("rawtypes")
		Class ourClass;
		try {
			ourClass = Class.forName("com.wordilizer."+ cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
