package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult,mt2,mt3,mt4,mt5,mt6,mt7,mt8;

    private RequestQueue mQueue; int count=0;int c1=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.info_text);
        Button btnparse=findViewById(R.id.btn);
        mt2=findViewById(R.id.info_text2);
        mt3=findViewById(R.id.info_text3);
        mt4=findViewById(R.id.info_text4);
        mt5=findViewById(R.id.info_text5);
        mt6=findViewById(R.id.info_text6);
        mt7=findViewById(R.id.info_text7);
        mt8=findViewById(R.id.info_text8);
        final CardView card_view1 = (CardView) findViewById(R.id.card_view);
        final CardView card_view2 = (CardView) findViewById(R.id.card_view2);
        final CardView card_view3 = (CardView) findViewById(R.id.card_view3);
        final CardView card_view4 = (CardView) findViewById(R.id.card_view4);
        final CardView card_view5 = (CardView) findViewById(R.id.card_view5);
        final CardView card_view6 = (CardView) findViewById(R.id.card_view6);
        final CardView card_view7 = (CardView) findViewById(R.id.card_view7);
        final CardView card_view8 = (CardView) findViewById(R.id.card_view8);



        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                if(c1%2!=0)
                {card_view1.setCardBackgroundColor(Color.parseColor("#FFDE03"));}
                else
                { card_view1.setCardBackgroundColor(Color.parseColor("#F57C00")); }

            }
        });
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                if(c1%2!=0)
                {card_view2.setCardBackgroundColor(Color.parseColor("#F57C00"));}
                else
                { card_view2.setCardBackgroundColor(Color.parseColor("#FFDE03")); }

            }
        });
        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                if(c1%2!=0)
                {card_view3.setCardBackgroundColor(Color.parseColor("#FFDE03"));}
                else
                { card_view3.setCardBackgroundColor(Color.parseColor("#F57C00")); }

            }
        });
        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                if(c1%2!=0)
                {card_view4.setCardBackgroundColor(Color.parseColor("#F57C00"));}
                else
                { card_view4.setCardBackgroundColor(Color.parseColor("#FFDE03")); }

            }
        });
        card_view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                if(c1%2!=0)
                {card_view5.setCardBackgroundColor(Color.parseColor("#FFDE03"));}
                else
                { card_view5.setCardBackgroundColor(Color.parseColor("#F57C00")); }

            }
        });
        card_view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                if(c1%2!=0)
                {card_view6.setCardBackgroundColor(Color.parseColor("#F57C00"));}
                else
                { card_view6.setCardBackgroundColor(Color.parseColor("#FFDE03")); }

            }
        });
        card_view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                if(c1%2!=0)
                {card_view7.setCardBackgroundColor(Color.parseColor("#FFDE03"));}
                else
                { card_view7.setCardBackgroundColor(Color.parseColor("#F57C00")); }

            }
        });
        card_view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                if(c1%2!=0)
                {card_view8.setCardBackgroundColor(Color.parseColor("#F57C00"));}
                else
                { card_view8.setCardBackgroundColor(Color.parseColor("#FFDE03")); }

            }
        });
        mQueue = Volley.newRequestQueue(this);

        btnparse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count++;
                if (count == 1) {
                    jsonParse();


                } else
                    {  Toast.makeText(getApplicationContext(),"The information is already displayed!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void jsonParse() {

        String url = "https://api.covid19api.com/summary";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Countries");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject cntry= jsonArray.getJSONObject(i);

                                String CntryName = cntry.getString("Country");
                                if (CntryName.equals("India")) {
                                    int New_Confirmed= cntry.getInt("NewConfirmed");
                                    int T_Confirmed= cntry.getInt("TotalConfirmed");
                                    int N_deaths=cntry.getInt("NewDeaths");
                                    int T_deaths=cntry.getInt("TotalDeaths");
                                    int N_recover=cntry.getInt("NewRecovered");
                                    int T_recovered=cntry.getInt("TotalRecovered");
                                    String date=cntry.getString("Date");
                                    String date2[]=date.split("T");

                                    //mTextViewResult.append("COUNTRY INDIA \n\n New Confirmed Cases:" + "\t"+String.valueOf(New_Confirmed) + "\n\n Total number of confirmed cases: " + String.valueOf(T_Confirmed)
                                                           //+ "\n\n New Deaths:"+"\t"+N_deaths+"\n\n Total Deaths:"+"\t"+T_deaths+"\n\n New Recovered:"+"\t"+N_recover+"\n\n Total Recovered:"+"\t"+T_recovered+"\n Date:"+"\t"+date2[0]+"\n\n Time:"+"\t"+date2[1]);
                                    mTextViewResult.append("New Confirmed Cases:"+"\t"+String.valueOf(New_Confirmed));
                                    mt2.append("Total Confirmed Cases:"+"\t"+T_Confirmed);
                                    mt3.append("New Deaths:"+"\t"+N_deaths);
                                    mt4.append("Total Deaths:"+"\t"+T_deaths);
                                    mt5.append("New Recovered:"+"\t"+N_recover);
                                    mt6.append("Total Recovered:"+"\t"+T_recovered);
                                    mt7.append("Date:"+"\t"+date2[0]);
                                    mt8.append("Time:"+"\t"+date2[1]);




                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getApplicationContext(),"Opps!Something went wrong",Toast.LENGTH_LONG).show();
            }
        });

        mQueue.add(request);
    }
}