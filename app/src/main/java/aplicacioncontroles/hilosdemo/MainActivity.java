package aplicacioncontroles.hilosdemo;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView lblContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblContador = (TextView)findViewById(R.id.lblContador);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            lblContador.setText(msg.arg1+"");
            super.handleMessage(msg);
        }
    };

    public void probarHilo (View v){
        Thread hilo = new Thread((new Runnable() {
            @Override
            public void run() {
                for ( int i = 0 ; i < 100; i++)
                {
                    SystemClock.sleep(1000);
                    Log.d("contador",i+"");
                    Message mensaje = handler.obtainMessage();
                    mensaje.arg1 = i;
                    handler.sendMessage(mensaje);
                }
            }
        }));
        hilo.start();

    }
}
