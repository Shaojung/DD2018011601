package tw.com.pcschool.dd2018011601;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        String str = getFilesDir().getAbsolutePath();
        Log.d("FILE", str);
        String str1 = getCacheDir().getAbsolutePath();
        Log.d("FILE", str1);
    }
    public void click2(View v)
    {

        File f = new File(getFilesDir(), "myfile.txt");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write("Hello World");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
