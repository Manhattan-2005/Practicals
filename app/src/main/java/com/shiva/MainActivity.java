package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivity(View v) {

        if (v.getId() == R.id.program_for_practical4) {

            Intent it = new Intent(MainActivity.this, Practical_4_Program.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise_for_practical4) {

            Intent it = new Intent(MainActivity.this, Practical_4_Exercise.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical5) {

            Intent it = new Intent(MainActivity.this, Practical_5_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical6) {

            Intent it = new Intent(MainActivity.this, Practical_6_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise2_for_practical6) {

            Intent it = new Intent(MainActivity.this, Practical_6_Exercise2.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical7) {

            Intent it = new Intent(MainActivity.this, Practical_7_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise2_for_practical7) {

            Intent it = new Intent(MainActivity.this, Practical_7_Exercise2.class);
            startActivity(it);

        } else if (v.getId() == R.id.program_for_practical8) {

            Intent it = new Intent(MainActivity.this, Practical_8_Program.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise2_for_practical8) {

            Intent it = new Intent(MainActivity.this, Practical_8_Exercise2.class);
            startActivity(it);

        } else if (v.getId() == R.id.program_for_practical9) {

            Intent it = new Intent(MainActivity.this, Practical_9_Program.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical9) {

            Intent it = new Intent(MainActivity.this, Practical_9_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise2_for_practical9) {

            Intent it = new Intent(MainActivity.this, Practical_9_Exercise2.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical10) {

            HashMap<String, String> users = new HashMap<>();
            Intent it = new Intent(MainActivity.this, Practical_10_Exercise1.class);
            it.putExtra("users", users);
            startActivity(it);

        } else if (v.getId() == R.id.exercise2_for_practical10) {

            Intent it = new Intent(MainActivity.this, Practical_10_Exercise2.class);
            startActivity(it);

        } else if (v.getId() == R.id.program_for_practical11) {

            Intent it = new Intent(MainActivity.this, Practical_11_Program.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_for_practical11) {

            Intent it = new Intent(MainActivity.this, Practical_11_Exercise1.class);
            startActivity(it);

        }   else if (v.getId() == R.id.exercise1_for_practical12) {

            Intent it = new Intent(MainActivity.this, Practical_12_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.program_for_practical13) {

            Intent it = new Intent(MainActivity.this, Practical_13_Program.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_and_2_for_practical13) {

            Intent it = new Intent(MainActivity.this, Practical_13_Exercise1_and_2.class);
            startActivity(it);

        } else if (v.getId() == R.id.program_for_practical14) {

            Intent it = new Intent(MainActivity.this, Practical_14_Program.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical15) {

            Intent it = new Intent(MainActivity.this, Practical_15_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise2_for_practical15) {

            Intent it = new Intent(MainActivity.this, Practical_15_Exercise2.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical16) {

            Intent it = new Intent(MainActivity.this, Practical_16_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise2_for_practical16) {

            Intent it = new Intent(MainActivity.this, Practical_16_Exercise2.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical17) {

            Intent it = new Intent(MainActivity.this, Practical_17_Exercise1.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise_for_practical18) {

            Intent it = new Intent(MainActivity.this, Practical_18_Exercises.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_for_practical19) {

            Intent it = new Intent(MainActivity.this, Practical_19_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical20) {

            Intent it = new Intent(MainActivity.this, Practical_20_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise2_for_practical20) {

            Intent it = new Intent(MainActivity.this, Practical_20_Exercise2.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_for_practical21) {

            Intent it = new Intent(MainActivity.this, Practical_21_Exercise1.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_for_practical22) {

            Intent it = new Intent(MainActivity.this, Practical_22_Exercise1.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise2_for_practical22) {

            Intent it = new Intent(MainActivity.this, Practical_22_Exercise2.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_for_practical23) {

            Intent it = new Intent(MainActivity.this, Practical_23_Exercise1.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise2_for_practical23) {

            Intent it = new Intent(MainActivity.this, Practical_23_Exercise2.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_for_practical24) {

            Intent it = new Intent(MainActivity.this, Practical_24_Exercise1.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_for_practical25) {

            Intent it = new Intent(MainActivity.this, Practical_25_Exercise1.class);
            startActivity(it);

        }   else if (v.getId() == R.id.exercise1_for_practical26) {

            Intent it = new Intent(MainActivity.this, Practical_26_Exercise1.class);
            startActivity(it);

        } else if (v.getId() == R.id.exercise1_for_practical28) {

            Intent it = new Intent(MainActivity.this, Practical_28_Exercise1.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_for_practical29) {

            Intent it = new Intent(MainActivity.this, Practical_29_Exercise1.class);
            startActivity(it);

        }   else if (v.getId() == R.id.exercise1_for_practical30) {

            Intent it = new Intent(MainActivity.this, Practical_30_Exercise1.class);
            startActivity(it);

        }  else if (v.getId() == R.id.exercise1_for_practical31) {

            Intent it = new Intent(MainActivity.this, Practical_31_Exercise1.class);
            startActivity(it);

        }   else if (v.getId() == R.id.exercise1_for_practical32) {

            Intent it = new Intent(MainActivity.this, Practical_32_Exercise1.class);
            startActivity(it);

        }
    }

}