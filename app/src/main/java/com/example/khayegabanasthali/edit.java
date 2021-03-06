package com.example.khayegabanasthali;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class edit extends AppCompatActivity {
EditText n,a,h,r,p,c,b;
Button sa,di;
ImageButton edit;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        n=(EditText)findViewById(R.id.n);
        h=(EditText)findViewById(R.id.h);
        a=(EditText)findViewById(R.id.a);
        r=(EditText)findViewById(R.id.r);
        c=(EditText)findViewById(R.id.c);
        b=(EditText)findViewById(R.id.b);
        p=(EditText)findViewById(R.id.p);
        sa=(Button)findViewById(R.id.button7);
        di=findViewById(R.id.button8);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        uid=fAuth.getCurrentUser().getUid();
        final DocumentReference documentReference=fStore.collection("users").document(uid);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot=task.getResult();
                    assert documentSnapshot != null;
                    n.setText(documentSnapshot.getString("NAME"));
                    p.setText(documentSnapshot.getString("PHONE NUMBER"));
                    b.setText(documentSnapshot.getString("BRANCH"));
                    c.setText(documentSnapshot.getString("COURSE"));
                    a.setText(documentSnapshot.getString("ABOUT"));
                    String add=(documentSnapshot.getString("ADDRESS"));
                    h.setText(add.substring(0,add.indexOf(' ')));
                    r.setText(add.substring(add.lastIndexOf(' ')+1));

                }
                else
                {
                    Toast.makeText(edit.this,task.getException().getMessage(),Toast.LENGTH_LONG);
                }
            }
        });

        di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab=new AlertDialog.Builder(edit.this);
                ab.setTitle("Do you want to go back without saving?");
                ab.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                   startActivity(new Intent(edit.this,profile.class));
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
        });
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=n.getText().toString();
                String about,hostel,number,room,branch,course;
                about=a.getText().toString();
                hostel=h.getText().toString();
                number=p.getText().toString();
                room=r.getText().toString();
                branch=b.getText().toString();
                course=c.getText().toString();
                edit=findViewById(R.id.imageButton5);

                final DocumentReference docRef=FirebaseFirestore.getInstance().collection("users").document(uid);
                Map<String,Object> user=new HashMap<>();
                user.put("NAME",name);
                user.put("PHONE NUMBER",number);
                user.put("ADDRESS",(hostel+" room no. "+room));
                user.put("COURSE",course);
                user.put("BRANCH",branch);
                user.put("ABOUT",about);
                docRef.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(edit.this,"Successfully updated",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(edit.this,profile.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(edit.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        startActivity(new Intent(edit.this,profile.class));
                        finish();
                    }
                });

            }
        });
    }

    @Override
    public void onBackPressed() {
       startActivity(new Intent(edit.this,profile.class));
       finish();
    }
}
