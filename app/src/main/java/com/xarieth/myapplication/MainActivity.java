package com.xarieth.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xarieth.myapplication.adapter.PersonListAdapter;
import com.xarieth.myapplication.model.PersonDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PersonListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private List<PersonDetails> personDetailsList = new ArrayList<>();
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.place_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new PersonListAdapter(this, personDetailsList);
        recyclerView.setAdapter(adapter);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_GET_PERSON, null, CODE_GET_REQUEST);
        request.execute();
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                Log.e("list", String.valueOf(s));
                JSONObject object = new JSONObject(s);


                if (!object.getBoolean("error")) {

                    JSONArray list = object.getJSONArray("persons");

                    for (int i = 0; i < list.length(); i++) {
                        PersonDetails personDetails = new PersonDetails();
                        JSONObject place = list.getJSONObject(i);

                        personDetails.setId(place.getString("id"));
                        personDetails.setFirstname(place.getString("firstname"));
                        personDetails.setLastname(place.getString("lastname"));
                        personDetails.setBirthday(place.getString("birthday"));
                        personDetails.setEmail(place.getString("email"));
                        personDetails.setMobilenumber(place.getString("mobilenumber"));
                        personDetails.setAddress(place.getString("address"));
                        personDetails.setContactperson(place.getString("contactperson"));
                        personDetails.setContactpersonnumber(place.getString("contactpersonnumber"));
                        personDetailsList.add(personDetails);

                    }

                    adapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);

            if (requestCode == CODE_GET_REQUEST)
                return requestHandler.sendGetRequest(url);

            return null;
        }
    }
}
