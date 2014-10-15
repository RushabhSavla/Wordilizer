package com.wordilizer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DeckSize extends ListActivity{

	String classes[] = {"GitHub","GitHub800","GitHub4000"};
	String names[]={"Deck 333","Deck 800","Deck 4759"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(DeckSize.this,android.R.layout.simple_list_item_1, names));
		
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
			Intent ourIntent = new Intent(DeckSize.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
