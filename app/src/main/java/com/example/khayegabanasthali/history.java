package com.example.khayegabanasthali;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class history extends AppCompatActivity {
TableLayout tb;
FirebaseFirestore firestore;
FirebaseAuth firebaseAuth;
String uid;
static int count;
ProgressBar p;
    String canteen,time,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        tb=findViewById(R.id.tabh);
        p=findViewById(R.id.progressBar3);
        firebaseAuth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();
        uid= Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid();
        final DocumentReference documentReference=firestore.collection("users").document(uid);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot documentSnapshot=task.getResult();
                assert documentSnapshot != null;
                history.count= Math.toIntExact((documentSnapshot.getLong("COUNT")));
            }
        });
        p.setVisibility(View.VISIBLE);
         for(int i=count;i>0;i--)
        {
            Log.d("k0","kyu"+i);
            final String order="ORDER"+i;
            DocumentReference dref=firestore.collection("users").document(uid).collection("my order").document(order);


            dref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @SuppressLint("SetTextI18n")
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
               DocumentSnapshot dsnap=task.getResult();
                    canteen=dsnap.getString("CANTEEN");
               TableRow tr=new TableRow(history.this);
                    TextView t1=new TextView(history.this);
                    t1.setText(order+"\n"+canteen);
                    t1.setTextSize(20);
                    tr.addView(t1);
               price=dsnap.getString("TOTAL");
                    TextView t3=new TextView(history.this);
                    t3.setText("    "+price);
                    t3.setTextSize(20);
                    tr.addView(t3);
               tb.addView(tr);
               time=dsnap.getString("TIME");
               TableRow tr1=new TableRow(history.this);
                    TextView t2=new TextView(history.this);
                    t2.setText(time);
                    t2.setTextSize(15);
                    tr1.addView(t2);
               tb.addView(tr1);
               int item= Math.toIntExact(dsnap.getLong("ITEM"));
               for (int j=1;j<=item;j++){
                   String iname="ITEM"+j;
                   TableRow te=new TableRow(history.this);
                   TextView tv=new TextView(history.this);
                   tv.setText(dsnap.getString(iname));
                   tv.setTextSize(18);
                   te.addView(tv);
                   tb.addView(te);
               }
                    TableRow te=new TableRow(history.this);
                    TextView tv=new TextView(history.this);
                    tv.setText("_______________________________________");
                    te.addView(tv);
                    tb.addView(te);
                }
            });
            p.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public void onBackPressed() {

        finish();
    }
}
