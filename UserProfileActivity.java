package edu.fsu.cs.cen4020.showMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import edu.fsu.cs.cen4020.showMe.R;


public class UserProfileActivity extends AppCompatActivity implements View.OnClickListener{
    CardView card_genre, card_actor, card_director;
    Button button_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // defining cards
        card_genre = (CardView) findViewById(R.id.cardview_genre);
        card_actor = (CardView) findViewById(R.id.cardview_actor);
        card_director = (CardView) findViewById(R.id.cardview_director);

        // add click listener for each card
        card_genre.setOnClickListener(this);
        card_actor.setOnClickListener(this);
        card_director.setOnClickListener(this);

        Button settings = findViewById(R.id.button_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myintent = new Intent(UserProfileActivity.this, SettingsActivity.class);
                startActivity(myintent);
            }
        });


    }

    // switch activity based on card clicked
    @Override
    public void onClick(View v) {
        Intent intent;

        switch(v.getId()) {
            case R.id.cardview_genre:
                intent = new Intent(this, GenreListActivity.class);
                startActivity(intent);
                break;

            case R.id.cardview_actor:
                intent = new Intent(this, ActorListActivity.class);
                startActivity(intent);
                break;

            case R.id.cardview_director:
                intent = new Intent(this, DirectorListActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }
}
