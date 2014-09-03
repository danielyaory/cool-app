package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;



public class Entry_point extends Activity {

	
	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entry_screen);
		ourSong = MediaPlayer.create(this, R.raw.splash_sound);
		
		Thread timer=new Thread(){
			public void run(){
			  try{
				  ourSong.start();
				  sleep(2000);
				  
			  }
				catch(InterruptedException e){
					
					e.printStackTrace();
				}finally{
					
					Intent OpenMainActivity= new Intent("com.example.MyFirstApp.MainActivity");
					startActivity(OpenMainActivity);
					
				}
				
			}
		};
		
		timer.start();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
	
		super.onPause();
		ourSong.release();
		finish();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	

}
