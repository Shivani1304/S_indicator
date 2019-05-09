package com.sindicator.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sindicator.R;

import java.util.ArrayList;

/**
 * Created by sony on 22-01-2017.
 */
public class Government extends android.support.v4.app.Fragment {

    ListView gov;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View viewitem = inflater.inflate(R.layout.government,container,false);
        gov = (ListView) viewitem.findViewById(R.id.govlst);
        gov.setAdapter(new Custom_adp(getActivity()));


        return viewitem;
    }

    class ListGovHosp{
        String name;
        String address;
        String contact;
        int img;


        public ListGovHosp(String name, String address, String contact){
            this.name=name;
            this.address=address;
            this.contact=contact;

        }


    }

    class Custom_adp extends BaseAdapter {

        ArrayList<ListGovHosp> arrayList;
        Context context;
        LayoutInflater inflater;
        Custom_adp(Context c){
            context=c;
            arrayList=new ArrayList<ListGovHosp>();
            Resources res=c.getResources();

            String[] name=res.getStringArray(R.array.govname);
            String[] address=res.getStringArray(R.array.address);
            String[] contact=res.getStringArray(R.array.contact);

            for(int i=0;i<7;i++){
                arrayList.add(new ListGovHosp(name[i],address[i],contact[i]));

            }

        }
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            TextView hosp;
            final TextView addr;
            TextView call;
            final ImageButton imgage;
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            Typeface tf=Typeface.createFromAsset(context.getAssets(),"Dustismo_Roman.ttf");

            View view=inflater.inflate(R.layout.rowlayout, parent,false);
            hosp= (TextView) view.findViewById(R.id.txthp);
            addr= (TextView) view.findViewById(R.id.txtadr);
            call= (TextView) view.findViewById(R.id.txtcall);
            imgage= (ImageButton) view.findViewById(R.id.imgcall);

            ListGovHosp l=arrayList.get(position);
            hosp.setText(l.name);  //model class name
            addr.setText(l.address);
            call.setText(l.contact);
            imgage.setImageResource(R.drawable.circle);

            hosp.setTypeface(tf);
            addr.setTypeface(tf);
            call.setTypeface(tf);

            imgage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListGovHosp list=arrayList.get(position);
                    Intent intent=new Intent((Intent.ACTION_CALL), Uri.parse("tel:"+list.name.toString()));
                    startActivity(intent);
                }
            });
            return view;
        }
    }
}
