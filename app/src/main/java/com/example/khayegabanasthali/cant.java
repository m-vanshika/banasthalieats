package com.example.khayegabanasthali;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

public class cant extends AppCompatActivity {
ImageButton m,f,s,sh;
FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    private  long backPressedTime;
static String canteen,em,ph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cant);
        m=(ImageButton)findViewById(R.id.imageButton2);
        f=(ImageButton)findViewById(R.id.imageButton);
        sh=(ImageButton)findViewById(R.id.imageButton3);
        s=(ImageButton)findViewById(R.id.imageButton4);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canteen="MUKTESHWARI CANTEEN";
                em="Mukku_ka_email@gmail.com";
                ph="#######786";
            mukku();
            finish();
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canteen="FUN & FROLIC";
                em="GollGappeKhao@gmail.com";
                ph="#######878";
                mukku();
                finish();
            }
        });s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canteen="SPICY BITES";
                em="GoodFoodGoodMood@gmail.com";
                ph="#######787";
                mukku();
                finish();
            }
        });sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canteen="SHANU'S CANTEEN";
                em="SabseMehnga@gmail.com";
                ph="########420";
                mukku();
                finish();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onComposeAction(MenuItem mi) {
        // handle click here
    }
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle presses on the action bar items

        fAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
       final FirebaseUser fuser =fAuth.getCurrentUser();
        if(fuser.isEmailVerified()){
            findViewById(R.id.textinput_error).setVisibility(View.INVISIBLE);
        }
        switch (item.getItemId()) {
            case R.id.profile:

                Intent i=new Intent(cant.this,profile.class);
                startActivity(i);


                return true;
            case R.id.logout:

                AlertDialog.Builder l=new AlertDialog.Builder(cant.this);
                l.setTitle("Logout!");
                l.setMessage("Are you sure?");
                l.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(getApplicationContext(),login.class));
                        finish();

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
            case R.id.textinput_error:
                AlertDialog.Builder err=new AlertDialog.Builder(cant.this);
                if(!fuser.isEmailVerified()) {
                    err.setTitle("E-MAIL NOT VERIFIED");
                    err.setMessage("Do you want to resend code?");
                    err.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(cant.this,"VERIFICATION LINK SENT.VERIFY YOUR EMAIL",Toast.LENGTH_LONG).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(cant.this,"Email not sent "+e.getMessage(),Toast.LENGTH_LONG).show();

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
                    Toast.makeText(cant.this,"You are up to date",Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.history:
                startActivity(new Intent(cant.this,history.class));
                //finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime+2000>System.currentTimeMillis()){
        super.onBackPressed();
        System.exit(1);
        return;
        }else {
            Toast.makeText(cant.this,"Press again to EXIT",Toast.LENGTH_LONG).show();
        }
backPressedTime=System.currentTimeMillis();
    }

    public void mukku(){
       Intent i = new Intent(this , mukki.class);
       startActivity(i);}

}
