package com.example.pbl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_AbsListView.OnScrollListener;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import com.huewu.pla.lib.internal.PLA_AdapterView.OnItemClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private class MySimpleAdapter extends ArrayAdapter<String> {

		public MySimpleAdapter(Context context, int layoutRes) {
			super(context, layoutRes, android.R.id.text1);
		}
	}
	private MySimpleAdapter mAdapter = null;
	
	MultiColumnListView multiColumnListView;
	
	private static final String TAG="MainActivity";
	
	private MyAdapter myAdapter;
	
	private List<Map<String, Object>> listItems;   
	
	private String[] goodsNames = {"蛋糕", "礼物",    
            "邮票", "爱心", "鼠标", "音乐CD"};   
    private String[] goodsDetails = {   
            "蛋糕：好好吃。",    
            "礼物：礼轻情重。",    
            "邮票：环游世界。",    
            "爱心：世界都有爱。",   
            "鼠标：反应敏捷。",   
            "音乐CD：酷我音乐。"}; 
    
    private Integer[] imgeIDs = {R.drawable.designer2,    
            R.drawable.designer3, R.drawable.designer1,   
            R.drawable.designer4, R.drawable.designer5,   
            R.drawable.designer6};
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		multiColumnListView=(MultiColumnListView)findViewById(R.id.fl_media_falls_list);
		
		multiColumnListView.setClickable(true);
		
		multiColumnListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(PLA_AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.i(TAG, "选中:"+position);
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, PullResh.class);
				startActivity(intent);
			}
		});
		
		
		multiColumnListView.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(PLA_AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent();
//				intent.setClass(MainActivity.this, PullResh.class);
//				startActivity(intent);
			}
			
			@Override
			public void onScroll(PLA_AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				
			}
		});
//		LayoutInflater inflater = getLayoutInflater();
//		View mView=inflater.inflate(R.layout.newbing, null);
//		
//		multiColumnListView.addHeaderView(mView);
//		multiColumnListView.addFooterView(mView);
		
//		multiColumnListView.setEmptyView(mView);
//		multiColumnListView.addHeaderView(mView);
//		multiColumnListView.addHeaderView(mView);
//		multiColumnListView.addHeaderView(mView);
//		multiColumnListView.addHeaderView(mView);
//		multiColumnListView.addHeaderView(mView);
		
//		{
//			for( int i = 0; i < 3; ++i ){
//				//add header view.
//				TextView tv = new TextView(this);
//				tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
//				tv.setText("Hello Header!! ........................................................................");
//				multiColumnListView.addHeaderView(tv);
//			}
//		}
//		{
//			for( int i = 0; i < 3; ++i ){
//				//add footer view.
//				TextView tv = new TextView(this);
//				tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
//				tv.setText("Hello Footer!! ........................................................................");
//				multiColumnListView.addFooterView(tv);
//			}
//		}
		
		
	}

	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
//		initAdapter();
//		multiColumnListView.setAdapter(mAdapter);
		
		inintmyAdapter();
		
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

	public void inintmyAdapter(){
		myAdapter=new MyAdapter(MainActivity.this, getListItems());
		
		multiColumnListView.setAdapter(myAdapter);
	}
	
	private List<Map<String, Object>> getListItems() {   
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
        for(int i = 0; i < goodsNames.length; i++) {   
            Map<String, Object> map = new HashMap<String, Object>();    
            map.put("imag", imgeIDs[i]);               //图片资源   
//            map.put("title", "物品名称：");              //物品标题   
            map.put("title", goodsNames[i]);     //物品名称   
//            map.put("detail", goodsDetails[i]); //物品详情   
            listItems.add(map);   
        }      
        return listItems;   
    }
	
	
}
