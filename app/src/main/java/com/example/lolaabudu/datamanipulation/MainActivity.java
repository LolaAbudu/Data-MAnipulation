package com.example.lolaabudu.datamanipulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView colorRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorRecyclerView = findViewById(R.id.color_recyclerView);

        String JSONString = "{\n" +
                "  \"colors\": [\n" +
                "    {\n" +
                "      \"color\": \"black\",\n" +
                "      \"category\": \"hue\",\n" +
                "      \"type\": \"primary\",\n" +
                "      \"code\": {\n" +
                "        \"rgba\": [255,255,255,1],\n" +
                "        \"hex\": \"#000\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"color\": \"white\",\n" +
                "      \"category\": \"value\",\n" +
                "      \"code\": {\n" +
                "        \"rgba\": [0,0,0,1],\n" +
                "        \"hex\": \"#FFF\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"color\": \"red\",\n" +
                "      \"category\": \"hue\",\n" +
                "      \"type\": \"primary\",\n" +
                "      \"code\": {\n" +
                "        \"rgba\": [255,0,0,1],\n" +
                "        \"hex\": \"#FF0\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"color\": \"blue\",\n" +
                "      \"category\": \"hue\",\n" +
                "      \"type\": \"primary\",\n" +
                "      \"code\": {\n" +
                "        \"rgba\": [0,0,255,1],\n" +
                "        \"hex\": \"#00F\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"color\": \"yellow\",\n" +
                "      \"category\": \"hue\",\n" +
                "      \"type\": \"primary\",\n" +
                "      \"code\": {\n" +
                "        \"rgba\": [255,255,0,1],\n" +
                "        \"hex\": \"#FF0\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"color\": \"green\",\n" +
                "      \"category\": \"hue\",\n" +
                "      \"type\": \"secondary\",\n" +
                "      \"code\": {\n" +
                "        \"rgba\": [0,255,0,1],\n" +
                "        \"hex\": \"#0F0\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Log.d("Testing it out", "onCreate" + JSONString);

        List<Color> colorList = new ArrayList<>();
        try{
            JSONObject toParseObject = new JSONObject(JSONString);
            JSONArray toParseArray = toParseObject.getJSONArray("colors");

            for(int i = 0; i < toParseArray.length(); i++){
                Color color = new Color();
                color.setColor((String)toParseArray.getJSONObject(i).get("color"));
                color.setCategory((String)toParseArray.getJSONObject(i).get("category"));
                color.setType((String)toParseArray.getJSONObject(i).get("type"));

                JSONObject codeObject = toParseArray.getJSONObject(i).getJSONObject("code");
                CodeRgbaHex codeRgbaHex = new CodeRgbaHex();
                codeRgbaHex.setHex(codeObject.getString("hex"));
                codeRgbaHex.setRgba(new int[4]);

                JSONArray rgbaArray = codeObject.getJSONArray("rgba");

                for (int j = 0; j < rgbaArray.length(); j++) {
                    int [] thisArray = codeRgbaHex.getRgba();
                    thisArray[j] = rgbaArray.getInt(j);
                }
                color.setCode(codeRgbaHex);
                colorList.add(color);
                Log.d("Testing out color", "onCreate" + colorList);
            }
        }catch(JSONException e){
            e.printStackTrace();
        }


        ColorAdapter colorAdapter = new ColorAdapter(colorList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        colorRecyclerView.setAdapter(colorAdapter);
        colorRecyclerView.setLayoutManager(linearLayoutManager);

        Log.d("Testing colorAdapter", "onCreate" + colorAdapter);
    }
}
