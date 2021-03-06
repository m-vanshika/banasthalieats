package com.example.khayegabanasthali;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class drink extends Fragment {
    private TextView q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17;
    private Button p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17;
  static int[] order =new int[18];
  static String[] snack =new String[18];
  static String[] price =new String[18];


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.drink, container, false);
        q12 = (TextView) v.findViewById(R.id.q12);
        p12 = (Button) v.findViewById(R.id.p12);
        m12 = (Button) v.findViewById(R.id.m12);
        s12=(TextView)v.findViewById(R.id.s12);
        r12=(TextView)v.findViewById(R.id.r12);
        p12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = q12.getText().toString().trim();
                String s = add(string);
                q12.setText(s);
                order[12]=Integer.parseInt(s);
                snack[12]=s12.getText().toString();
                price[12]=r12.getText().toString();



            }
        });
        m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = q12.getText().toString().trim();
                String s = sub(string);
                q12.setText(s);
                order[12]=Integer.parseInt(s);
                snack[12]=s12.getText().toString();
                price[12]=r12.getText().toString();

            }
        });
        q1=(TextView)v.findViewById(R.id.q1);
        p1=(Button)v.findViewById(R.id.p1);
        m1=(Button)v.findViewById(R.id.m1);
        s1=(TextView)v.findViewById(R.id.s1);
        r1=(TextView)v.findViewById(R.id.r1);

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q1.getText().toString().trim();
                String s=add(string);
                q1.setText(s);
                order[1]=Integer.parseInt(s);
                snack[1]=s1.getText().toString();
                price[1]=r1.getText().toString();
            }
        });
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q1.getText().toString().trim();
                String s=sub(string);
                q1.setText(s);
                order[1]=Integer.parseInt(s);
                snack[1]=s1.getText().toString();
                price[1]=r1.getText().toString();

            }
        }); q2=(TextView)v.findViewById(R.id.q2);
        p2=(Button)v.findViewById(R.id.p2);
        s2=(TextView)v.findViewById(R.id.s2);
        r2=(TextView)v.findViewById(R.id.r2);
        m2=(Button)v.findViewById(R.id.m2);
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q2.getText().toString().trim();
                String s=add(string);
                q2.setText(s);
                order[2]=Integer.parseInt(s);
                snack[2]=s2.getText().toString();
                price[2]=r2.getText().toString();

            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q2.getText().toString().trim();
                String s=sub(string);
                q2.setText(s);
                order[2]=Integer.parseInt(s);
                snack[2]=s2.getText().toString();
                price[2]=r2.getText().toString();
            }
        }); q3=(TextView)v.findViewById(R.id.q3);
        p3=(Button)v.findViewById(R.id.p3);
        m3=(Button)v.findViewById(R.id.m3);
        s3=(TextView)v.findViewById(R.id.s3);
        r3=(TextView)v.findViewById(R.id.r3);
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q3.getText().toString().trim();
                String s=add(string);
                q3.setText(s);
                order[3]=Integer.parseInt(s);
                snack[3]=s3.getText().toString();
                price[3]=r3.getText().toString();
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q3.getText().toString().trim();
                String s=sub(string);
                q3.setText(s);
                order[3]=Integer.parseInt(s);
                snack[3]=s3.getText().toString();
                price[3]=r3.getText().toString();
            }
        }); q4=(TextView)v.findViewById(R.id.q4);
        p4=(Button)v.findViewById(R.id.p4);
        m4=(Button)v.findViewById(R.id.m4);
        s4=(TextView)v.findViewById(R.id.s4);
        r4=(TextView)v.findViewById(R.id.r4);
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q4.getText().toString().trim();
                String s=add(string);
                q4.setText(s);
                order[4]=Integer.parseInt(s);
                snack[4]=s4.getText().toString();
                price[4]=r4.getText().toString();
            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q4.getText().toString().trim();
                String s=sub(string);
                q4.setText(s);
                order[4]=Integer.parseInt(s);
                snack[4]=s4.getText().toString();
                price[4]=r4.getText().toString();
            }
        }); q5=(TextView)v.findViewById(R.id.q5);
        p5=(Button)v.findViewById(R.id.p5);
        m5=(Button)v.findViewById(R.id.m5);
        s5=(TextView)v.findViewById(R.id.s5);
        r5=(TextView)v.findViewById(R.id.r5);
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q5.getText().toString().trim();
                String s=add(string);
                q5.setText(s);
                order[5]=Integer.parseInt(s);
                snack[5]=s5.getText().toString();
                price[5]=r5.getText().toString();
            }
        });
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q5.getText().toString().trim();
                String s=sub(string);
                q5.setText(s);
                order[5]=Integer.parseInt(s);
                snack[5]=s5.getText().toString();
                price[5]=r5.getText().toString();
            }
        });
        q6=(TextView)v.findViewById(R.id.q6);
        p6=(Button)v.findViewById(R.id.p6);
        s6=(TextView)v.findViewById(R.id.s6);
        r6=(TextView)v.findViewById(R.id.r6);
        m6=(Button)v.findViewById(R.id.m6);
        p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q6.getText().toString().trim();
                String s=add(string);
                q6.setText(s);
                order[6]=Integer.parseInt(s);
                snack[6]=s6.getText().toString();
                price[6]=r6.getText().toString();
            }
        });
        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q6.getText().toString().trim();
                String s=sub(string);
                q6.setText(s);
                order[6]=Integer.parseInt(s);
                snack[6]=s6.getText().toString();
                price[6]=r6.getText().toString();
            }
        }); q7=(TextView)v.findViewById(R.id.q7);
        p7=(Button)v.findViewById(R.id.p7);
        m7=(Button)v.findViewById(R.id.m7);
        s7=(TextView)v.findViewById(R.id.s7);
        r7=(TextView)v.findViewById(R.id.r7);
        p7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q7.getText().toString().trim();
                String s=add(string);
                q7.setText(s);
                order[7]=Integer.parseInt(s);
                snack[7]=s7.getText().toString();
                price[7]=r7.getText().toString();
            }
        });
        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q7.getText().toString().trim();
                String s=sub(string);
                q7.setText(s);
                order[7]=Integer.parseInt(s);
                snack[7]=s7.getText().toString();
                price[7]=r7.getText().toString();
            }
        }); q8=(TextView)v.findViewById(R.id.q8);
        p8=(Button)v.findViewById(R.id.p8);
        m8=(Button)v.findViewById(R.id.m8);
        s8=(TextView)v.findViewById(R.id.s8);
        r8=(TextView)v.findViewById(R.id.r8);
        p8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q8.getText().toString().trim();
                String s=add(string);
                q8.setText(s);
                order[8]=Integer.parseInt(s);
                snack[8]=s8.getText().toString();
                price[8]=r8.getText().toString();
            }
        });
        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q8.getText().toString().trim();
                String s=sub(string);
                q8.setText(s);
                order[8]=Integer.parseInt(s);
                snack[8]=s8.getText().toString();
                price[8]=r8.getText().toString();
            }
        });
        q9=(TextView)v.findViewById(R.id.q9);
        p9=(Button)v.findViewById(R.id.p9);
        m9=(Button)v.findViewById(R.id.m9);
        s9=(TextView)v.findViewById(R.id.s9);
        r9=(TextView)v.findViewById(R.id.r9);
        p9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q9.getText().toString().trim();
                String s=add(string);
                q9.setText(s);
                order[9]=Integer.parseInt(s);
                snack[9]=s9.getText().toString();
                price[9]=r9.getText().toString();
            }
        });
        m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q9.getText().toString().trim();
                String s=sub(string);
                q9.setText(s);
                order[9]=Integer.parseInt(s);
                snack[9]=s9.getText().toString();
                price[9]=r9.getText().toString();
            }
        });
        q10=(TextView)v.findViewById(R.id.q10);
        p10=(Button)v.findViewById(R.id.p10);
        m10=(Button)v.findViewById(R.id.m10);
        s10=(TextView)v.findViewById(R.id.s10);
        r10=(TextView)v.findViewById(R.id.r10);
        p10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q10.getText().toString().trim();
                String s=add(string);
                q10.setText(s);
                order[10]=Integer.parseInt(s);
                snack[10]=s10.getText().toString();
                price[10]=r10.getText().toString();
            }
        });
        m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q10.getText().toString().trim();
                String s=sub(string);
                q10.setText(s);
                order[10]=Integer.parseInt(s);
                snack[10]=s10.getText().toString();
                price[10]=r10.getText().toString();
            }
        });
        q11=(TextView)v.findViewById(R.id.q11);
        p11=(Button)v.findViewById(R.id.p11);
        m11=(Button)v.findViewById(R.id.m11);
        s11=(TextView)v.findViewById(R.id.s11);
        r11=(TextView)v.findViewById(R.id.r11);
        p11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q11.getText().toString().trim();
                String s=add(string);
                q11.setText(s);
                order[11]=Integer.parseInt(s);
                snack[11]=s11.getText().toString();
                price[11]=r11.getText().toString();
            }
        });
        m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q11.getText().toString().trim();
                String s=sub(string);
                q11.setText(s);
                order[11]=Integer.parseInt(s);
                snack[11]=s11.getText().toString();
                price[11]=r11.getText().toString();
            }
        });
        q13=(TextView)v.findViewById(R.id.q13);
        p13=(Button)v.findViewById(R.id.p13);
        m13=(Button)v.findViewById(R.id.m13);
        s13=(TextView)v.findViewById(R.id.s13);
        r13=(TextView)v.findViewById(R.id.r13);
        p13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q13.getText().toString().trim();
                String s=add(string);
                q13.setText(s);
                order[13]=Integer.parseInt(s);
                snack[13]=s13.getText().toString();
                price[13]=r13.getText().toString();
            }
        });
        m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q13.getText().toString().trim();
                String s=sub(string);
                q13.setText(s);
                order[13]=Integer.parseInt(s);
                snack[13]=s13.getText().toString();
                price[13]=r13.getText().toString();
            }
        });
        q14=(TextView)v.findViewById(R.id.q14);
        p14=(Button)v.findViewById(R.id.p14);
        m14=(Button)v.findViewById(R.id.m14);
        s14=(TextView)v.findViewById(R.id.s14);
        r14=(TextView)v.findViewById(R.id.r14);
        p14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q14.getText().toString().trim();
                String s=add(string);
                q14.setText(s);
                order[14]=Integer.parseInt(s);
                snack[14]=s14.getText().toString();
                price[14]=r14.getText().toString();
            }
        });
        m14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q14.getText().toString().trim();
                String s=sub(string);
                q14.setText(s);
                order[14]=Integer.parseInt(s);
                snack[14]=s14.getText().toString();
                price[14]=r14.getText().toString();
            }
        });
        q15=(TextView)v.findViewById(R.id.q15);
        p15=(Button)v.findViewById(R.id.p15);
        m15=(Button)v.findViewById(R.id.m15);
        s15=(TextView)v.findViewById(R.id.s15);
        r15=(TextView)v.findViewById(R.id.r15);
        p15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q15.getText().toString().trim();
                String s=add(string);
                q15.setText(s);
                order[14]=Integer.parseInt(s);
                snack[14]=s14.getText().toString();
                price[14]=r14.getText().toString();
            }
        });
        m15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q15.getText().toString().trim();
                String s=sub(string);
                q15.setText(s);
                order[15]=Integer.parseInt(s);
                snack[15]=s15.getText().toString();
                price[15]=r15.getText().toString();
            }
        });
        q16=(TextView)v.findViewById(R.id.q16);
        p16=(Button)v.findViewById(R.id.p16);
        m16=(Button)v.findViewById(R.id.m16);
        s16=(TextView)v.findViewById(R.id.s16);
        r16=(TextView)v.findViewById(R.id.r16);
        p16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q16.getText().toString().trim();
                String s=add(string);
                q16.setText(s);
                order[16]=Integer.parseInt(s);
                snack[16]=s16.getText().toString();
                price[16]=r16.getText().toString();
            }
        });
        m16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q16.getText().toString().trim();
                String s=sub(string);
                q16.setText(s);
                order[16]=Integer.parseInt(s);
                snack[16]=s16.getText().toString();
                price[16]=r16.getText().toString();
            }
        });
        q17=(TextView)v.findViewById(R.id.q17);
        p17=(Button)v.findViewById(R.id.p17);
        m17=(Button)v.findViewById(R.id.m17);
        s17=(TextView)v.findViewById(R.id.s17);
        r17=(TextView)v.findViewById(R.id.r17);
        p17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q17.getText().toString().trim();
                String s=add(string);
                q17.setText(s);
                order[17]=Integer.parseInt(s);
                snack[17]=s17.getText().toString();
                price[17]=r17.getText().toString();
            }
        });
        m17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=  q17.getText().toString().trim();
                String s=sub(string);
                q17.setText(s);
                order[17]=Integer.parseInt(s);
                snack[17]=s17.getText().toString();
                price[17]=r17.getText().toString();
            }
        });
        q1.setText(Integer.toString(order[1]));
        q2.setText(Integer.toString(order[2]));
        q3.setText(Integer.toString(order[3]));
        q4.setText(Integer.toString(order[4]));
        q5.setText(Integer.toString(order[5]));
        q6.setText(Integer.toString(order[6]));
        q7.setText(Integer.toString(order[7]));
        q8.setText(Integer.toString(order[8]));
        q9.setText(Integer.toString(order[9]));
        q10.setText(Integer.toString(order[10]));
        q11.setText(Integer.toString(order[11]));
        q12.setText(Integer.toString(order[12]));
        q13.setText(Integer.toString(order[13]));
        q14.setText(Integer.toString(order[14]));
        q15.setText(Integer.toString(order[15]));
        q16.setText(Integer.toString(order[16]));
        q17.setText(Integer.toString(order[17]));

        return v;
    }  private String add(String s) {
        int t = Integer.parseInt(s);
        t = t + 1;
        return Integer.toString(t);
    }

    @SuppressLint("Range")
    public String sub(String s) {
        int t = Integer.parseInt(s);
        if (t == 0) {
            Toast toast = Toast.makeText(getActivity(), "MINIMUM LIMIT REACHED", Toast.LENGTH_SHORT);
            View view = toast.getView();
            toast.show();
            return "0";
        } else {
            t = t - 1;
            return Integer.toString(t);
        }

    }
}

