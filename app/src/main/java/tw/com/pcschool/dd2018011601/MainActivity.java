package tw.com.pcschool.dd2018011601;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
    public void click3(View v)
    {
        ArrayList<String> mylist = new ArrayList();
        mylist.add("Bob");
        mylist.add("Mary");
        mylist.add("Peter");
        File f = new File(getFilesDir(), "myfile1.txt");
        try {
            FileWriter fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mylist);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clickRead1(View v)
    {
        File f = new File(getFilesDir(), "myfile1.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("FILE", str);
            Gson gson = new Gson();
            ArrayList<String> mydata = gson.fromJson(str, new TypeToken<ArrayList<String>>(){}.getType());
            for (String s :  mydata)
            {
                Log.d("FILE", "data:" + s);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void click4(View v)
    {
        ArrayList<Student> mydata = new ArrayList();
        mydata.add(new Student(1, "Bob", 95));
        mydata.add(new Student(2, "Mary", 98));
        mydata.add(new Student(3, "Peter", 80));

        File f = new File(getFilesDir(), "myfile2.txt");
        try {
            FileWriter fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mydata);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clickRead2(View v)
    {
        File f = new File(getFilesDir(), "myfile2.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("FILE", str);
            Gson gson = new Gson();
            ArrayList<Student> mydata = gson.fromJson(str, new TypeToken<ArrayList<Student>>(){}.getType());
            for (Student s :  mydata)
            {
                Log.d("FILE", "data:" + s.id + "," + s.name);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click5(View v)
    {
        File f = getExternalFilesDir("data");
        Log.d("FILE", f.getAbsolutePath());
    }

    public void click6(View v)
    {
        File f = Environment.getExternalStorageDirectory();
        Log.d("FILE", f.getAbsolutePath());
    }

    class Student
    {
        public int id;
        public String name;
        public int score;
        public Student(int id, String name, int score)
        {
            this.id = id;
            this.name = name;
            this.score = score;
        }
    }
}
