package me.bitye.edgemode;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.Status);
        readStatus();
    }
    public void readStatus() {
        String status = do_exec("cat /sys/class/input/input1/edge_mode");
        if(status.compareTo("0") == 0){
            text.setText(R.string.edgemodeoff);
        }
        else if(status.compareTo("2") == 0){
            text.setText(R.string.edgemodeon);
        }
    }
    public String do_exec(String cmd) {
        String s = "";
        try {
            Process p = Runtime.getRuntime().exec(new String[]{ "su", "-c", cmd });
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                s += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }


    public void edgeOn(View view){
        try {
            Runtime.getRuntime().exec(new String[]{ "su", "-c", "echo 2 > /sys/class/input/input1/edge_mode" });
        } catch (IOException error) {
            Log.d("su", error.getMessage());
        }
        readStatus();
    }

    public void edgeOff(View view){
        try {
            Runtime.getRuntime().exec(new String[]{ "su", "-c", "echo 0 > /sys/class/input/input1/edge_mode" });
        } catch (IOException error) {
            Log.d("su", error.getMessage());
        }
        readStatus();
    }
}
