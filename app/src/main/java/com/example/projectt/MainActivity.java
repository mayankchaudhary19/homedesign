package com.example.projectt;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FloatingActionButton fab;
    FloatingActionButton fab_call;
    FloatingActionButton fab_mail;
    FloatingActionButton fab_text;
    FloatingActionButton fab_whatsApp;
    FloatingActionButton fab_maps;

    Animation fab_open;
    Animation fab_close;
    Animation rclockwise;
    Animation ranticlockwise;
    boolean isOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab=findViewById(R.id.fab);
        fab_call=findViewById(R.id.fab_call);
        fab_mail=findViewById(R.id.fab_mail);
        fab_text=findViewById(R.id.fab_text);
        fab_whatsApp=findViewById(R.id.fab_whatsApp);
        fab_maps=findViewById(R.id.fab_maps);

        fab_open= AnimationUtils.loadAnimation(MainActivity.this,R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(MainActivity.this,R.anim.fab_close);
        rclockwise= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_clockwise);
        ranticlockwise= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_anticlockwise);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isOpen){
                    fab_call.startAnimation(fab_close);
                    fab_mail.startAnimation(fab_close);
                    fab_text.startAnimation(fab_close);
                    fab_whatsApp.startAnimation(fab_close);
                    fab_maps.startAnimation(fab_close);
                    isOpen=false;
                }
                else{

                    fab_call.startAnimation(fab_open);
                    fab_mail.startAnimation(fab_open);
                    fab_text.startAnimation(fab_open);
                    fab_whatsApp.startAnimation(fab_open);
                    fab_maps.startAnimation(fab_open);



                    fab_call.setClickable(true);
                    fab_mail.setClickable(true);
                    fab_text.setClickable(true);
                    fab_whatsApp.setClickable(true);
                    fab_maps.setClickable(true);
                    isOpen=true;
                }

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });


        fab_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9975447638"));
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    return;
                }
                startActivity(intent);
            }
        });

        //Handle the mail button
        fab_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

        //Handle the message button
        fab_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        //Handle the whatsApp button
        fab_whatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp();
            }
        });

        //Handle the message button
        fab_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaps();
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    protected void sendMail(){
        String[] TO={""};
        String[] CC={""};
        Intent mailIntent=new Intent(Intent.ACTION_SEND);


        mailIntent.setData(Uri.parse("mailto:"));
        mailIntent.setType("text/plain");
        mailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        mailIntent.putExtra(Intent.EXTRA_CC, CC);
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject goes here");
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Mail body goes here");
        try{
            startActivity(Intent.createChooser(mailIntent,"Send Mail using..."));
            finish();
        }
        catch (android.content.ActivityNotFoundException e){
            Toast.makeText(MainActivity.this, "Mail send failed!", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendMessage(){
        Intent smsIntent=new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String ("1234567890"));
        smsIntent.putExtra("sms_body"  , "Hello World ");
        try{
            startActivity(smsIntent);
            finish();
        }
        catch (android.content.ActivityNotFoundException e){
            Toast.makeText(MainActivity.this, "SMS failed!", Toast.LENGTH_SHORT).show();
        }

    }

    private void openWhatsApp(){
        Toast.makeText(MainActivity.this, "To open whatApp", Toast.LENGTH_SHORT).show();
    }

    private void openMaps(){
        Toast.makeText(MainActivity.this, "To open maps", Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_products) {

        } else if (id == R.id.nav_notifications) {

        } else if (id == R.id.nav_offer_zone) {

        } else if (id == R.id.nav_we_care) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_rate) {

        } else if (id == R.id.nav_contact_us) {

        } else if (id == R.id.nav_store) {

        } else if (id == R.id.nav_franchise) {

        } else if (id == R.id.nav_about_us){


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
