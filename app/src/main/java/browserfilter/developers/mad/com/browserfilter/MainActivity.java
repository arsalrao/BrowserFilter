package browserfilter.developers.mad.com.browserfilter;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import static browserfilter.developers.mad.com.browserfilter.R.string.app_name;

public class MainActivity extends Activity {
        private Button send;
    private EditText web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         send = (Button) findViewById(R.id.send);
         web = (EditText) findViewById(R.id.webname);



        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolber);


        toolbar.setTitle(getResources().getString(app_name));




        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this,UrlLoader.class);
                intent.putExtra("url","https://www."+web.getText().toString()+".com");

                startActivity(intent);


            }
        });


    }
}
