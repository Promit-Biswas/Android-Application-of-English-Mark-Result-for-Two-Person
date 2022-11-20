package com.promit.result;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button a;
    Button b;
    Button c;
    Button d;
    Button f;
    Button g;
    Button h;
    Calendar calendar;
    SimpleDateFormat dateFormat;
    String date;
    TextView aa;
    TextView bb;
    TextView cc;
    TextView dd;
    TextView ee;
    TextView ff;
    int rgt = 0, rgt1 = 0;
    int wng = 0, wng1 = 0;

    long backPressedTime;
    Toast backToast;
    private DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Proma's Counting");
        setContentView(R.layout.activity_main);
        a = (Button) findViewById(R.id.button1);
        b = (Button) findViewById(R.id.button2);
        c = (Button) findViewById(R.id.btnright);
        d = (Button) findViewById(R.id.btnwrong);
        f = (Button) findViewById(R.id.btnshow);
        g = (Button) findViewById(R.id.button4);
        h = (Button) findViewById(R.id.button5);


        aa = (TextView) findViewById(R.id.textView);
        bb = (TextView) findViewById(R.id.textView2);
        cc = (TextView) findViewById(R.id.right1);
        dd = (TextView) findViewById(R.id.wrong1);
        ee = (TextView) findViewById(R.id.total1);
        ff = (TextView) findViewById(R.id.total2);
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy h:mm a");
        date = dateFormat.format(calendar.getTime());


        AlertDialog.Builder mb = new AlertDialog.Builder(MainActivity.this);
        //View view = getLayoutInflater().inflate(R.layout.alert, null);
        mb.setMessage("How many Question?");
        mb.setCancelable(false);
        mb.setPositiveButton("30", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rgt = rgt + 1;
                        aa.setText("Right: " + String.valueOf(rgt));
                        int as = rgt + wng;
                        ee.setText("Total: " + String.valueOf(as));
                        if (as == 30) {
                            a.setEnabled(false);
                            b.setEnabled(false);
                            int as1=rgt1+wng1;
                            if(as1==30)
                            {

                                String rgt11 = String.valueOf(rgt);
                                String wng11 = String.valueOf(wng);
                                String rgt12 = String.valueOf(rgt1);
                                String wng22 = String.valueOf(wng1);

                                if (rgt11.equals("") && wng11.equals("") && rgt12.equals("") && wng22.equals("")) {
                                    Toast.makeText(MainActivity.this, "Please Test all", Toast.LENGTH_SHORT).show();
                                } else {
                                    long rownumber = databaseHelper.saveData(date, rgt11, wng11, rgt12, wng22);
                                    if (rownumber > -1) {
                                        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Not Saved Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        wng = wng + 1;
                        bb.setText("Wrong: " + String.valueOf(wng));
                        int as = rgt + wng;
                        ee.setText("Total: " + String.valueOf(as));
                        if (as == 30) {
                            a.setEnabled(false);
                            b.setEnabled(false);
                            int as1=rgt1+wng1;
                            if(as1==30)
                            {

                                String rgt11 = String.valueOf(rgt);
                                String wng11 = String.valueOf(wng);
                                String rgt12 = String.valueOf(rgt1);
                                String wng22 = String.valueOf(wng1);

                                if (rgt11.equals("") && wng11.equals("") && rgt12.equals("") && wng22.equals("")) {
                                    Toast.makeText(MainActivity.this, "Please Test all", Toast.LENGTH_SHORT).show();
                                } else {
                                    long rownumber = databaseHelper.saveData(date, rgt11, wng11, rgt12, wng22);
                                    if (rownumber > -1) {
                                        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Not Saved Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });
                c.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rgt1 = rgt1 + 1;
                        cc.setText("Right: " + String.valueOf(rgt1));
                        int as = rgt1 + wng1;
                        ff.setText("Total: " + String.valueOf(as));
                        if (as == 30) {
                            c.setEnabled(false);
                            d.setEnabled(false);
                            int as1=rgt+wng;
                            if(as1==30)
                            {

                                String rgt11 = String.valueOf(rgt);
                                String wng11 = String.valueOf(wng);
                                String rgt12 = String.valueOf(rgt1);
                                String wng22 = String.valueOf(wng1);

                                if (rgt11.equals("") && wng11.equals("") && rgt12.equals("") && wng22.equals("")) {
                                    Toast.makeText(MainActivity.this, "Please Test all", Toast.LENGTH_SHORT).show();
                                } else {
                                    long rownumber = databaseHelper.saveData(date, rgt11, wng11, rgt12, wng22);
                                    if (rownumber > -1) {
                                        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Not Saved Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });
                d.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        wng1 = wng1 + 1;
                        dd.setText("Wrong: " + String.valueOf(wng1));
                        int as = rgt1 + wng1;
                        ff.setText("Total: " + String.valueOf(as));
                        if (as == 30) {
                            c.setEnabled(false);
                            d.setEnabled(false);
                            int as1=rgt+wng;
                            if(as1==30)
                            {

                                String rgt11 = String.valueOf(rgt);
                                String wng11 = String.valueOf(wng);
                                String rgt12 = String.valueOf(rgt1);
                                String wng22 = String.valueOf(wng1);

                                if (rgt11.equals("") && wng11.equals("") && rgt12.equals("") && wng22.equals("")) {
                                    Toast.makeText(MainActivity.this, "Please Test all", Toast.LENGTH_SHORT).show();
                                } else {
                                    long rownumber = databaseHelper.saveData(date, rgt11, wng11, rgt12, wng22);
                                    if (rownumber > -1) {
                                        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Not Saved Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });
                f.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent add = new Intent(MainActivity.this, shows.class);
                        startActivity(add);
                    }
                });




            }
        });
        mb.setNegativeButton("15", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int tt=rgt+wng,ttt=rgt1+wng1;
                a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rgt = rgt + 1;
                        aa.setText("Right: " + String.valueOf(rgt));
                        int as = rgt + wng;
                        ee.setText("Total: " + String.valueOf(as));
                        if (as == 15) {
                            a.setEnabled(false);
                            b.setEnabled(false);
                            int as1=rgt1+wng1;
                            if(as1==15)
                            {

                                String rgt11 = String.valueOf(rgt);
                                String wng11 = String.valueOf(wng);
                                String rgt12 = String.valueOf(rgt1);
                                String wng22 = String.valueOf(wng1);

                                if (rgt11.equals("") && wng11.equals("") && rgt12.equals("") && wng22.equals("")) {
                                    Toast.makeText(MainActivity.this, "Please Test all", Toast.LENGTH_SHORT).show();
                                } else {
                                    long rownumber = databaseHelper.saveData(date, rgt11, wng11, rgt12, wng22);
                                    if (rownumber > -1) {
                                        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Not Saved Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        wng = wng + 1;
                        bb.setText("Wrong: " + String.valueOf(wng));
                        int as = rgt + wng;
                        ee.setText("Total: " + String.valueOf(as));
                        if (as == 15) {
                            a.setEnabled(false);
                            b.setEnabled(false);
                            int as1=rgt1+wng1;
                            if(as1==15)
                            {

                                String rgt11 = String.valueOf(rgt);
                                String wng11 = String.valueOf(wng);
                                String rgt12 = String.valueOf(rgt1);
                                String wng22 = String.valueOf(wng1);

                                if (rgt11.equals("") && wng11.equals("") && rgt12.equals("") && wng22.equals("")) {
                                    Toast.makeText(MainActivity.this, "Please Test all", Toast.LENGTH_SHORT).show();
                                } else {
                                    long rownumber = databaseHelper.saveData(date, rgt11, wng11, rgt12, wng22);
                                    if (rownumber > -1) {
                                        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Not Saved Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });
                c.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rgt1 = rgt1 + 1;
                        cc.setText("Right: " + String.valueOf(rgt1));
                        int as = rgt1 + wng1;
                        ff.setText("Total: " + String.valueOf(as));
                        if (as == 15) {
                            c.setEnabled(false);
                            d.setEnabled(false);
                            int as1=rgt+wng;
                            if(as1==15)
                            {

                                String rgt11 = String.valueOf(rgt);
                                String wng11 = String.valueOf(wng);
                                String rgt12 = String.valueOf(rgt1);
                                String wng22 = String.valueOf(wng1);

                                if (rgt11.equals("") && wng11.equals("") && rgt12.equals("") && wng22.equals("")) {
                                    Toast.makeText(MainActivity.this, "Please Test all", Toast.LENGTH_SHORT).show();
                                } else {
                                    long rownumber = databaseHelper.saveData(date, rgt11, wng11, rgt12, wng22);
                                    if (rownumber > -1) {
                                        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Not Saved Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });
                d.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        wng1 = wng1 + 1;
                        dd.setText("Wrong: " + String.valueOf(wng1));
                        int as = rgt1 + wng1;
                        ff.setText("Total: " + String.valueOf(as));
                        if (as == 15) {
                            c.setEnabled(false);
                            d.setEnabled(false);
                            int as1=rgt+wng;
                            if(as1==15)
                            {

                                String rgt11 = String.valueOf(rgt);
                                String wng11 = String.valueOf(wng);
                                String rgt12 = String.valueOf(rgt1);
                                String wng22 = String.valueOf(wng1);

                                if (rgt11.equals("") && wng11.equals("") && rgt12.equals("") && wng22.equals("")) {
                                    Toast.makeText(MainActivity.this, "Please Test all", Toast.LENGTH_SHORT).show();
                                } else {
                                    long rownumber = databaseHelper.saveData(date, rgt11, wng11, rgt12, wng22);
                                    if (rownumber > -1) {
                                        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Not Saved Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });


                f.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent add = new Intent(MainActivity.this, shows.class);
                        startActivity(add);
                    }
                });



            }
        });
        //mb.setView(view);
        AlertDialog dialog=mb.create();
        dialog.show();
    }

@Override

public void onBackPressed() {

    if (backPressedTime + 2000 > System.currentTimeMillis()) {
        backToast.cancel();
        super.onBackPressed();
        return;
    }
    else {
        backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
        backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}

