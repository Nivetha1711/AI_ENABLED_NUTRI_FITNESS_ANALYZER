package org.tensorflow.lite.examples.classification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;

public class AdminActivity extends Activity  {

	Connection conn;
	EditText username,password,hostIP;
	Button btn1,btn2,btn3,btn4,btn5;
	String user,pass,user1,pass1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_main);
		

		btn3=(Button)findViewById(R.id.logoutbtn);
		btn4=(Button)findViewById(R.id.videobtn);
		btn5=(Button)findViewById(R.id.feedbackbtn);
		
//		conn=CONN();

		
		
		btn3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent(AdminActivity.this,AdminLoginActivity.class));
				
			}
			
		});



		btn4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				startActivity(new Intent(AdminActivity.this, AddVideo.class));

			}

		});

		btn5.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				startActivity(new Intent(AdminActivity.this, ViewFeedback.class));

			}

		});
	}

	
	
	


}
