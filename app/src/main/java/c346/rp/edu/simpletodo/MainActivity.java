package c346.rp.edu.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTODO;
    Button btnAdd;
    Button btnDel;
    Button btnClear;
    ListView lv;
    ArrayList<String> al;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTODO = findViewById(R.id.EditText);
        btnAdd = findViewById(R.id.buttonAdd);
        btnDel = findViewById(R.id.buttonDel);
        btnClear = findViewById(R.id.buttonClear);
        lv = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);

        al = new ArrayList<String>();

        final ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newChoice = etTODO.getText().toString();
                al.add(newChoice);
                aa.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al.clear();
                aa.notifyDataSetChanged();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice = etTODO.getText().toString();
                int index = Integer.parseInt(choice);
                al.remove(index);
                aa.notifyDataSetChanged();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItemPosition() == 0){

                    etTODO.setHint("Type in a new task here");
                    btnDel.setEnabled(false);
                    btnClear.setEnabled(false);

                }
                else{

                    etTODO.setHint("Type in the index of the task to be removed");
                    btnClear.setEnabled(false);
                    btnAdd.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
