package com.example.projectt;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
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
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.ArrayList;

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
    Animation rforward;
    Animation rbackward;
    boolean isOpen=false;


    SliderView sliderView;



    ArrayList<Categories> list,list1;
    ArrayList<Products> list3,list4,list5;

    RecyclerView recyclerView,recyclerView1,recyclerView3,recyclerView4,recyclerView5;

    int img[] = {R.drawable.ic_home_3,R.drawable.ic_hotel,R.drawable.ic_puzzle,R.drawable.ic_fan,R.drawable.ic_hindu,R.drawable.ic_stock};
    String t1[]= {"Household","Hotelware","Kids' Toys","Fan Blades","Navratri Special","Multipurpose Boxes"};
    int img2[]= {R.drawable.ic_hotel,R.drawable.ic_puzzle,R.drawable.ic_fan,R.drawable.ic_hindu,R.drawable.ic_stock,R.drawable.ic_hotel,R.drawable.ic_puzzle,R.drawable.ic_fan,R.drawable.ic_hindu,R.drawable.ic_hotel,R.drawable.ic_puzzle,R.drawable.ic_fan,R.drawable.ic_hindu,};
    String t2[]= {"LockBoxes","Containers","Baskets","Plates","Bowls","Glasses","Jugs","Soup Bowls","Buckets","Mugs","Tub","Soap Dishes","Dustbins & Dust-Pan"};

    int img3[]={R.drawable.unknown5,R.drawable.unknown,R.drawable.unknown3,R.drawable.abcd,R.drawable.unknown1,R.drawable.unknown2,R.drawable.unknown4};
    String[] title3={"Lock-box","Container","Tub","Glass","Kids' Toys","Fan Blades","Navratri Special"};
    String[] subtitle3={"Medium, 250g","Large,145g","Medium, 250g","Large,145g","Medium, 250g","Large,145g","Medium, 250g"};
    String[] price3={"₹150/pc","₹110/pc","₹150/pc","₹110/pc","₹150/pc","₹110/pc","₹150/pc"};
    String[] initialPrice3={"₹200","₹160","₹200","₹160","₹200","₹160","₹200"};

    int img4[]={R.drawable.unknown5,R.drawable.unknown,R.drawable.unknown3,R.drawable.abcd,R.drawable.unknown1,R.drawable.unknown2,R.drawable.unknown4};
    String[] title4={"Lock-box","Container","Tub","Glass","Kids' Toys","Fan Blades","Navratri Special"};
    String[] subtitle4={"Medium, 250g","Large,145g","Medium, 250g","Large,145g","Medium, 250g","Large,145g","Medium, 250g"};
    String[] price4={"₹150/pc","₹110/pc","₹150/pc","₹110/pc","₹150/pc","₹110/pc","₹150/pc"};
    String[] initialPrice4={"₹200","₹160","₹200","₹160","₹200","₹160","₹200"};

    int img5[]={R.drawable.unknown5,R.drawable.unknown,R.drawable.unknown3,R.drawable.abcd,R.drawable.unknown1,R.drawable.unknown2,R.drawable.unknown4};
    String[] title5={"Lock-box","Container","Tub","Glass","Kids' Toys","Fan Blades","Navratri Special"};
    String[] subtitle5={"Medium, 250g","Large,145g","Medium, 250g","Large,145g","Medium, 250g","Large,145g","Medium, 250g"};
    String[] price5={"₹150/pc","₹110/pc","₹150/pc","₹110/pc","₹150/pc","₹110/pc","₹150/pc"};
    String[] initialPrice5={"₹200","₹160","₹200","₹160","₹200","₹160","₹200"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_right_black_24dp);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        fab = findViewById(R.id.fab);
        fab_call = findViewById(R.id.fab_call);
        fab_mail = findViewById(R.id.fab_mail);
        fab_text = findViewById(R.id.fab_text);
        fab_whatsApp = findViewById(R.id.fab_whatsApp);
        fab_maps = findViewById(R.id.fab_maps);


        fab_open = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab_close);
        rclockwise = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_clockwise);
        ranticlockwise = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_anticlockwise);
        rforward= AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_forward);
        rbackward = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_backward);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isOpen){
                    fab.startAnimation(rbackward);
                    fab_call.startAnimation(fab_close);
                    fab_mail.startAnimation(fab_close);
                    fab_text.startAnimation(fab_close);
                    fab_whatsApp.startAnimation(fab_close);
                    fab_maps.startAnimation(fab_close);
                    isOpen=false;
                }
                else{
                    fab.startAnimation(rforward);
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
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        //Handle the message button
        fab_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

//        for slideView

        sliderView = findViewById(R.id.imageSlider2);
        final SliderAdapterExample adapter = new SliderAdapterExample(this);
        adapter.setCount(5);

        sliderView.setSliderAdapter(adapter);


        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();
        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
           @Override
           public void onIndicatorClicked(int position) {
               sliderView.setCurrentPagePosition(position);
           }
        });


//recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        recyclerView1 = findViewById(R.id.recyclerView2);
        list1 = new ArrayList<>();
        recyclerView3 = findViewById(R.id.recyclerView3);
        list3 = new ArrayList<>();
        recyclerView4=findViewById(R.id.recyclerView4);
        list4 = new ArrayList<>();
        recyclerView5=findViewById(R.id.recyclerView5);
        list5 = new ArrayList<>();
        addCategories();
        addSubCategories();
        addFeaturedProducts();
        addNewProducts();
        addTopDeals();

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


//    private void openWhatsApp(){
//          }
//
//    private void openMaps(){
//          }



    public void addCategories() {
        recyclerView.setLayoutManager( new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        for (int i = 0; i < img.length; i++) {
            Categories itemModel = new Categories();
            itemModel.setImg(img[i]);
            itemModel.setTitle(t1[i]);
            list.add(itemModel);
        }

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);
    }


    public void addSubCategories() {
        recyclerView1.setLayoutManager( new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        for (int i = 0; i < img2.length; i++) {
            Categories itemModel = new Categories();
            itemModel.setImg(img2[i]);
            itemModel.setTitle(t2[i]);
            list1.add(itemModel);
        }

        SubCategoryAdapter adapter = new SubCategoryAdapter(getApplicationContext(), list1);
        recyclerView1.setAdapter(adapter);
    }

    public void addFeaturedProducts() {

        recyclerView3.setLayoutManager( new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false)
        );

        for (int i = 0; i < img3.length; i++) {
            Products itemModel = new Products();
            itemModel.setImg(img3[i]);
            itemModel.setTitle(title3[i]);
            itemModel.setSubtitle(subtitle3[i]);
            itemModel.setPrice(price3[i]);
            itemModel.setInitialPrice(initialPrice3[i]);

            list3.add(itemModel);
        }

        FeaturedProductsAdapter adapter = new FeaturedProductsAdapter(getApplicationContext(), list3);
        recyclerView3.setAdapter(adapter);

    }

//     RecyclerView.LayoutManager manager = new GridLayoutManager(this, 1);
//        recyclerView3.setLayoutManager(manager);
//        recyclerView3.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL){
//        @Override
//        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//            // Do not draw the divider
//        }
//    });

    public void addNewProducts() {

        recyclerView4.setLayoutManager( new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        for (int i = 0; i < img4.length; i++) {
            Products itemModel = new Products();
            itemModel.setImg(img4[i]);
            itemModel.setTitle(title4[i]);
            itemModel.setSubtitle(subtitle4[i]);
            itemModel.setPrice(price4[i]);
            itemModel.setInitialPrice(initialPrice4[i]);

            list4.add(itemModel);
        }

        FeaturedProductsAdapter adapter = new FeaturedProductsAdapter(getApplicationContext(), list4);
        recyclerView4.setAdapter(adapter);
    }

    public void addTopDeals() {

        recyclerView5.setLayoutManager( new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false)
        );

        for (int i = 0; i < img5.length; i++) {
            Products itemModel = new Products();
            itemModel.setImg(img5[i]);
            itemModel.setTitle(title5[i]);
            itemModel.setSubtitle(subtitle5[i]);
            itemModel.setPrice(price5[i]);
            itemModel.setInitialPrice(initialPrice5[i]);

            list5.add(itemModel);
        }
        TopDealsAdapter adapter = new TopDealsAdapter(getApplicationContext(), list5);
        recyclerView5.setAdapter(adapter);

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
        if (id == R.id.main_shopping_cart) {
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








//Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

// fab.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
//                    @Override
//                    public void onMenuExpanded() {
//                        dimmedBackground.setVisibility(View.VISIBLE);
//                    }
//
//                    @Override
//                    public void onMenuCollapsed() {
//                        dimmedBackground.setVisibility(View.GONE);
//                    }
//                });
//                WindowManager wm = (WindowManager) MainActivity.this.getSystemService(Context.WINDOW_SERVICE);
//                WindowManager.LayoutParams p = (WindowManager.LayoutParams) view.getLayoutParams();
//                p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
//                p.dimAmount = 0.4f;
//                wm.updateViewLayout(view, p);

//    FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });








//    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

//        RecyclerView.LayoutManager mLayoutManager =
//                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(mLayoutManager);
////        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        CategoryAdapter mAdapter = new CategoryAdapter();
//        recyclerView.setAdapter(mAdapter);




















//    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
//
//        public class ViewHolder extends RecyclerView.ViewHolder {
//            TextView t1;
//            ImageView img;
//            public ViewHolder(@NonNull View itemView) {
//                super(itemView);
//                t1 = itemView.findViewById(R.id.title);
//                img = itemView.findViewById(R.id.categ_imageView);
//            }
//        }
//
//        @NonNull
//        @Override
//        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View v = getLayoutInflater().inflate(R.layout.category_item,parent,false);
//            return new ViewHolder(v);
//
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//            Categories data = list.get(position);
//            holder.t1.setText(data.getTitle());
//            holder.img.setImageDrawable(getDrawable(data.getImg()));
//        }
//
//        @Override
//        public int getItemCount() {
//            return list.size();
//        }
//
//
//    }
