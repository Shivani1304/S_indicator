package com.sindicator.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sindicator.R;

/**
 * Created by Shivani on 1/4/2017.
 */

public class GridAdp extends BaseAdapter {

    Context cn;
    private final String[] name;
    private final int[] img;

    public GridAdp(Context cn, String[] name, int[] img) {
        this.cn = cn;
        this.name = name;
        this.img = img;
    }


    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) cn.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
        {
            Typeface tf=Typeface.createFromAsset(cn.getAssets(),"Dustismo_Roman.ttf");
            view = inflater.inflate(R.layout.rows,null);
            TextView rtxt = (TextView) view.findViewById(R.id.txt1);
            ImageView rimg = (ImageView) view.findViewById(R.id.img1);
            rimg.setImageResource(img[position]);
            rtxt.setText(name[position]);

            rtxt.setTypeface(tf);


        }

        return view;
    }
}
