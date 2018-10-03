package io.yukimaru.seasontodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    String season;
    ImageButton springButton;
    ImageButton summerButton;
    ImageButton autumnButton;
    ImageButton winterButton;

    //intent
    public static final String Season
            = "io.yukimaru.seasontodo.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        springButton = (ImageButton)findViewById(R.id.spring_button);
        summerButton = (ImageButton)findViewById(R.id.summer_button);
        autumnButton = (ImageButton)findViewById(R.id.autumn_button);
        winterButton = (ImageButton)findViewById(R.id.winter_button);
    }

    public void springClick(View v){
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        season = "Spring";
        intent.putExtra(Season, season);
        startActivity(intent);
    }

    public void summerClick(View v){
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        season = "Summer";
        intent.putExtra(Season,season);
        startActivity(intent);
    }

    public void autumnClick(View v){
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        season = "Autumn";
        intent.putExtra(Season,season);
        startActivity(intent);
    }

    public void winterClick(View v){
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        season = "Winter";
        intent.putExtra(Season,season);
        startActivity(intent);
    }

    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
    }
}
