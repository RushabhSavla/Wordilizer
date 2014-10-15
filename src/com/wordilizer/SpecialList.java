package com.wordilizer;

import android.app.ListActivity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View; 
import android.view.ViewGroup;
import android.widget.ArrayAdapter; 
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView; 
import android.widget.TextView; 
import android.widget.Toast; 

public class SpecialList extends ListActivity{ 

    TextView toptext; 
    String[] items={"Select Deck Size","Search Word","Difficulty Level","Progress","About Us"};
    private CityListAdapter mListOfCities;

    boolean mAtlantaListExpanded;

    @Override 
    public void onCreate(Bundle icicle) { 
        super.onCreate(icicle); 
       // setContentView(R.layout.main); 

        mAtlantaListExpanded = false;
        mListOfCities = new CityListAdapter();
        setListAdapter(mListOfCities);

        for (int n=0; n < items.length; n++)
        {
            mListOfCities.add(items[n]);
        }
    } 

    public void onListItemClick(ListView parent, View v, int position, long id) 
    { 
         Intent intent = new Intent(); 

         if (parent.getItemAtPosition(position)=="Select Deck Size") 
         { 
             mAtlantaListExpanded = !mAtlantaListExpanded;
             mListOfCities.clear();
             for (int n=0; n < items.length; n++)
             {
                mListOfCities.add(items[n]);
             }           
             Log.i("SpecialList", "Atlanta");            
         } 
         else if (parent.getItemAtPosition(position)=="Boston") 
         { 
             Log.i("SpecialList", "Boston");
         } 
         else if (parent.getItemAtPosition(position)=="Chicago") 
         { 
             Log.i("SpecialList", "Chicago");
         } 
         else if (parent.getItemAtPosition(position)=="Dallas") 
         { 
             Log.i("SpecialList", "Dallas");
         } 
    }

    class CityListAdapter extends ArrayAdapter<String> {    

        CityListAdapter() {         
            super(SpecialList.this, R.layout.one_city_row);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) 
        {
            View row = null;
            LayoutInflater inflater = getLayoutInflater();

            if ((position == 0) && (!mAtlantaListExpanded))
            {
                row = inflater.inflate(R.layout.expandable_city_row, parent, false);
                TextView city = (TextView) row.findViewById(R.id.textView1);
                city.setText(items[position]);

                TextView cityZone1 = (TextView) row.findViewById(R.id.textView2);
                cityZone1.setText("Zone 1");

                TextView cityZone2 = (TextView) row.findViewById(R.id.textView3);
                cityZone2.setText("Zone 2");

                TextView cityZone3 = (TextView) row.findViewById(R.id.textView4);
                cityZone3.setText("Zone 3");

                cityZone1.setOnClickListener(
                    new Button.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                             Log.i("SpecialList", "Zone 1");
                        }
                    }
                );

                cityZone2.setOnClickListener(
                    new Button.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                             Log.i("SpecialList", "Zone 2");
                        }
                    }
                );

                cityZone3.setOnClickListener(
                    new Button.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                             Log.i("SpecialList", "Zone 3");
                        }
                    }
                );              
            }
            else
            {
                row = inflater.inflate(R.layout.one_city_row, parent, false);
                TextView city = (TextView) row.findViewById(R.id.textView1);
                city.setText(items[position]);
            }                   

            return(row);
        }
    }
} 