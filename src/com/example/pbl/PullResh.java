package com.example.pbl;

import java.util.Arrays;
import java.util.Random;

import com.huewu.pla.lib.internal.PLA_AdapterView;
import com.huewu.pla.lib.internal.PLA_AdapterView.OnItemClickListener;
import com.huewu.pla.lib.internal.PLA_AdapterView.OnItemSelectedListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class PullResh extends Activity {

	private class MySimpleAdapter extends ArrayAdapter<String> {

		public MySimpleAdapter(Context context, int layoutRes) {
			super(context, layoutRes, android.R.id.text1);
		}
	}
	private PLA_AdapterView<ListAdapter> mAdapterView = null;
	private MySimpleAdapter mAdapter = null;
	private static final String TAG="PullResh";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pull_resh);
		
		mAdapterView=(PLA_AdapterView<ListAdapter>)findViewById(R.id.binglist);
		mAdapterView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(PLA_AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.i(TAG, "选择:"+position);
			}
		});
		
		mAdapterView.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(PLA_AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.i(TAG, "选择:"+position);
			}

			@Override
			public void onNothingSelected(PLA_AdapterView<?> parent) {
				// TODO Auto-generated method stub
				Log.i(TAG, "选择:"+parent);
			}
		});
		
	}

	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		initAdapter();
		mAdapterView.setAdapter(mAdapter);
		
	}



	private Random mRand = new Random();
	private void initAdapter() {
		mAdapter = new MySimpleAdapter(this, R.layout.sample_item);

		for( int i = 0; i < 30; ++i){
			//generate 30 random items.

			StringBuilder builder = new StringBuilder();
			builder.append("Hello!![");
			builder.append(i);
			builder.append("] ");

			char[] chars = new char[mRand.nextInt(500)];
			Arrays.fill(chars, '1');
			builder.append(chars);
			mAdapter.add(builder.toString());
		}

	}
	
	
}
