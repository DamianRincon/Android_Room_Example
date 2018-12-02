package mx.rincon.damian.crudroom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.rincon.damian.crudroom.nodos.Contact;

public class AddContact extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_REPLY = "mx.rincon.damian.REPLY";
    EditText name,email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        findViewById(R.id.button).setOnClickListener(this);
        name = findViewById(R.id.editText);
        email = findViewById(R.id.editText2);
        phone = findViewById(R.id.editText3);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button){
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(name.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String namecontact = name.getText().toString();
                String emailcontact = email.getText().toString();
                String phonecontact = phone.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, new Contact(0,namecontact,emailcontact,phonecontact));
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        }
    }
}
