package sg.edu.rp.c346.id20018354.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement,etIndexElement;
    Button btnAdd,btnRemove,btnUpdate;
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
        btnRemove=findViewById(R.id.buttonRemove);
        btnUpdate=findViewById(R.id.buttonUpdate);

        alColours =new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter<String>aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor=etElement.getText().toString();
                int position=Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(position,newColor);
                aaColour.notifyDataSetChanged();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(position);
                lvColour.setAdapter(aaColour);
                aaColour.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputColour = etElement.getText().toString();
                int position = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(position, inputColour);
                lvColour.setAdapter(aaColour);
                aaColour.notifyDataSetChanged();
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                String message = String.format("You have selected %s", colour);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                etElement.setText(alColours.get(position));
                etIndexElement.setText(String.valueOf(position));
            }
        });    }
}