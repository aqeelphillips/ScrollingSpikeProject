package com.example.scrollingspikeproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
	static final String EXTRA_MESSAGE = null;
	static final String EXTRA_INT = null;
	private SimpleSpark[] sparks = {
			new SimpleSpark("Laying down!", R.drawable.sample_1),
			new SimpleSpark("In a coat!", R.drawable.sample_2), 
			new SimpleSpark("In a basket!", R.drawable.sample_6), 
			new SimpleSpark("Laying down!", R.drawable.sample_1),
			new SimpleSpark("In a coat!", R.drawable.sample_2), 
			new SimpleSpark("In a basket!", R.drawable.sample_6), 
			new SimpleSpark("Laying down!", R.drawable.sample_1),
			new SimpleSpark("In a coat!", R.drawable.sample_2), 
			new SimpleSpark("In a basket!", R.drawable.sample_6), 
			new SimpleSpark("Laying down!", R.drawable.sample_1),
			new SimpleSpark("In a coat!", R.drawable.sample_2), 
			new SimpleSpark("In a basket!", R.drawable.sample_6), 
			new SimpleSpark("Laying down!", R.drawable.sample_1),
			new SimpleSpark("In a coat!", R.drawable.sample_2), 
			new SimpleSpark("In a basket!", R.drawable.sample_6), 
			new SimpleSpark("Laying down!", R.drawable.sample_1),
			new SimpleSpark("In a coat!", R.drawable.sample_2), 
			new SimpleSpark("In a basket!", R.drawable.sample_6), 
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	    final GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this, sparks));
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            //Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	            //Toast.makeText(MainActivity.this, "" + sparks[position].getName(), Toast.LENGTH_SHORT).show();
	            sendMessage(sparks[position]);
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void sendMessage (SimpleSpark s){
		Bundle b = new Bundle();
		b.putString("Name", s.getName());
		b.putInt("Id", s.getId());
    	Intent intent = new Intent(this, SparkView.class);
    	intent.putExtra(EXTRA_MESSAGE, b);
    	startActivity(intent);
    }
}
