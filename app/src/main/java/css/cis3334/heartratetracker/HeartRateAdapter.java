package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.resource;

/**
 * Created by azenk on 2/17/2017.
 */

public class HeartRateAdapter extends ArrayAdapter<HeartRate> {

    private Context context;
    private HeartRateList heartRateList;


    //Default Constructor. Red Bulb.
    public HeartRateAdapter(Context context, int resource, int textViewResourceId, HeartRateList heartRateList) {
        super(context, resource, textViewResourceId, heartRateList.getList());

        this.context = context;
        this.heartRateList = heartRateList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.heart_rate_row,null);

        HeartRate hR = heartRateList.getHeartRate(position);


        //Create TextView variable to access pulseNumberTv from heart_rate_row.xml
        TextView tvPulse = (TextView)view.findViewById(R.id.pulseNumberTv);

        tvPulse.setText(hR.getPulse());
        return view;
    }
}
