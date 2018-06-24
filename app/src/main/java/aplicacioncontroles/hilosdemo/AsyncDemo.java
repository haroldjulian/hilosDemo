package aplicacioncontroles.hilosdemo;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AsyncDemo extends AppCompatActivity {

    TextView lblProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_demo);

        lblProgreso = (TextView) findViewById(R.id.lblProgreso);
        AsyncCount asyncCount = new AsyncCount();  //instanciamos el objeto
        asyncCount.execute();  //ejecutamos el contador
    }

    class AsyncCount extends AsyncTask<String,Integer,Bitmap>{
        @Override
        protected Bitmap doInBackground(String... params) {
            for (int i =0; i<100; i++){
                SystemClock.sleep(1000);
                publishProgress(i);

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            lblProgreso.setText(values[0]+"");
            super.onProgressUpdate(values);
        }
    }



}
