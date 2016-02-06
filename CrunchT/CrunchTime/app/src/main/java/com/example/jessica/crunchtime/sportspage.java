package com.example.jessica.crunchtime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class sportspage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportspage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Intent intent = getIntent();
        String n1 = intent.getStringExtra(Front.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.textView3);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Genome-Thin.otf");

        textView.setTypeface(custom_font);
        textView.setText("Hi, " + n1);
    }


        public void delete(View v) {
            EditText cals = (EditText) findViewById(R.id.editText2);//Number of calories user wants to burn
            cals.setText("");
            cals.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {

                    if (s != null) {
                        Double myNum = parseDouble(s.toString());

                        EditText jogBox = (EditText) findViewById(R.id.editText6);
                        jogBox.setText(Double.toString((myNum * 7.2) / 60));

                        EditText pushBox = (EditText) findViewById(R.id.editText5);
                        pushBox.setText(Double.toString(myNum * (350 / 100)));

                        EditText jumpBox = (EditText) findViewById(R.id.editText3);
                        jumpBox.setText(Double.toString((myNum * 6) / 60));

                        EditText sitBox = (EditText) findViewById(R.id.editText4);
                        sitBox.setText(Double.toString(myNum * (200 / 100)));
                    }
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });

        }


    public void edjog(View v) {
        EditText jogging = (EditText) findViewById(R.id.editText6);
        jogging.setText("");
        jogging.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Double myNum = parseDouble(s.toString());
                Double cals = (myNum * 6000) / (12 * 60);

                EditText calBox = (EditText) findViewById(R.id.editText2);
                calBox.setText(Double.toString(cals));

                EditText pushBox = (EditText) findViewById(R.id.editText5);
                pushBox.setText(Double.toString(cals * (350/100)));

                EditText jumpBox = (EditText) findViewById(R.id.editText3);
                jumpBox.setText(Double.toString((cals * 6) / 60));

                EditText sitBox = (EditText) findViewById(R.id.editText4);
                sitBox.setText(Double.toString(cals * (200/100)));
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }

    public void edpush(View v) {
        EditText pushups = (EditText) findViewById(R.id.editText5);
        pushups.setText("");
        pushups.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Double myNum = parseDouble(s.toString());
                Double cals = (myNum * 100) / 350;

                EditText calBox = (EditText) findViewById(R.id.editText2);
                calBox.setText(Double.toString(cals));

                EditText jogBox = (EditText) findViewById(R.id.editText6);
                jogBox.setText(Double.toString((cals * 7.2) / 60));

                EditText jumpBox = (EditText) findViewById(R.id.editText3);
                jumpBox.setText(Double.toString((cals * 6) / 60));

                EditText sitBox = (EditText) findViewById(R.id.editText4);
                sitBox.setText(Double.toString(cals * (200 / 100)));
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }

    public void edsit(View v) {
        EditText situps = (EditText) findViewById(R.id.editText4);
        situps.setText("");
        situps.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Double myNum = parseDouble(s.toString());
                Double cals = (myNum * 100) / 200;

                EditText calBox = (EditText) findViewById(R.id.editText2);
                calBox.setText(Double.toString(cals));

                EditText pushBox = (EditText) findViewById(R.id.editText5);
                pushBox.setText(Double.toString(cals * (350 / 100)));

                EditText jumpBox = (EditText) findViewById(R.id.editText3);
                jumpBox.setText(Double.toString((cals * 6) / 60));

                EditText jogBox = (EditText) findViewById(R.id.editText6);
                jogBox.setText(Double.toString((cals * 7.2) / 60));
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }

    public void edjump(View v) {
        EditText jumping = (EditText) findViewById(R.id.editText3);
        jumping.setText("");
        jumping.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Double myNum = parseDouble(s.toString());
                Double cals = (myNum * 6000) / (6 * 60);

                EditText calBox = (EditText) findViewById(R.id.editText2);
                calBox.setText(Double.toString(cals));

                EditText pushBox = (EditText) findViewById(R.id.editText5);
                pushBox.setText(Double.toString(cals * (350/100)));

                EditText jogBox = (EditText) findViewById(R.id.editText6);
                jogBox.setText(Double.toString((cals * 7.2) / 60));

                EditText sitBox = (EditText) findViewById(R.id.editText4);
                sitBox.setText(Double.toString(cals * (200/100)));
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }



    }

