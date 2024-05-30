package org.tensorflow.lite.examples.classification;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class HomePage extends Activity {
	int splashTime = 3000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Thread thread = new Thread() {
			public void run() {
				try {
					synchronized (this) {
						wait(splashTime);
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					startActivity(new Intent(HomePage.this,
							UserLoginActivity.class));
					finish();
				}
			}
		};
		thread.start();
		 
	}

	

}
