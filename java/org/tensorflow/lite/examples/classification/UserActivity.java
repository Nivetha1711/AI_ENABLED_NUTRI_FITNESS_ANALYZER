package org.tensorflow.lite.examples.classification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;

public class UserActivity extends Activity  {

	Connection conn;
	EditText username,password,hostIP;
	Button btn1,btn2,btn3,btn4,btn5;
	String user,pass,user1,pass1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_main);
		
		btn1=(Button)findViewById(R.id.foodbtn);
		//btn2=(Button)findViewById(R.id.caloriebtn);
		//btn3=(Button)findViewById(R.id.blockbtn);
		btn3=(Button)findViewById(R.id.logoutbtn);
		btn4=(Button)findViewById(R.id.videobtn);
		btn5=(Button)findViewById(R.id.feedbackbtn);
		
//		conn=CONN();
		btn1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent(UserActivity.this,ClassifierActivity.class));
				//SharedPreferences.Editor editor =getSharedPreferences("username",Context.MODE_PRIVATE).edit();
                //editor.putString("username",user);
               // editor.commit();
               // editor.apply();

					
				
				
			}
			
		});

		
		
		
		btn3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent(UserActivity.this,UserLoginActivity.class));		
				
			}
			
		});



		btn4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				startActivity(new Intent(UserActivity.this,ViewVideoList.class));

			}

		});

		btn5.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				startActivity(new Intent(UserActivity.this,AddFeedback.class));

			}

		});
	}

	
	
	


}
