package com.crane.cranesdemoa.fragment.xiu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crane.cranesdemoa.R;
import com.crane.cranesdemoa.activity.gong.RegistrationXiuActivity;
import com.crane.cranesdemoa.activity.gong.SchoolOutActivity;
import com.crane.cranesdemoa.activity.gong.SchoolStationActivity;
import com.crane.cranesdemoa.activity.gong.XinXIBuActivity;


public class MainXiuFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private TextView toolBar;

    public MainXiuFragment() {
        // Required empty public constructor
    }

    public static MainXiuFragment newInstance(String param1, String param2) {
        MainXiuFragment fragment = new MainXiuFragment();
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
        View view = inflater.inflate(R.layout.fragment_main_xiu, container, false);
        toolBar = (TextView) view.findViewById(R.id.headTitle);
        toolBar.setText("山东青年政治学院咻咻通");

        view.findViewById(R.id.headLeftImage).setVisibility(View.GONE);
        view.findViewById(R.id.diangongLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegistrationXiuActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.shuigongLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegistrationXiuActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.mugongLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegistrationXiuActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.wanggongLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wanggong();
            }
        });

        return view;
    }

    private void wanggong() {
        new AlertDialog.Builder(getContext()).setItems(new String[]{"信息技术部","校内维修点","校外维修点"}, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int position) {
                try {
                    Intent intent = new Intent();
                    if(position == 0) {
                        intent.setClass(getContext(), XinXIBuActivity.class);
                    }
                    else if (position == 1){
                        intent.setClass(getContext(), SchoolStationActivity.class);
                    } else {
                        intent.setClass(getContext(), SchoolOutActivity.class);
                    }
                    startActivity(intent);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).create().show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
   /*     if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
