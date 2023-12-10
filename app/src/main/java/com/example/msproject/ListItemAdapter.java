package com.example.msproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItemAdapter extends BaseAdapter {
    ArrayList<ListItem> items=new ArrayList<ListItem>();
    Context context;
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context=parent.getContext();
        ListItem listItem= items.get(position);
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.listview_item,parent,false);
        }
        ImageView image=convertView.findViewById(R.id.img);
        TextView text1=convertView.findViewById(R.id.text1);
        byte[]imgData= listItem.getimg();
        Bitmap bitmap= BitmapFactory.decodeByteArray(imgData, 0, imgData.length);
        image.setImageBitmap(bitmap);
        text1.setText(listItem.gettext1());
        return convertView;
    }
    public void addItem(ListItem item)
    {
        items.add(item);
    }
}
