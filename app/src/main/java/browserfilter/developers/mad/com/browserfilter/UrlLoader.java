package browserfilter.developers.mad.com.browserfilter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static browserfilter.developers.mad.com.browserfilter.R.string.app_name;

public class UrlLoader extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





//Stric mode allow network call on main thread ..

//

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(threadPolicy);



        setContentView(R.layout.urlloader_main);




        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolber);
        toolbar.setTitle(getResources().getString(app_name));





        String getUrl= getIntent().getStringExtra("url");

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(getUrl));

        TextView text = (TextView) findViewById(R.id.textView);

        String action = intent.getAction();
        if (!(action == Intent.ACTION_VIEW)) {
            new Throwable("Nothing heppen");

        }

        Uri uri = intent.getData();
        URL url;

        try {
            url = new URL(uri.getScheme(), uri.getHost(), uri.getPath());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {


                text.append(line);

            }
            //Log.i("WEB s ",line);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if(text.getText().toString()==""){
            text.setText(getUrl+" is not have any website!");
        }

    }
}
