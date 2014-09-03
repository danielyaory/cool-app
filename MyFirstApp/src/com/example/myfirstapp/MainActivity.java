package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
	
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	public final static String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE";
	int counter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		counter = 1;
	}

	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		if (counter == 1) {
			counter++;
		} else {
			overridePendingTransition(R.anim.animation_enter,
					R.anim.animation_leave);
		}
	}

	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		EditText editText2 =  (EditText) findViewById(R.id.time_counter);
		String message = editText.getText().toString();
		String number = editText2.getText().toString();
		intent.putExtra("EXTRA_MESSAGE", message);
		intent.putExtra("EXTRA_MESSAGE2", number);
		startActivity(intent);
		overridePendingTransition(R.anim.animation_enter,
				R.anim.animation_leave);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_search:
			openSearch();
			return true;
		case R.id.action_settings:
			openSettings();
			return true;
		case R.id.action_info:
			openInfo();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void openInfo() {
		Intent OpenInfoActivity = new Intent(this, Info.class);
		startActivity(OpenInfoActivity);
		
	}

	private void openSettings() {
		// TODO Auto-generated method stub

	}

	private void openSearch() {
		// TODO Auto-generated method stub

	}
}
