package com.example.khayegabanasthali;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class profile extends AppCompatActivity {
TextView name,email,phone,about,address,course,branch;
Button back,logout;
ImageButton edit;
FirebaseAuth fAuth;
FirebaseFirestore fStore;
String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=(TextView)findViewById(R.id.textView9);
        email=(TextView)findViewById(R.id.editText6);
        phone=(TextView)findViewById(R.id.editText4);
        address=(TextView)findViewById(R.id.editText5);
        course =(TextView)findViewById(R.id.textView16);
        branch=(TextView)findViewById(R.id.textView18);
        back=(Button)findViewById(R.id.button3);
        logout=(Button)findViewById(R.id.button4);
        about=(TextView)findViewById(R.id.editText3);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        uid=fAuth.getCurrentUser().getUid();
        edit=findViewById(R.id.imageButton5);
        final DocumentReference documentReference=fStore.collection("users").document(uid);
        //lets see
       documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
           @Override
           public void onComplete(@NonNull Task<DocumentSnapshot> task) {
          if(task.isSuccessful()){
              DocumentSnapshot documentSnapshot=task.getResult();
              assert documentSnapshot != null;
              name.setText(documentSnapshot.getString("NAME"));
              email.setText(documentSnapshot.getString("EMAIL"));
              phone.setText(documentSnapshot.getString("PHONE NUMBER"));
              address.setText(documentSnapshot.getString("ADDRESS"));
              branch.setText(documentSnapshot.getString("BRANCH"));
              course.setText(documentSnapshot.getString("COURSE"));
             about.setText(documentSnapshot.getString("ABOUT"));
          }
          else
          {
              Toast.makeText(profile.this,task.getException().getMessage(),Toast.LENGTH_LONG);
          }
           }
       });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(profile.this,cant.class);
                startActivity(intent);
                finish();
            }

        });
logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();

    }
});
edit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       startActivity(new Intent(profile.this, com.example.khayegabanasthali.edit.class));
finish();

    }
});

    }

    @Override
    public void onBackPressed() {

        finish();
    }
}
