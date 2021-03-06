package com.example.khayegabanasthali;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.gson.internal.$Gson$Preconditions;

public class login extends AppCompatActivity {
    EditText email,password;
    TextView t,forg;
    Button b;
    ProgressBar progressBar;
FirebaseAuth firebaseAuth;
FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forg=(TextView)findViewById(R.id.textView12);
        email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        t=(TextView)findViewById(R.id.textView3);
        b=(Button)findViewById(R.id.button);
        progressBar=findViewById(R.id.progressBar2);
        firebaseAuth=FirebaseAuth.getInstance();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String e,p;
                e=email.getText().toString().trim();
                p=password.getText().toString().trim();
                if (TextUtils.isEmpty(e)&&TextUtils.isEmpty(p)){
                    password.setError("PASSWORD IS REQUIRED");
                    email.setError("E-MAIL IS REQUIRED");
                    Toast.makeText(login.this,"FIELDS ARE REQUIRED",Toast.LENGTH_LONG).show();
                    return;
                }
                else  if(TextUtils.isEmpty(e)) {
                    email.setError("E-MAIL IS REQUIRED");
                    return;

                }
                else if(TextUtils.isEmpty(p)) {
                    password.setError("PASSWORD IS REQUIRED");
                    return;
                }
                else if(p.length()<6)
                {
                    password.setError("MUST BE GREATER THAN 6");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(login.this,"WELCOME TO BANASTHALI EATS",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this,cant.class));
                           finish();


                        }
                        else{
                            Toast.makeText(login.this,"ERROR:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,sinup.class));
            }
        });
        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail=new EditText(v.getContext());
                AlertDialog.Builder passres=new AlertDialog.Builder(v.getContext());
                passres.setTitle("Reset Password?");
                passres.setMessage("Enter your E-mail to reset password.");
                passres.setView(resetMail);
                passres.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail=resetMail.getText().toString();
                        firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(login.this,"Reset link sent to your E-mail",Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(login.this,"Error! Reset Link not sent "+e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                passres.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                passres.create().show();
            }
        });

    }
}
