package com.caoyang.news.activitys.adapters;

import android.support.v4.app.Fragment;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.caoyang.news.R;


import java.util.List;

/**
 * Created by caoyang on 17-6-27.
 */

public class Adapter extends BaseAdapter {
    private List<String> listString;
    private Context context;
    private Fragment fragment;
    private List<String> listContent;

    public Adapter(List<String> list, Context context,List<String> listContent) {
        this.listString = list;
        this.context = context;
        this.listContent = listContent;
    }


    @Override
    public int getCount() {
        return listString.size();
    }

    @Override
    public Object getItem(int position) {
        return listString.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_view, null);
            convertView.setTag(new Holder(convertView));
        }

        Holder holder = (Holder) convertView.getTag();
        holder.text.setText(listString.get(position));

        return convertView;
    }

    class Holder {
        private TextView text;

        public Holder(View convertView) {
            text = (TextView) convertView.findViewById(R.id.text_content);
        }
    }

}
