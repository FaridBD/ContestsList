package com.example.farid.contestslist;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ExpandableListAdapter;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private List<ContestActivity> Codeforces_list = new ArrayList<>();
    private List<ContestActivity> CodeChef_list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        //make_list_for_Codeforces();
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "Present contest", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "April Fool", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "April Fool", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "April Fool", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "April Fool", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "April Fool", R.drawable.codeforces));
        Codeforces_list.add(new ContestActivity("24", "Apr 2018 (21:00)", "25", "Apr 2018 (22:00)", "April Fool", R.drawable.codeforces));


        RecyclerAdapter myAdapter = new RecyclerAdapter(this, Codeforces_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        
    }
    public void make_list_for_Codeforces() {

        //Codeforces_list.add(new ContestActivity("1", "Method e aise", "25", "Apr 2018 (22:00)", "April Fool", R.drawable.codeforces));

        new Thread(new Runnable() {
            @Override
            public void run() {

                //String url = "https://www.codechef.com/users/_farid_";
                String url = "http://codeforces.com/contests";
                Codeforces_list.add(new ContestActivity("1", "Element paisi", "25", "Apr 2018 (22:00)", "Try 1", R.drawable.codeforces));
                try {


                    Document doc = Jsoup.connect(url).get();

                    Codeforces_list.add(new ContestActivity("1", "Element paisi", "25", "Apr 2018 (22:00)", "Try 2", R.drawable.codeforces));
                    //Connection.Response response = Jsoup.connect(url).timeout(5000).execute();
                    //Document doc = response.parse();

                    Elements el = doc.getElementsByClass("datatable").get(0).select("tbody").select("tr");

                    Codeforces_list.add(new ContestActivity("1", "Element paisi", "25", "Apr 2018 (22:00)", "April Fool", R.drawable.codeforces));

                    int len = el.size();
                    /**
                     * VK Cup 2018 - Round 3 Apr/29/2018 16:05 02:00
                     */

                    for (int i = 1; i < len; i++) {

                        //Toast.makeText( this, "HY", Toast.LENGTH_LONG ).show();
                        String contest_name = el.get(i).select("td").get(0).text(); // Contest_Name
                        String contest_date = el.get(i).select("td").get(2).text();
                        String contest_duration = el.get(i).select("td").get(3).text();

                        Codeforces_list.add(new ContestActivity(Integer.toString(i), contest_name, "25", "Apr 2018 (22:00)", "April Fool", R.drawable.codeforces));
                        String start_date = contest_date.substring(4, 6);
                        String start_information = contest_date.replaceFirst("/" + start_date + "/", " ");

                        String end_date_information = GiveMeEnd(contest_date, contest_duration);

                        if (end_date_information.length() == 0) continue;

                        String end_date = end_date_information.substring(8, 10);
                        int le = end_date_information.length();


                        String end_information = end_date_information.substring(4, 7) + " " + end_date_information.substring(le - 4, le) + " " + end_date_information.substring(11, 20);

                        //System.out.printf("%s <> %s <> %s <> %s\n", start_date, start_information, end_information, end_date);

                        //Codeforces_list.add(new ContestActivity(start_date, start_information, null, null, contest_name, R.drawable.codeforces));
                        Codeforces_list.add(new ContestActivity(start_date, start_information, end_date, end_information, contest_name, R.drawable.codeforces));

                    }
                } catch (Exception e) {
                    Codeforces_list.add(new ContestActivity("1", "Method e aise", "25", "Apr 2018 (22:00)", "Catch e hamaise", R.drawable.codeforces));
                    e.printStackTrace();
                }
            }
        }).start();

    }
    /**
     * VK Cup 2018 - Round 3 Apr/29/2018 16:05 02:00
     */
    public static String GiveMeEnd(String start_date, String duration) {

        Helpful_Codes(); // Nothing but useful

        System.out.println(start_date + " " + duration);

        int year = Integer.valueOf(start_date.substring(7, 11));
        int month = Month(start_date.substring(0, 3));
        int date = Integer.valueOf(start_date.substring(4, 6));
        int hour = Integer.valueOf(start_date.substring(12, 14));
        int min = Integer.valueOf(start_date.substring(15, 17));
        int len = duration.length();
        int duration_min = 0, duration_hour = 0, duration_day = 0;

        if(len-2 >= 0) {
            duration_min = Integer.valueOf(duration.substring(len-2, len));
            len -= 2;
        }
        else if(len == 1) {
            duration_min = Integer.valueOf(duration.substring(len-1, len));
            len--;
        }
        len--;

        if(len-2 >= 0) {
            duration_hour = Integer.valueOf(duration.substring(len-2, len));
            len -= 2;
        }
        else if(len == 1) {
            duration_hour = Integer.valueOf(duration.substring(len-1, len));
            len--;
        }
        len--;

        if(len-2 >= 0) {
            duration_day = Integer.valueOf(duration.substring(len-2, len));
            len -= 2;
        }
        else if(len == 1) {
            duration_day = Integer.valueOf(duration.substring(len-1, len));
            len--;
        }
        len--;

        DateFormat format = new SimpleDateFormat("MMM/dd/yyyy HH:mm", Locale.US);

        String End_Time = null;
        String ans = "kunta nai";

        try {

            Date parse_date = format.parse(start_date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse_date);

            System.out.println(parse_date.toString());
            calendar.add(Calendar.MINUTE, duration_min);
            calendar.add(Calendar.HOUR, duration_hour);
            calendar.add(Calendar.DAY_OF_MONTH, duration_day);

            End_Time = calendar.getTime().toString();
            ans = "aise";

        }catch(Exception e) {
            System.out.println("Something Went wrong");
        }
        //System.out.println(End_Time);

        return End_Time;
    }


    public static int Month(String month) {
        if(month.toLowerCase() == "jan") return 1;
        if(month.toLowerCase() == "feb") return 2;
        if(month.toLowerCase() == "mar") return 3;
        if(month.toLowerCase() == "apr") return 4;
        if(month.toLowerCase() == "may") return 5;
        if(month.toLowerCase() == "jun") return 6;
        if(month.toLowerCase() == "jul") return 7;
        if(month.toLowerCase() == "aug") return 8;
        if(month.toLowerCase() == "sep") return 9;
        if(month.toLowerCase() == "oct") return 10;
        if(month.toLowerCase() == "nov") return 11;
        if(month.toLowerCase() == "dec") return 12;
        return 0;
    }

    public static void Helpful_Codes(){
        /**
         Helpful Links:
         --------------
         http://www.digitstory.com/recyclerview-multiple-viewholders/
         https://developer.android.com/reference/java/text/SimpleDateFormat.html
         https://stackoverflow.com/questions/22917562/adding-n-number-of-days-in-a-given-particular-date
         https://stackoverflow.com/questions/1459656/how-to-get-the-current-time-in-yyyy-mm-dd-hhmisec-millisecond-format-in-java?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
         https://stackoverflow.com/questions/18733582/calculating-a-future-date?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
         */
    }

}
