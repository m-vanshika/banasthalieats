package com.example.khayegabanasthali;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class sinup extends AppCompatActivity {
    EditText email, password,name,number,hostel,room;
    Button sign;
    TextView t;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    FirebaseFirestore firestore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinup);
        name=(EditText)findViewById(R.id.n);
        number=(EditText)findViewById(R.id.pn);
        hostel=(EditText)findViewById(R.id.h);
        room=(EditText)findViewById(R.id.r);
        email = (EditText) findViewById(R.id.e);
        password = (EditText) findViewById(R.id.p);
        sign = (Button) findViewById(R.id.button2);
        t = (TextView) findViewById(R.id.textView8);
       progressBar=(ProgressBar)findViewById(R.id.progressBar);
       firebaseAuth = FirebaseAuth.getInstance();
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String e,p,n,pn,h,r;
                e=email.getText().toString().trim();
                p=password.getText().toString().trim();
                n=name.getText().toString().trim();
                pn=number.getText().toString().trim();
                h=hostel.getText().toString().trim();
                r=room.getText().toString().trim();
                if (TextUtils.isEmpty(n)){
                    name.setError("NAME IS REQUIRED");
                    return;
                }
                if (TextUtils.isEmpty(pn)){
                    number.setError("PHONE NUMBER IS REQUIRED");
                    return;
                }
                if (TextUtils.isEmpty(h)){
                    hostel.setError("HOSTEL NAME IS REQUIRED");
                    return;
                }
                if (TextUtils.isEmpty(r)){
                    room.setError("ROOM NUMBER IS REQUIRED");
                    return;
                }
                if(TextUtils.isEmpty(e)) {
                email.setError("E-MAIL IS REQUIRED");
                return;

                }
                if(TextUtils.isEmpty(p)) {
                    password.setError("PASSWORD IS REQUIRED");
return;
                }
                 if(p.length()<6)
                {
                    password.setError("MUST BE GREATER THAN 6");
                    return;
                }
                 if (pn.length()!=10)
                 {
                     number.setError("Enter a valid number");
                     return;
                 }
                progressBar.setVisibility(View.VISIBLE);
                 firestore=FirebaseFirestore.getInstance();
                firebaseAuth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            FirebaseUser fuser=firebaseAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(sinup.this,"VERIFICATION LINK SENT.VERIFY YOUR EMAIL",Toast.LENGTH_LONG).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(sinup.this,"Email not sent "+e.getMessage(),Toast.LENGTH_LONG).show();

                                }
                            });





                            Toast.makeText(sinup.this,"NOW LOGIN",Toast.LENGTH_SHORT).show();
                            userId=firebaseAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=firestore.collection("users").document(userId);
                            Map<String,Object> user=new HashMap<>();
                            user.put("NAME",n);
                            user.put("EMAIL",e);
                            user.put("PHONE NUMBER",pn);
                            user.put("ADDRESS",(h+" room no. "+r));
                            user.put("COURSE","");
                            user.put("BRANCH","");
                            user.put("ABOUT","");
                            user.put("COUNT",0);

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                }
                            });

                            startActivity(new Intent(getApplicationContext(),login.class));
                            finish();


                        }
                        else{
                              Toast.makeText(sinup.this,"ERROR:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });





            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sinup.this,login.class));
            }
        });
    }

}
