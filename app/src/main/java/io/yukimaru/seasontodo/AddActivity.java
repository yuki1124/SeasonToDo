package io.yukimaru.seasontodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AddActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();

    EditText contentText;
    Button sendButton;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        contentText = (EditText)findViewById(R.id.content_text);
        sendButton = (Button)findViewById(R.id.send_button);

        Intent intent = getIntent();
        message = intent.getStringExtra(ListActivity.Season);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = contentText.getText().toString();
                String key = reference.push().getKey();//keyのpush->firebaseのkey(現在時刻を暗号化したもの)
                Item item = new Item(content,key);

                reference.child(message).child(key).setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                //reference.child(message).setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {//保存がされた後の処理
                    @Override
                    public void onSuccess(Void aVoid) {
                        finish();//画面を閉じる
                    }
            });
            }
    });
}
}
