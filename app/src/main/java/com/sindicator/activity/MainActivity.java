package com.sindicator.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.sindicator.BuilderManager;
import com.sindicator.R;
import com.sindicator.adapters.GridAdp;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    String texts[] = {"Bus","Hotel","Hospital","Police Station","Picnic","Emergency"};
    int img[] = {R.drawable.busoriginal,
                 R.drawable.hoteloriginal,
                 R.drawable.hospitaloriginal,
                 R.drawable.policestation,
                 R.drawable.picnicoriginal,
                 R.drawable.emergencyoriginal };
    boolean doubleBackToExitPressedOnce = false;
    private BoomMenuButton bmb;
    private static final int REQUEST_INTERNET = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = (GridView) findViewById(R.id.grid);
        GridAdp adp = new GridAdp(MainActivity.this, texts, img);
        grid.setAdapter(adp);

        //   ******************************** Boom menu***********************************************************************

        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        bmb.setButtonEnum(ButtonEnum.SimpleCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_2);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_4_2);

        for (int i = 0; i < 4; i++) {

            bmb.addBuilder(BuilderManager.getSimpleCircleButtonBuilder());

        }
        bmb.setOnBoomListener(new OnBoomListener() {

            @Override
            public void onClicked(int index, BoomButton boomButton) {
                if (index == 0) {

                }
                if (index == 1) {

                }
                if (index == 2) {

                }

                if (index == 3) {
                   new AlertDialog.Builder(MainActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Exit")
                            .setMessage("Are you sure you want to Exit?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }

                            })
                            .setNegativeButton("No", null)
                            .show();
                }
            }

            @Override
            public void onBackgroundClick() {

            }

            @Override
            public void onBoomWillHide() {

            }

            @Override
            public void onBoomDidHide() {

            }

            @Override
            public void onBoomWillShow() {

            }

            @Override
            public void onBoomDidShow() {

            }
        });

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (texts[position].toString() == "Bus") {
                    Intent i = new Intent(MainActivity.this, BusModule.class);

                    startActivity(i);
                }
                else if (texts[position].toString() == "Hospital") {
                    Intent i = new Intent(MainActivity.this, HospitalModule.class);

                    startActivity(i);
                }
                else if (texts[position].toString() == "Police Station") {
                    Intent i = new Intent(MainActivity.this, PolicestationModule.class);

                    startActivity(i);
                }

                else if (texts[position].toString() == "Picnic") {
                    Intent i = new Intent(MainActivity.this, PicnicModule.class);

                    startActivity(i);
                }

                else if (texts[position].toString() == "Emergency") {
                    Intent i = new Intent(MainActivity.this, EmergencyModule.class);

                    startActivity(i);
                }

                else if (texts[position].toString() == "Hotel") {
                    Intent i = new Intent(MainActivity.this, HotelModule.class);

                    startActivity(i);
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong Choice", Toast.LENGTH_SHORT).show();
                }
            }
        });

//drawer
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    //drawer
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            new android.support.v7.app.AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Exit")
                    .setMessage("Are you sure you want to Exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }


       /* Intent i =new Intent(this,MainActivity.class);
        startActivity(i);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_favorite) {

            Intent i = new Intent(getApplicationContext(),NearbySearch.class);
            startActivity(i);
        }

        if (id == R.id.share) {

            switch (item.getItemId()) {
                case R.id.share:

                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBodyText = "Share whatever";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                    startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        if (id == R.id.Exit) {

            new android.support.v7.app.AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Exit")
                    .setMessage("Are you sure you want to Exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.bus1) {

        } else if (id == R.id.police1) {

        } else if (id == R.id.hospital1) {

        } else if (id == R.id.resturent1) {

        }else if (id == R.id.picnic1) {

        }else if (id == R.id.emergency1) {

        }
        else if (id == R.id.nav_share) {
            switch (item.getItemId()) {
                case R.id.nav_share:

                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBodyText = "Share whatever";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                    startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }


        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_INTERNET) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //start audio recording or whatever you planned to do
            }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CALL_PHONE)) {
                    //Show an explanation to the user *asynchronously*
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
                    builder.setMessage("This permission is important to call.")
                            .setTitle("Important permission required");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_INTERNET);
                        }
                    });
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_INTERNET);
                }else{
                    //Never ask again and handle your app without permission.
                }
            }
        }
    }
}

