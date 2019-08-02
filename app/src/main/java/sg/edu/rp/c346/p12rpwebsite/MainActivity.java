package sg.edu.rp.c346.p12rpwebsite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnCategory,spnSubCategory;
    Button btnGo;
    ArrayList<String> alCategory;
    ArrayAdapter<String>aaCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnCategory = findViewById(R.id.spinner);
        spnSubCategory = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGO);

        alCategory = new ArrayList<>();
        aaCategory = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alCategory);
        spnSubCategory.setAdapter(aaCategory);

        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alCategory.clear();
                switch (position){

                    case 0:
                        String [] strCategory = getResources().getStringArray(R.array.subRP);
                        alCategory.addAll(Arrays.asList(strCategory));
                        spnSubCategory.setAdapter(aaCategory);
                        break;

                    case 1:
                        String [] strSubCategory = getResources().getStringArray(R.array.subClass);
                        alCategory.addAll(Arrays.asList(strSubCategory));
                        spnSubCategory.setAdapter(aaCategory);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (spnSubCategory.getSelectedItem().equals("Home Page")){
                    String url = "https://www.google.com/";
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }
                else if (spnSubCategory.getSelectedItem().equals("Student Life")){
                    String url = "https://www.rp.edu.sg/student-life";
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);

                }

                else if (spnSubCategory.getSelectedItem().equals("DMSD")) {
                    String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);

                }

                else if (spnSubCategory.getSelectedItem().equals("DIT")) {
                    String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);

                }
            }
        });


    }
}
