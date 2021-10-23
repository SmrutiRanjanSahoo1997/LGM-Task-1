package com.avengers.lgmtask1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.avengers.lgmtask1.Adapters.rcvAdapter;
import com.avengers.lgmtask1.Models.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Model> data;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.purple_700));

        recyclerView = findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(new rcvAdapter(getDataList()));
        loadDataList();
    }

    private void loadDataList() {
       data= new ArrayList<>();
       String url="https://data.covid19india.org/state_district_wise.json";

       RequestQueue queue= Volley.newRequestQueue(this);

       JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, response -> {
           Iterator<String> stateKeys=response.keys();
           while (stateKeys.hasNext()){
               try {
                   String stateName=stateKeys.next();
                   JSONObject stateObj=response.getJSONObject(stateName);
                   JSONObject districtObj=stateObj.getJSONObject(Model.KEY_DISTRICT_DATA);
                   Iterator<String> districtKeys=districtObj.keys();
                   while (districtKeys.hasNext()){
                       Model tempData=new Model();
                       String districtName=districtKeys.next();
                       tempData.setStateName(stateName);
                       tempData.setStateCode(stateObj.getString(Model.KEY_STATE_CODE));
                       tempData.setDistrictName(districtName);

                       JSONObject districtDataObj=districtObj.getJSONObject(districtName);
                       tempData.setNotes(districtDataObj.getString(Model.KEY_NOTES));
                       tempData.setActive(districtDataObj.getInt(Model.KEY_ACTIVE));
                       tempData.setConfirmed(districtDataObj.getInt(Model.KEY_CONFIRMED));
                       tempData.setMigratedOther(districtDataObj.getInt(Model.KEY_MIGRATED_OTHERS));
                       tempData.setDeceased(districtDataObj.getInt(Model.KEY_DECEASED));
                       tempData.setRecovered(districtDataObj.getInt(Model.KEY_RECOVERED));

                       JSONObject deltaObj=districtDataObj.getJSONObject(Model.KEY_DELTA);
                       tempData.delta.setConfirmed(deltaObj.getInt(Model.KEY_CONFIRMED));
                       tempData.delta.setDeceased(deltaObj.getInt(Model.KEY_DECEASED));
                       tempData.delta.setRecovered(deltaObj.getInt(Model.KEY_RECOVERED));

                       data.add(tempData);

                   }
               } catch (JSONException e) {
                   e.printStackTrace();
               }

           }
           recyclerView.setAdapter(new rcvAdapter(data));

       }, Throwable::printStackTrace);
        queue.add(request);

    }
}