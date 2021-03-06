package com.example.khayegabanasthali;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class mukki extends AppCompatActivity {

    FloatingActionButton fb;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String a,b;int c;
    String[] food=new String[18];
    String[]price=new String[18];
    int[] order=new int[18];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mukku);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("SNACKS"));
        tabLayout.addTab(tabLayout.newTab().setText("MAIN COURSE"));
        tabLayout.addTab(tabLayout.newTab().setText("DESSERT"));
        tabLayout.addTab(tabLayout.newTab().setText("DRINKS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.pager);
        final PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        fb = (FloatingActionButton) findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth=FirebaseAuth.getInstance();
                fstore= FirebaseFirestore.getInstance();
                final FirebaseUser fuser =fAuth.getCurrentUser();

                if(!fuser.isEmailVerified()) {
                    AlertDialog.Builder err=new AlertDialog.Builder(mukki.this);
                    err.setTitle("E-MAIL NOT VERIFIED");
                    err.setMessage("To continue ,Please verify your email");
                    err.setPositiveButton("Send Verification Link", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                       fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void aVoid) {
                               Toast.makeText(mukki.this, "VERIFICATION LINK SENT.VERIFY YOUR EMAIL", Toast.LENGTH_LONG).show();

                           }
                       }) ;
                        }
                    });
                    err.create().show();
                }
                else {
                    AlertDialog.Builder ab = new AlertDialog.Builder(mukki.this);
                    ab.setTitle("PROCEED TO PAY");
                    ab.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(mukki.this, cart.class));
                            finish();
                        }
                    });
                    ab.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ab.create().show();
                }
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        fAuth=FirebaseAuth.getInstance();
        fstore= FirebaseFirestore.getInstance();
        final FirebaseUser fuser =fAuth.getCurrentUser();
        if(fuser.isEmailVerified()){
            findViewById(R.id.textinput_error).setVisibility(View.INVISIBLE);
        }
        final String uid= Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
        if(!fuser.isEmailVerified()){
            findViewById(R.id.textinput_error).setVisibility(View.VISIBLE);
        }
        switch (item.getItemId()) {
            case R.id.profile:
                Intent i=new Intent(mukki.this,profile.class);
                startActivity(i);
                finish();


                return true;
            case R.id.logout:
                AlertDialog.Builder l=new AlertDialog.Builder(mukki.this);
                l.setTitle("Logout!");
                l.setMessage("Are you sure?");
                l.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(getApplicationContext(),login.class));

                    }
                });
                l.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //exits
                    }
                });
                l.create().show();
                return true;
            case  R.id.textinput_error:
                AlertDialog.Builder err=new AlertDialog.Builder(mukki.this);
                if(!fuser.isEmailVerified()) {
                    err.setTitle("E-MAIL NOT VERIFIED");
                    err.setMessage("Do you want to resend code?");
                    err.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(mukki.this,"VERIFICATION LINK SENT.VERIFY YOUR EMAIL",Toast.LENGTH_LONG).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(mukki.this,"Email not sent "+e.getMessage(),Toast.LENGTH_LONG).show();

                                }
                            });
                        }
                    });
                    err.setNegativeButton("No,Later maybe", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //close dialog
                        }
                    });
                    err.create().show();
                }
                else
                {
                    Toast.makeText(mukki.this,"You are up to date",Toast.LENGTH_LONG).show();
                }

                return true;
            case R.id.history:
                startActivity(new Intent(mukki.this,history.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        for(int j=0;j<18;j++)
        {
            snacks.order[j]=0;
        } for(int j=0;j<18;j++)
        {
            dess.order[j]=0;
        } for(int j=0;j<18;j++)
        {
            drink.order[j]=0;
        } for(int j=0;j<18;j++)
        {
            main_c.order[j]=0;
        }
        startActivity(new Intent(mukki.this,cant.class));
        finish();
    }
}
