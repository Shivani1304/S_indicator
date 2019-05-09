package com.sindicator.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class Private1 extends Fragment {

    ListView pri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.private1, container, false);
        pri = (ListView) view.findViewById(R.id.prilst);
        pri.setAdapter(new CustomAdpter(getActivity()));
        return view;
    }

    class ListpriHosp {
        String name;
        String address;
        String contact;
        int img;


        public ListpriHosp(String name, String address, String contact) {
            this.name = name;
            this.address = address;
            this.contact = contact;

        }


    }

    class CustomAdpter extends BaseAdapter {

        ArrayList<ListpriHosp> arrayList;
        Context context;
        LayoutInflater inflater;

        CustomAdpter(Context c) {
            context = c;
            arrayList = new ArrayList<>();
            Resources res = c.getResources();

            String[] name = res.getStringArray(R.array.priname);
            String[] address = res.getStringArray(R.array.priadr);
            String[] contact = res.getStringArray(R.array.pricontact);

            for (int i = 0; i < 7; i++) {
                arrayList.add(new ListpriHosp(name[i], address[1], contact[i]));

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
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            Typeface tf=Typeface.createFromAsset(context.getAssets(),"Dustismo_Roman.ttf");

            View view = inflater.inflate(R.layout.rowlayout, parent, false);
            hosp = (TextView) view.findViewById(R.id.txthp);
            addr = (TextView) view.findViewById(R.id.txtadr);
            call = (TextView) view.findViewById(R.id.txtcall);
           // imgage = (ImageButton) view.findViewById(R.id.imgcall);

            ListpriHosp l = arrayList.get(position);
            hosp.setText(l.name);  //model class name
            addr.setText(l.address);
            call.setText(l.contact);
          //  imgage.setImageResource(R.drawable.circle);

            hosp.setTypeface(tf);
            addr.setTypeface(tf);
            call.setTypeface(tf);

//            imgage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ListpriHosp list = arrayList.get(position);
//                    Intent intent = new Intent((Intent.ACTION_CALL), Uri.parse("tel:" + list.contact.toString()));
//                    startActivity(intent);
//                }
//            });
            return view;
        }
    }
}