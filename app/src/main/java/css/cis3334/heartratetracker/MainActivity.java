package css.cis3334.heartratetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    HeartRateList heartRateList;        // The list of heart rate objects
    TextView tvSelected;
    ListView lvHeartTracker;
    ArrayAdapter<HeartRate> hrAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelected = (TextView) findViewById(R.id.textViewSelect);
        lvHeartTracker = (ListView) findViewById(R.id.lvHeartRate);

        heartRateList = new HeartRateList();
        heartRateList.InitRandomYouth();
        //ArrayAdapter<HeartRate> planetAdapter = new ArrayAdapter<HeartRate>(this, android.R.layout.simple_list_item_1, basicheartRateList);
        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.pulseTV, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartTracker.setAdapter(hrAdapter);

        lvHeartTracker.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                HeartRate hr = (HeartRate) parent.getItemAtPosition(position);
                tvSelected.setText("You selected: " + hr.toString());
            }
        });

    }
}
