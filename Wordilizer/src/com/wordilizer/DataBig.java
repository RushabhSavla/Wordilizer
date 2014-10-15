package com.wordilizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBig {

	public static final String KEY_ROWID="_id";
	public static final String KEY_WORD="words";	
	public static final String KEY_MEANING="meaning";
	public static final String KEY_OWN="own";
	
	private static final String DATABASE_NAME="wordsdb";
	private static final String DATABASE_TABLE="wordlistdb";
	private static final String DATABASE_TABLE800="wordlistdb800";
	private static final String DATABASE_TABLE4000="wordlistdb4000";
	private static final String DATABASE_TABLEEASY="wordlistdbeasy";
	private static final String DATABASE_TABLEMEDIUM="wordlistdbmedium";
	private static final String DATABASE_TABLEDIFFICULT="wordlistdbdifficult";
	private static final int DATABASE_VERSION = 21;
	
	private static final String TAG = "DataBig";
	private DbHelper ourHelper;
	private final Context ourContext;
	private static SQLiteDatabase ourDatabase;
	
	
	private static class DbHelper extends SQLiteOpenHelper{
		public DbHelper(Context context) {
			super(context,DATABASE_NAME, null,DATABASE_VERSION );
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL( "CREATE TABLE "+DATABASE_TABLE +" ("+
					KEY_ROWID + " INTEGER PRIMARY KEY, "+
					KEY_WORD+ " TEXT NOT NULL, "+
					KEY_MEANING+ " TEXT NOT NULL);"
					);
			
		}
		
		
		
		

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
	
	}
	
	public DataBig(Context c)
	{ ourContext = c;
	
	}
	
	public DataBig open() throws SQLException{
		ourHelper= new DbHelper(ourContext);
		ourDatabase= ourHelper.getWritableDatabase();
		return this;
	}

	public void close() throws SQLException{
		ourHelper.close();
	}

	public long createEntry(String word, String meaning)throws SQLException {
		// TODO Auto-generated method stub
		ContentValues cv= new ContentValues();
		cv.put(KEY_WORD, word);
		cv.put(KEY_MEANING, meaning);
		return ourDatabase.insert(DATABASE_TABLE, null, cv); 
		
		
	}

	public String getData() throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING};
		Cursor c= ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);   
		String result="";
		
		int iRow=c.getColumnIndex(KEY_ROWID);
		int iWord=c.getColumnIndex(KEY_WORD);
		int iMeaning=c.getColumnIndex(KEY_MEANING);
		
		for(c.moveToFirst(); !c.isAfterLast();c.moveToNext())
		{ result= result+ c.getString(iRow)+"  "+c.getString(iWord)+"\t "+c.getString(iMeaning)+"\n";
		}
		
		return result;
	} 



	public String getWord(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String word = c.getString(1);
			return word;
		}
		return null;
	}

	public String getMeaning(long l) throws SQLException{
				// TODO Auto-generated method stub
				String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
				Cursor c= ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "="+ l, null, null, null, null);
				if(c !=null){
					c.moveToFirst();
					String meaning = c.getString(2);
					return meaning;
		
	}return null;
	}

	public String getOwn(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String own = c.getString(3);
			c.close();
			return own;

}return null;
}
	
	public String getID(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		long m= l;
		Cursor c= ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "="+ m, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String ids = c.getString(0);
			return ids;

}return null;
}
	
	
	
	public String getWord800(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLE800, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String word = c.getString(1);
			return word;
		}
		return null;
	}

	public String getMeaning800(long l) throws SQLException{
				// TODO Auto-generated method stub
				String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
				Cursor c= ourDatabase.query(DATABASE_TABLE800, columns, KEY_ROWID + "="+ l, null, null, null, null);
				if(c !=null){
					c.moveToFirst();
					String meaning = c.getString(2);
					return meaning;
		
	}return null;
	}

	public String getOwn800(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLE800, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String own = c.getString(3);
			return own;

}return null;
}
	
	public String getID800(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLE800, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String ids = c.getString(0);
			
			return ids;

}return null;
}
	
	
	
	
	
	public String getWord4000(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLE4000, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String word = c.getString(1);
			return word;
		}
		return null;
	}

	public String getMeaning4000(long l) throws SQLException{
				// TODO Auto-generated method stub
				String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
				Cursor c= ourDatabase.query(DATABASE_TABLE4000, columns, KEY_ROWID + "="+ l, null, null, null, null);
				if(c !=null){
					c.moveToFirst();
					String meaning = c.getString(2);
					return meaning;
		
	}return null;
	}

	public String getOwn4000(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLE4000, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String own = c.getString(3);
			return own;

}return null;
}
	
	public String getID4000(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLE4000, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String ids = c.getString(0);
			
			return ids;

}return null;
}
	
	
	
	
	
	
	public void addEasy(String mword, String mmeaning, String mown) throws SQLException {
		ContentValues cvEasy = new ContentValues();
		cvEasy.put(KEY_WORD, mword);
		cvEasy.put(KEY_MEANING, mmeaning);
		cvEasy.put(KEY_OWN, mown);
		//cvEasy.put(KEY_ROWID, lRow);
		ourDatabase.insert(DATABASE_TABLEEASY, null, cvEasy);
		ourDatabase.delete(DATABASE_TABLE, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLE800, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLEMEDIUM, KEY_WORD+" = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLEDIFFICULT, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLE4000, KEY_WORD+ " = '" + mword+"'", null);
		
		

		

	}
	
	
	public String getWordEasy(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLEEASY, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String word = c.getString(1);
			return word;
		}
		return null;
	}

	public String getMeaningEasy(long l) throws SQLException{
				// TODO Auto-generated method stub
				String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
				Cursor c= ourDatabase.query(DATABASE_TABLEEASY, columns, KEY_ROWID + "="+ l, null, null, null, null);
				if(c !=null){
					c.moveToFirst();
					String meaning = c.getString(2);
					return meaning;
		
	}return null;
	}

	public String getOwnEasy(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLEEASY, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String own = c.getString(3);
			return own;

}return null;
}
	
	
	public void addMedium(String mword, String mmeaning, String mown) throws SQLException {
		ContentValues cvEasy = new ContentValues();
		cvEasy.put(KEY_WORD, mword);
		cvEasy.put(KEY_MEANING, mmeaning);
		cvEasy.put(KEY_OWN, mown);
		//cvEasy.put(KEY_ROWID, lRow);
		ourDatabase.insert(DATABASE_TABLEMEDIUM, null, cvEasy);
		ourDatabase.delete(DATABASE_TABLE, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLE800, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLE4000, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLEDIFFICULT, KEY_WORD+" = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLEEASY, KEY_WORD+ " = '" + mword+"'", null);
		Log.d(mown, "medium add function");
		ourDatabase.close();

}
	
	
	public String getWordMedium(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLEMEDIUM, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String word = c.getString(1);
			return word;
		}
		return null;
	}

	public String getMeaningMedium(long l) throws SQLException{
				// TODO Auto-generated method stub
				String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
				Cursor c= ourDatabase.query(DATABASE_TABLEMEDIUM, columns, KEY_ROWID + "="+ l, null, null, null, null);
				if(c !=null){
					c.moveToFirst();
					String meaning = c.getString(2);
					return meaning;
		
	}return null;
	}

	public String getOwnMedium(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLEMEDIUM, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String own = c.getString(3);
			return own;

}return null;
}

	
	public void addDifficult(String mword, String mmeaning, String mown) throws SQLException {
		ContentValues cvEasy = new ContentValues();
		cvEasy.put(KEY_WORD, mword);
		cvEasy.put(KEY_MEANING, mmeaning);
		cvEasy.put(KEY_OWN, mown);
		//cvEasy.put(KEY_ROWID, lRow);
		ourDatabase.insert(DATABASE_TABLEDIFFICULT, null, cvEasy);
		ourDatabase.delete(DATABASE_TABLE, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLE800, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLE4000, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLEMEDIUM, KEY_WORD+" = '" + mword+"'", null);
		ourDatabase.delete(DATABASE_TABLEEASY, KEY_WORD+ " = '" + mword+"'", null);

	}
	
	
	public String getWordDifficult(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLEDIFFICULT, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String word = c.getString(1);
			return word;
		}
		return null;
	}

	public String getMeaningDifficult(long l) throws SQLException{
				// TODO Auto-generated method stub
				String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
				Cursor c= ourDatabase.query(DATABASE_TABLEDIFFICULT, columns, KEY_ROWID + "="+ l, null, null, null, null);
				if(c !=null){
					c.moveToFirst();
					String meaning = c.getString(2);
					return meaning;
		
	}return null;
	}

	public String getOwnDifficult(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns= new String[]{ KEY_ROWID,KEY_WORD,KEY_MEANING,KEY_OWN};
		Cursor c= ourDatabase.query(DATABASE_TABLEDIFFICULT, columns, KEY_ROWID + "="+ l, null, null, null, null);
		if(c !=null){
			c.moveToFirst();
			String own = c.getString(3);
			return own;

}return null;
}

	

	public void updateOwn(String mword, String mmeaning, String mown)
	{
		try{
		// TODO Auto-generated method stub
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_WORD,mword);
		cvUpdate.put(KEY_MEANING,mmeaning);
		cvUpdate.put(KEY_OWN, mown);
		ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.update(DATABASE_TABLE800, cvUpdate, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.update(DATABASE_TABLE4000, cvUpdate, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.update(DATABASE_TABLEEASY, cvUpdate, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.update(DATABASE_TABLEMEDIUM, cvUpdate, KEY_WORD+ " = '" + mword+"'", null);
		ourDatabase.update(DATABASE_TABLEDIFFICULT, cvUpdate, KEY_WORD+ " = '" + mword+"'", null);
		 Log.d(mown, "Database updated");
		 ourDatabase.close();
		 
		}
		catch (Exception e)
		{String error=e.toString();
		Log.d(TAG, error);
		}
		}
	
	
	public long countdb() {
		return DatabaseUtils.queryNumEntries(ourDatabase,DATABASE_TABLE);
		}
	
	public long countdb800() {
		return DatabaseUtils.queryNumEntries(ourDatabase,DATABASE_TABLE800);
		}
	
	public long countdb4000() {
		return DatabaseUtils.queryNumEntries(ourDatabase,DATABASE_TABLE4000);
		}
	
	public long countdbeasy() {
		return DatabaseUtils.queryNumEntries(ourDatabase,DATABASE_TABLEEASY);
		}
	
	public long countdbmedium() {
		return DatabaseUtils.queryNumEntries(ourDatabase,DATABASE_TABLEMEDIUM);
		}
	
	public long countdbdifficult() {
		return DatabaseUtils.queryNumEntries(ourDatabase,DATABASE_TABLEDIFFICULT);
		}
	
	
	
	public void updateEntry(long lRow, String mword, String mmeaning)throws SQLException {
		// TODO Auto-generated method stub
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_WORD,mword);
		cvUpdate.put(KEY_MEANING,mmeaning);
		ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID+ "="+ lRow, null);
	}

	public void deleteEntry(long lRow1)throws SQLException {
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, KEY_ROWID+ "=" +lRow1, null);
		
	}
}