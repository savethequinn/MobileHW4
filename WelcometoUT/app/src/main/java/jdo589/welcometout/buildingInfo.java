package jdo589.welcometout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class buildingInfo extends Fragment {
    Context thiscontext;
    TextView buildingName,buildingAddress, buildingInfo, buildingFact;
    ImageView buildingPic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v;
        v = inflater.inflate(R.layout.fragment_building_info, container, false);
        return v;
    }

}
