package sg.edu.rp.c346.id20018354.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement,etIndexElement;
    Button btnAdd;
    ListView lvColour;
    ArrayList<String>alColours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement=findViewById(R.id.editTextColour);
        btnAdd=findViewById(R.id.buttonAddItem);
        lvColour=findViewById(R.id.listViewColour);
        etIndexElement=findViewById(R.id.editTextIndex);

        alColours =new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter<String>aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor=etElement.getText().toString();
                int pos=Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos,newColor);
                aaColour.notifyDataSetChanged();
            }
        });
    }
}