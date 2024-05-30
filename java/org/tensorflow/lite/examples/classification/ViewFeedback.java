package org.tensorflow.lite.examples.classification;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class ViewFeedback extends Activity {
	ListView listView;
	Connection conn;
	Double lat,lon;
	String username;
	
	
	String lati,longi,loginname,areaname1,memquant;
	
	String sendername;
	String collegecode;
	HashMap<String,String> usersList1 = null;
	ArrayList<HashMap<String,String>> usersList2 = new ArrayList<HashMap<String,String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedbackview_list);
		 listView = (ListView) findViewById(R.id.listView1);

		 //SharedPreferences preferences1=getSharedPreferences("username1", Context.MODE_PRIVATE);
		 //username=preferences1.getString("username1",null);
			

		try{



			new QuerySQL().execute();
		}
		catch (Exception e){
			System.out.println("NumberFormatException: " + e.getMessage());
		}
	}


	public class QuerySQL extends AsyncTask<Object, Void, Boolean> {

		ProgressDialog pDialog ;
		Exception error;


		ResultSet rs;
		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = new ProgressDialog(ViewFeedback.this);
			pDialog.setTitle("View Feedback");
			pDialog.setMessage("Getting List...");
			pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected Boolean doInBackground(Object... args) {



			try {


				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://mysql-75344-0.cloudclusters.net:18880/foodwheelchairuser","admin","cU5zYktH");
			} catch (SQLException se) {
				Log.e("ERRO1",se.getMessage());
			} catch (ClassNotFoundException e) {
				Log.e("ERRO22",e.getMessage());
			} catch (Exception e) {
				Log.e("ERRO3",e.getMessage());
			}


			try {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date currentDate = new Date();


				// convert date to calendar
				Calendar c = Calendar.getInstance();
				c.setTime(currentDate);

				// manipulate date
				//c.add(Calendar.YEAR, 1);
				//c.add(Calendar.MONTH, 1);
				c.add(Calendar.DATE, -2); //same with c.add(Calendar.DAY_OF_MONTH, 1);
				//c.add(Calendar.HOUR, 1);
				//c.add(Calendar.MINUTE, 1);
				//c.add(Calendar.SECOND, 1);

				// convert calendar to date
				Date currentDatePlusOne = c.getTime();

				String tmp = dateFormat.format(currentDatePlusOne);

				//String solved = "solved";
				String collectstatus = "collected";
				String acceptstatus = "accepted";
				String requeststatus = "requested";
				String COMANDOSQL="select * from feedback";
				Statement statement = conn.createStatement();
				rs = statement.executeQuery(COMANDOSQL);
				while(rs.next()){
					
									
			
					
					usersList1 = new HashMap<String, String>();
					//	usersList1.put("uname",rs.getString("name"));
					
					usersList1.put("username",rs.getString(1));
					usersList1.put("subject",rs.getString(2));
					usersList1.put("des",rs.getString(3));
					//usersList1.put("totalseats",rs.getString(7));
					//usersList1.put("alloted",rs.getString(8));
					Log.d("Friend List Map :",usersList1.toString());

					usersList2.add(usersList1);


				}

				return true;
				// Toast.makeText(getBaseContext(),
				// "Successfully Inserted.", Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				error = e;
				return false;
//				Toast.makeText(getBaseContext(),"Successfully Registered...", Toast.LENGTH_LONG).show();
			}


		}

		@SuppressLint("NewApi")
		@Override
		protected void onPostExecute(Boolean result1) {
			pDialog.dismiss ( ) ;
			if(result1)
			{



//					System.out.println("ELSE(JSON) LOOP EXE");
				try {// try3 open

					listView.setAdapter(new FeedbackViewAdapter(ViewFeedback.this, usersList2));


				} catch (Exception e1) {
					Toast.makeText(getBaseContext(), e1.toString(),
							Toast.LENGTH_LONG).show();

				}


			}else
			{
				if(error!=null)
				{
					Toast.makeText(getBaseContext(),error.getMessage().toString() ,Toast.LENGTH_LONG).show();
				}
			}
			super.onPostExecute(result1);
		}
	}


}
