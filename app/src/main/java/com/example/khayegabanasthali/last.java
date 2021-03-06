package com.example.khayegabanasthali;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Strings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class last extends AppCompatActivity {
FirebaseFirestore firestore;
FirebaseAuth firebaseAuth;
String uid,uid2;
TextView t1,t2,t3,t4,con;
    Date time;
    static int Count;
    DocumentReference dRef;
    DocumentReference documentReference;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        time=Calendar.getInstance().getTime();
        t1=findViewById(R.id.textView30);
        t2=findViewById(R.id.textView31);
        t3=findViewById(R.id.textView32);
        t4=findViewById(R.id.textView35);
        con=findViewById(R.id.textView33);
        b=findViewById(R.id.button10);

        firebaseAuth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();
        uid= Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid();
        uid2=uid+time;
      dRef=firestore.collection("users").document(uid);
        dRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot documentSnapshot=task.getResult();
                    last.Count= Math.toIntExact((documentSnapshot.getLong("COUNT")));
                    last.Count++;
                    t4.setText(Integer.toString(Count));

                    String or="ORDER"+Count;
                    DocumentReference dcol=firestore.collection("users").document(uid).collection("my order").document(or);
                    documentReference=firestore.collection("ORDERS").document(uid2);
                    Map<String,Object> map=new HashMap<>();
                    Map<String,Object> map1=new HashMap<>();
                    int i=1;
                    map.put("CANTEEN", cant.canteen);
                    map1.put("CANTEEN",cant.canteen);
                    map.put("NAME:", details.name);
                    map.put("NUMBER:", details.phone);
                    map.put("LOCATION:", details.dept);
                    map.put("EXACT LOCATION:", details.exa);
                    int j;
                    for (j=1;j<18;j++)
                    {
                        if(snacks.order[j]!=0){
                            String s="ITEM"+i++;
                            map.put(s,snacks.snack[j]+" X "+snacks.order[j]);
                            map1.put(s,snacks.snack[j]+" X "+snacks.order[j]);
                        }

                    }for (j=1;j<18;j++)
                    {
                        if(drink.order[j]!=0){
                            String s="ITEM"+i++;
                            map.put(s,drink.snack[j]+" X "+drink.order[j]);
                            map1.put(s,drink.snack[j]+" X "+drink.order[j]);
                        }
                    }
                    for (j=1;j<18;j++)
                    {
                        if(dess.order[j]!=0){
                            String s="ITEM"+i++;
                            map.put(s,dess.snack[j]+" X "+dess.order[j]);
                            map1.put(s,dess.snack[j]+" X "+dess.order[j]);
                        }
                    }
                    for (j=1;j<18;j++)
                    {
                        if(main_c.order[j]!=0){
                            String s="ITEM"+i++;
                            map.put(s,main_c.snack[j]+" X "+main_c.order[j]);
                            map1.put(s,main_c.snack[j]+" X "+main_c.order[j]);
                        }
                    }
                    map.put("TOTAL","Rs."+cart.tot);
                    map1.put("TOTAL","Rs."+cart.tot+"/-");
                    map1.put("ITEM",--i);
                    map.put("TIME",time);
                    map1.put("TIME",time.toString());
                    String s="Rs." + cart.tot +" to be paid to \n"+ cant.canteen;
                    t1.setText(s);
                    s="To be delivered at "+ details.dept +" , "+ details.exa;
                    t2.setText(s);
                    t3.setText(time.toString());
                    s=con.getText().toString();
                    s=s+"\n Email:"+ cant.em +"\n Phone Number:"+ cant.ph;
                    con.setText(s);
                    Log.d("yes","updated ho gaya bahar");
                    documentReference.set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
Log.d("yes","updated ho gaya");
                        }
                    });
                    dcol.set(map1);
                    Map<String,Object> m=new HashMap<>();
                    m.put("COUNT",Count);
                    dRef.update(m);

                }
            }
        });

b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
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
        startActivity(new Intent(last.this,cant.class));
        finish();
    }
});




    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(last.this,cant.class));
        finish();
    }
}
