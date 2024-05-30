package org.tensorflow.lite.examples.classification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class VideoViewAdapter extends BaseAdapter {
	Context con;
	LayoutInflater layoutInflater;
	ArrayList<HashMap<String,String>> listvalue;

	public VideoViewAdapter(ViewVideoList listOfFriendsActivity,
							ArrayList<HashMap<String,String>> usersList) {
		// TODO Auto-generated constructor stub
		con = listOfFriendsActivity;
		listvalue = usersList;
		layoutInflater = LayoutInflater.from(listOfFriendsActivity);
	}

	

	public int getCount() {
		// TODO Auto-generated method stub
		return listvalue.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listvalue.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.video_view, null);
			viewHolder = new ViewHolder();

			viewHolder.txtUsername = (TextView) convertView
					.findViewById(R.id.textView_name);

			viewHolder.txtmobile = (TextView) convertView
					.findViewById(R.id.textView_type);

					

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.txtUsername.setText(listvalue.get(position).get("videoname")
				.toString());

		viewHolder.txtmobile.setText(listvalue.get(position).get("videolink")
				.toString());

		


		return convertView;

	}

	class ViewHolder {
		TextView txtUsername,txtmobile,txttime;

	}

}
