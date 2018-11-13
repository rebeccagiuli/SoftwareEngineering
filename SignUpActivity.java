package edu.fsu.cs.cen4020.showMe;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import edu.fsu.cs.cen4020.showMe.R;

public class SignUpActivity extends AppCompatActivity {

    boolean formError = false;
    SQLiteOpenHelper openHelper;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        openHelper = new DatabaseHelper(this);
        db = new DatabaseHelper(this);
        setTitle("Sign Up");

        final TextView name = findViewById(R.id.name_input);
        final TextView email = findViewById(R.id.email_input);
        final TextView password = findViewById(R.id.password_input);
        final TextView confirmPass = findViewById(R.id.confirmpass_input);
        final TextView mostImportant = findViewById(R.id.textView6);
        final CheckBox check1 = findViewById(R.id.checkBox1);
        final CheckBox check2 = findViewById(R.id.checkBox2);
        final CheckBox check3 = findViewById(R.id.checkBox3);

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
                formError = false;
                boolean passError = false;
                String usersName = name.getText().toString();
                String usersEmail = email.getText().toString();
                String pass = password.getText().toString();
                String confirm = confirmPass.getText().toString();

                if(usersName.isEmpty()){
                    formError = true;
                    name.setError("Must enter your name!");
                }
                if(usersEmail.isEmpty()){
                    formError = true;
                    email.setError("Must enter a email!");
                }
                if(pass.isEmpty()){
                    formError = true;
                    passError = true;
                    password.setError("Must enter a password!");
                }
                if(confirm.isEmpty()){
                    formError = true;
                    passError = true;
                    confirmPass.setError("Must confirm password!");
                }
                if(!passError && !confirm.matches(pass)){
                    formError = true;
                    password.setError("Passwords don't match!");
                    confirmPass.setError("Passwords don't match!");
                }
                if(preference.getSelectedItemPosition() == 0){
                    mostImportant.setError("Must select at least one preference");
                    formError = true;
                }
                else {
                    if (pass.equals(confirm)) {
                        Boolean insert = db.insert(usersName, usersEmail, confirm);
                        if (insert) {
                            Toast.makeText(getApplicationContext(), "Sign-up successful!", Toast.LENGTH_LONG).show();
                            Intent myIntent = new Intent(SignUpActivity.this, UserProfileActivity.class);
                            startActivityForResult(myIntent, 0);
                        } else
                            email.setError("Account already exists with this email");
                    }
                }
            }
        });

        Button reset = findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                name.setError(null);
                email.setText("");
                email.setError(null);
                password.setText("");
                password.setError(null);
                confirmPass.setText("");
                confirmPass.setError(null);
                spinner1.setSelection(0);
                spinner2.setSelection(0);
                spinner3.setSelection(0);
                spinner4.setSelection(0);
                check1.setChecked(false);
                check2.setChecked(false);
                check3.setChecked(false);
                mostImportant.setError(null);
                Toast.makeText(SignUpActivity.this, "Fields Reset", Toast.LENGTH_LONG).show();
            }
        });
    }
}
