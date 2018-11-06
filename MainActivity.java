package com.example.giuli.se_ui_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean formerror = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Sign Up");

        final TextView name = findViewById(R.id.name_input);
        final TextView email = findViewById(R.id.email_input);
        final TextView password = findViewById(R.id.password_input);
        final TextView confirmpass = findViewById(R.id.confirmpass_input);
        final Spinner preference = findViewById(R.id.spinner1);

        final Spinner spinner1 = findViewById(R.id.spinner1);
        final EditText spinner1text = findViewById(R.id.spinner1_act_dir);
        final Spinner spinner1genres = findViewById(R.id.spinner1_genres);
        final Spinner spinner2 = findViewById(R.id.spinner2);
        final EditText spinner2text = findViewById(R.id.spinner2_act_dir);
        final Spinner spinner2genres = findViewById(R.id.spinner2_genres);
        final Spinner spinner3 = findViewById(R.id.spinner3);
        final EditText spinner3text = findViewById(R.id.spinner3_act_dir);
        final Spinner spinner3genres = findViewById(R.id.spinner3_genres);
        final Spinner spinner4 = findViewById(R.id.spinner4);
        final EditText spinner4text = findViewById(R.id.spinner4_act_dir);
        final Spinner spinner4genres = findViewById(R.id.spinner4_genres);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spinner1genres.setVisibility(View.GONE);
                    spinner1text.setVisibility(View.GONE);
                }
                else if (position == 1) {
                    spinner1genres.setVisibility(View.GONE);
                    spinner1text.setVisibility(View.VISIBLE);
                }
                else if (position == 2) {
                    spinner1genres.setVisibility(View.GONE);
                    spinner1text.setVisibility(View.VISIBLE);
                }
                else if (position == 3) {
                    spinner1text.setVisibility(View.GONE);
                    spinner1genres.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spinner2genres.setVisibility(View.GONE);
                    spinner2text.setVisibility(View.GONE);
                }
                else if (position == 1) {
                    spinner2genres.setVisibility(View.GONE);
                    spinner2text.setVisibility(View.VISIBLE);
                }
                else if (position == 2) {
                    spinner2genres.setVisibility(View.GONE);
                    spinner2text.setVisibility(View.VISIBLE);
                }
                else if (position == 3) {
                    spinner2text.setVisibility(View.GONE);
                    spinner2genres.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spinner3genres.setVisibility(View.GONE);
                    spinner3text.setVisibility(View.GONE);
                }
                else if (position == 1) {
                    spinner3genres.setVisibility(View.GONE);
                    spinner3text.setVisibility(View.VISIBLE);
                }
                else if (position == 2) {
                    spinner3genres.setVisibility(View.GONE);
                    spinner3text.setVisibility(View.VISIBLE);
                }
                else if (position == 3) {
                    spinner3text.setVisibility(View.GONE);
                    spinner3genres.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spinner4genres.setVisibility(View.GONE);
                    spinner4text.setVisibility(View.GONE);
                }
                else if (position == 1) {
                    spinner4genres.setVisibility(View.GONE);
                    spinner4text.setVisibility(View.VISIBLE);
                }
                else if (position == 2) {
                    spinner4genres.setVisibility(View.GONE);
                    spinner4text.setVisibility(View.VISIBLE);
                }
                else if (position == 3) {
                    spinner4text.setVisibility(View.GONE);
                    spinner4genres.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formerror = false;
                boolean pass_error = false;
                String pass = password.getText().toString();
                String confirm = confirmpass.getText().toString();

                if(name.getText().toString().matches("")){
                    formerror = true;
                    name.setError("Missing Name");
                }
                if(email.getText().toString().matches("")){
                    formerror = true;
                    email.setError("Missing Email");
                }
                if(password.getText().toString().matches("")){
                    formerror = true;
                    pass_error = true;
                    password.setError("Missing Password");
                }
                if(confirmpass.getText().toString().matches("")){
                    formerror = true;
                    pass_error = true;
                    confirmpass.setError("Missing Confirmed Password");
                }
                if(!pass_error && !confirm.matches(pass)){
                    formerror = true;
                    confirmpass.setError("Password and Confirmed Password do not match");
                }
                if(preference.getSelectedItemPosition() == 0){
                    ((TextView) preference.getSelectedView()).setError("Select Preference");
                    formerror = true;
                }
                if(formerror){
                    Toast.makeText(MainActivity.this, "Error in form", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
