package com.example.pbl;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{

	private Context context;
	private LayoutInflater listContainer; 
	private List<Map<String, Object>> listItems; 
	
	public final class Mylist{
		public ImageView image;     
        public TextView title;
        public TextView info;
        public Button detail;  
	}
	
	public MyAdapter(Context context,List<Map<String,Object>> list){
		this.context=context;
		listContainer = LayoutInflater.from(context);   //创建视图容器并设置上下文   
        this.listItems = list;   
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		final int selectID = position;   
		Mylist mylist=null;
		if (convertView == null) {   
			mylist = new Mylist();    
            //获取list_item布局文件的视图   
            convertView = listContainer.inflate(R.layout.bing_pubu, null);   
            //获取控件对象   
            mylist.image = (ImageView)convertView.findViewById(R.id.bingdesinger);   
            mylist.title = (TextView)convertView.findViewById(R.id.desname);   
            mylist.info= (TextView)convertView.findViewById(R.id.desintro);   
            //设置控件集到convertView   
            convertView.setTag(mylist);   
        }else {   
        	mylist = (Mylist)convertView.getTag();   
        }   
		
		mylist.image.setImageResource((Integer)listItems.get(position)
				.get("imag"));
		mylist.title.setText((String) listItems.get(position)   
                .get("title"));
		mylist.info.setText((String) listItems.get(position)   
                .get("title"));
		
		
		return convertView;
	}

}
