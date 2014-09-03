package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends ActionBarActivity {
	int start_Location;
	int end_location;
	int word_Counter;
	int space_place;
	String message;
	TextView textView;
	int jump_counter;
	String temp;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		start_Location = 0;
		end_location = 0;
		word_Counter = 0;
		space_place = 0;
		textView = new TextView(this);
		// Get the message from the intent
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		message = extras.getString("EXTRA_MESSAGE");
		temp= extras.getString("EXTRA_MESSAGE2");
		jump_counter=Integer.parseInt(temp);
		
		
		// counts the number of words
		for (int i = 0; i < message.length(); i++) {
			if (space_place != -1) {
				space_place = message.indexOf(" ", space_place + 1);
				word_Counter++;
			} else {

				i = message.length();
			}
		}

		// Create the text view

		textView.setTextSize(40);
		textView.setTypeface(null, Typeface.NORMAL);

		end_location = message.indexOf(" ", start_Location + 1);

		new CountDownTimer(word_Counter *1000 + 500, jump_counter*1000) {

			@Override
			public void onTick(long arg0) {
				// TODO Auto-generated method
				if (end_location != -1) {
					SpannableString new_Text = appendBold(message,
							start_Location, end_location);
					textView.setText(new_Text);
					start_Location = end_location + 1;
					end_location = message.indexOf(" ", start_Location);
				} else {
					SpannableString new_Text = appendBold(message,
							start_Location, message.length());
					textView.setText(new_Text);

				}
			}

			@Override
			public void onFinish() {
				textView.setText(message);

			}
		}.start();

		// Set the text view as the activity layout
		setContentView(textView);

	}

	public static SpannableString appendBold(String text, int start, int end) {
		SpannableString ss = new SpannableString(text);
		if (!TextUtils.isEmpty(text)) {
			ss.setSpan(new StyleSpan(Typeface.BOLD), start, end,
					Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		}

		return ss;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_display_message,
					container, false);
			return rootView;
		}
	}
}