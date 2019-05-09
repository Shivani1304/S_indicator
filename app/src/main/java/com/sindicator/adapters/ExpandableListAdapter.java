package com.sindicator.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.sindicator.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Admin on 08/12/16.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {


    private Context context;
    private List<String> listHeader;
    private HashMap<String, List<String>> listChild;

    public ExpandableListAdapter(Context context, List<String> listHeader,
                                 HashMap<String, List<String>> listChild) {
        this.context = context;
        this.listHeader = listHeader;
        this.listChild = listChild;
    }

    @Override
    public int getGroupCount() {
        return this.listHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.listChild.get(this.listHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.listHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.listChild.get(this.listHeader.get(i))
                .get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String headerTitle = (String) getGroup(i);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.header, null);
        }

        Typeface tf=Typeface.createFromAsset(context.getAssets(),"Dustismo_Roman.ttf");
        TextView tvheader = (TextView) view
                .findViewById(R.id.tvheader);
        tvheader.setText(headerTitle);

        tvheader.setTypeface(tf);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        final String childText = (String) getChild(i, i1);
        Typeface tf=Typeface.createFromAsset(context.getAssets(),"Dustismo_Roman.ttf");
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.child, null);
        }

        TextView tvchild = (TextView) view
                .findViewById(R.id.tvchild);
        tvchild.setTypeface(tf);
        tvchild.setText(childText);
        return view;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
