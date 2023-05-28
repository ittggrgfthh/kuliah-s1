package com.example.aplikasi_pesan_tiket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<TiketModel> tiketModelList = new ArrayList<>();

        try {
            // Read the JSON file into a string
            InputStream inputStream = getAssets().open("data.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            String jsonString = builder.toString();

            // Parse the JSON string into a JSONObject
            JSONObject jsonObject = new JSONObject(jsonString);

            // Get a value from the JSON object
            String name = jsonObject.getString("name");
            int price = jsonObject.getInt("price");
            String img = jsonObject.getString("img");

            JSONArray jsonArray = jsonObject.getJSONArray("type");
            List<String> typeList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++){
                typeList.add(jsonArray.getString(i));
            }

            TiketModel tiketModel = new TiketModel();
            tiketModel.setName(name);
            tiketModel.setPrice(price);
            tiketModel.setImg(img);
            tiketModel.setType(typeList);

            tiketModelList.add(tiketModel);

        } catch (JSONException | IOException e){
            e.printStackTrace();
        }
    }
}