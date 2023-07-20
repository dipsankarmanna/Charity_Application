package com.example.sudip_new_project.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sudip_new_project.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((Button)view.findViewById(R.id.participate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // setup the alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://khalidscancerresearchrun.co.uk"));
                startActivity(i);
            }
        });

        ((Button)view.findViewById(R.id.call)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7063464588"));
                startActivity(intent);
            }
        });

        ((Button)view.findViewById(R.id.donate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // setup the alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Donate to any one of the Following");

                // add a list
                String[] animals = {"Cancer Research UK", "British Great Foundation", "British Red Cross", "RSPCA"};
                builder.setItems(animals, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i;
                        String website = "http://khalidscancerresearchrun.co.uk";
                        switch (which) {
                            case 0:
                                website = "https://www.cancerresearchuk.org/support-us/donate";
                                break;
                            case 1:
                                website = "https://www.bhf.org.uk/get-involved/donate-form";
                                break;
                            case 2:
                                website = "https://www.redcross.org.uk/get-involved/donate";
                                break;
                            case 3:
                                website = "https://www.rspca.org.uk/getinvolved/donate/online/single?formId=178&force=true&source=18INT10019&donation=";
                                break;
                        }
                        i = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
                        startActivity(i);
                    }
                });

// create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        ((Button)view.findViewById(R.id.more_info)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle("5K Run");
                String Message = "5k run around Manchester is a charity event. This event is being conducted in order to generate funds for cancer research. This is a marathon which starts in picadily gardens and ends in trafford. This event will take place on 15th june 2018. Further information regarding this event can be gathered from our website http://khalidscancerresearchrun.co.uk";
                builder.setMessage(Message);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


}
