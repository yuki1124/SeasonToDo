package io.yukimaru.seasontodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button springButton;
    Button summerButton;
    Button autumnButton;
    Button winterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        springButton = (Button)findViewById(R.id.spring_button);
        summerButton = (Button)findViewById(R.id.summer_button);
        autumnButton = (Button)findViewById(R.id.autumn_button);
        winterButton = (Button)findViewById(R.id.winter_button);
    }
}
