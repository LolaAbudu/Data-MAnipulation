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
                "      \"type\": \"primary\",\n" +
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

       // Log.d("Testing out JSON size", "onCreate" + JSONString.length());

        List<Color> colorList = new ArrayList<>();
        try{
            JSONObject toParseObject = new JSONObject(JSONString);
            JSONArray toParseArray = toParseObject.getJSONArray("colors");

            Log.d("JSON Object", "onCreate" + toParseArray.getJSONObject(5));
            for(int i = 0; i < toParseArray.length(); i++){
                Color color = new Color();
                color.setColor((String)toParseArray.getJSONObject(i).get("color"));
                color.setCategory((String)toParseArray.getJSONObject(i).get("category"));
                color.setType((String)toParseArray.getJSONObject(i).get("type"));


                JSONObject codeObject = toParseArray.getJSONObject(i).getJSONObject("code");
                CodeRgbaHex codeRgbaHex = new CodeRgbaHex();
                codeRgbaHex.setHex(codeObject.getString("hex"));
                //Log.d("hex color", "onCreate" + codeRgbaHex.getHex());
                //Log.d("rgba color", "onCreate" + codeRgbaHex.getRgba());
                //Log.d("color category ", "onCreate" + color.getCategory());
                //Log.d("color type", "onCreate" + color.getType());

                codeRgbaHex.setRgba(new int[4]);

                JSONArray rgbaArray = codeObject.getJSONArray("rgba");

                for (int j = 0; j < rgbaArray.length(); j++) {

                    int [] thisArray = codeRgbaHex.getRgba();
                    thisArray[j] = rgbaArray.getInt(j);

//                    rgbaArray.getInt(j);
//                    codeRgbaHex.setRgba(thisArray);
                    // Log.d("rgba color after", "onCreate" + codeRgbaHex.getRgba());
                    //Log.d("rgba color length", "onCreate" + codeRgbaHex.getRgba().length);
                }

                Log.d("rgba color after2", "onCreate" + codeRgbaHex.getRgba());
                color.setCode(codeRgbaHex);
                colorList.add(color);

                //Log.d("rgba color after", "onCreate" + codeRgbaHex.getRgba());
                //Log.d("Testing out color", "onCreate" + colorList.size());
            }
//            Log.d("hex color 2", "onCreate" + colorList.get(1));
//            Log.d("color category 2", "onCreate" + colorList.get(2));
//            Log.d("color type 2", "onCreate" + colorList.get(0));
//
//            Log.d("Testing out color2", "onCreate" + colorList.size());
        }catch(JSONException e){
            e.printStackTrace();
        }


        ColorAdapter colorAdapter = new ColorAdapter(colorList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        colorRecyclerView.setAdapter(colorAdapter);
        colorRecyclerView.setLayoutManager(linearLayoutManager);

        //Log.d("Testing colorAdapter", "onCreate" + colorAdapter.toString());
    }
}
