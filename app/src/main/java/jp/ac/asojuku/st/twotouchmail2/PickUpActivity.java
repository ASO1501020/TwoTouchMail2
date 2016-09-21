package jp.ac.asojuku.st.twotouchmail2;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class PickUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);

        Button btnSend = (Button) this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgplace = (RadioGroup) findViewById(R.id.rg_place);
                int checkedId = rgplace.getCheckedRadioButtonId();
                String strPlace = ((RadioButton) findViewById(checkedId)).getText().toString();
                EditText edit01 = (EditText) findViewById(R.id.editText);
                String title = edit01.getText().toString();
                Resources res = getResources();
                Uri uri = null;
                Random r = new Random();
                int n = r.nextInt(3) + 1;
                if(n == 1){
                    uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
                } else if(n == 2){
                    uri = Uri.parse("mailto1:" + res.getString(R.string.mail_to1).toString());
                } else  {
                    uri = Uri.parse("mailto2:" + res.getString(R.string.mail_to2).toString());
                }

                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, title);
                intent.putExtra(Intent.EXTRA_TEXT, strPlace + "迎えに来て");
                startActivity(intent);
            }
        });
    }
}
