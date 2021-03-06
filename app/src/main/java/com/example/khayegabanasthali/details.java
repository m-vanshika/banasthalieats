package com.example.khayegabanasthali;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class details extends AppCompatActivity {
    EditText n,p,d,e;
    TextView t;
    ProgressBar progressBar;
    Button button;
    CheckBox cb;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
   static String uid,name,phone,dept,exa;
   String verifyId;
    PhoneAuthProvider.ForceResendingToken token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        n=findViewById(R.id.editText7);
        d=findViewById(R.id.editText9);
        e=findViewById(R.id.editText10);
        p=findViewById(R.id.editText11);
        button=findViewById(R.id.button9);
        cb=findViewById(R.id.checkBox);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        uid=fAuth.getCurrentUser().getUid();
        button.setText("PLACE ORDER");
        final DocumentReference documentReference=fStore.collection("users").document(uid);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot documentSnapshot=task.getResult();
                    n.setText(documentSnapshot.getString("NAME"));
                    p.setText(documentSnapshot.getString("PHONE NUMBER"));
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb.isChecked()){
                    if(n.getText().toString().equalsIgnoreCase("")){

                        n.setError("Required");
                    }
                    else {
                        name=n.getText().toString();
                        if(p.getText().toString().equals("")){
                            p.setError("Required");
                        }
                        else {
                            if (p.getText().toString().length() != 10) {
                                p.setError("Enter a valid number");
                            } else {
                                phone = p.getText().toString();
                                if (d.getText().toString().equals("")) {
                                    d.setError("Required");
                                } else {
                                    exa = e.getText().toString();
                                    dept = d.getText().toString();
                                    startActivity(new Intent(details.this, last.class));
                                    finish();
                                }
                            }
                        }

                    }

                }else {
                    cb.setError("Required");

                }
            }
        });

    }



    @Override
    public void onBackPressed() {

        AlertDialog.Builder ab=new AlertDialog.Builder(details.this);
        ab.setTitle("Are you sure?");
        ab.setMessage("Clicking yes may lead to loss of data");

        ab.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(details.this, mukki.class));

                finish();
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ab.create().show();
    }
}
