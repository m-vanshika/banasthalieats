package com.example.khayegabanasthali;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class cart extends AppCompatActivity {
    Button proceed,edit;
    static TextView total;
    static int tot;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        proceed=findViewById(R.id.button5);
        edit=findViewById(R.id.button6);
        total=findViewById(R.id.textView21);
        TableLayout tb=findViewById(R.id.tab);
         tot=0;

            int i;
        for(i=1;i<18;i++)
        {
            if(snacks.order[i]!=0)
            {
                TableRow tableRow=new TableRow(this);
                TextView textView=new TextView(this);
                textView.setText(snacks.snack[i]+"     ");
                textView.setTextSize(25);
                TextView textView1=new TextView(this);
                textView1.setText(snacks.order[i]+"     ");
                textView1.setTextSize(20);
                TextView textView3=new TextView(this);
                textView3.setText(snacks.price[i]);
                textView3.setTextSize(20);
                tableRow.addView(textView);
                tableRow.addView(textView1);
                tableRow.addView(textView3);
                tb.addView(tableRow);
                String p="";
                String s=snacks.price[i];

                for(int j=0; j< s.length(); j++){
                    char ch=s.charAt(j);
                    for(char k='0';k<='9';k++){
                        if(ch==k)
                        {
                            p=p+ch;
                        }
                    }
                }
                tot=tot+snacks.order[i]*Integer.parseInt(p.trim());


            }

        }
        for(i=1;i<18;i++)
        {
            if(dess.order[i]!=0)
            {
                TableRow tableRow=new TableRow(this);
                TextView textView=new TextView(this);
                textView.setText(dess.snack[i]+"     ");
                textView.setTextSize(25);
                TextView textView1=new TextView(this);
                textView1.setText(dess.order[i]+"     ");
                textView1.setTextSize(20);
                TextView textView3=new TextView(this);
                textView3.setText(dess.price[i]);
                textView3.setTextSize(20);
                tableRow.addView(textView);
                tableRow.addView(textView1);
                tableRow.addView(textView3);
                tb.addView(tableRow);
                String p="";
                String s=dess.price[i];

                for(int j=0; j< s.length(); j++){
                    char ch=s.charAt(j);
                    for(char k='0';k<='9';k++){
                        if(ch==k)
                        {
                            p=p+ch;
                        }
                    }
                }
                tot=tot+dess.order[i]*Integer.parseInt(p.trim());


            }

        }
        for(i=1;i<18;i++)
        {
            if(drink.order[i]!=0)
            {
                TableRow tableRow=new TableRow(this);
                TextView textView=new TextView(this);
                textView.setText(drink.snack[i]+"     ");
                textView.setTextSize(25);
                TextView textView1=new TextView(this);
                textView1.setText(drink.order[i]+"     ");
                textView1.setTextSize(20);
                TextView textView3=new TextView(this);
                textView3.setText(drink.price[i]);
                textView3.setTextSize(20);
                tableRow.addView(textView);
                tableRow.addView(textView1);
                tableRow.addView(textView3);
                tb.addView(tableRow);
                String p="";
                String s=drink.price[i];

                for(int j=0; j< s.length(); j++){
                    char ch=s.charAt(j);
                    for(char k='0';k<='9';k++){
                        if(ch==k)
                        {
                            p=p+ch;
                        }
                    }
                }
                tot=tot+drink.order[i]*Integer.parseInt(p.trim());


            }

        }
        for(i=1;i<18;i++)
        {
            if(main_c.order[i]!=0)
            {
                TableRow tableRow=new TableRow(this);
                TextView textView=new TextView(this);
                textView.setText(main_c.snack[i]+"     ");
                textView.setTextSize(25);
                TextView textView1=new TextView(this);
                textView1.setText(main_c.order[i]+"     ");
                textView1.setTextSize(20);
                TextView textView3=new TextView(this);
                textView3.setText(main_c.price[i]);
                textView3.setTextSize(20);
                tableRow.addView(textView);
                tableRow.addView(textView1);
                tableRow.addView(textView3);
                tb.addView(tableRow);
                String p="";
                String s=main_c.price[i];

                for(int j=0; j< s.length(); j++){
                    char ch=s.charAt(j);
                    for(char k='0';k<='9';k++){
                        if(ch==k)
                        {
                            p=p+ch;
                        }
                    }
                }
                tot=tot+main_c.order[i]*Integer.parseInt(p.trim());


            }

        }


        String y="Rs. "+tot+" /-";
        total.setText(y);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab=new AlertDialog.Builder(v.getContext());
                ab.setTitle("EDIT YOUR CHOICE");
                ab.setMessage("Your choice will be lost once you click YES");
                ab.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(cart.this,mukki.class));
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
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cart.this,details.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(cart.this,mukki.class));
        finish();
    }
}
