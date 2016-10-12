package com.josue.calculator;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ScientistFragment extends Fragment {
    public Context context;
    private ProgressDialog dialog;
    private Button btnSIN,btnCOS,btnTAN,btnXp2,btnSINm1,btnCOSm1,btnTANm1,btnXp3,btnEpX,btn10pX,btn1DivX,btnXpY,btnLN,btnLOG,btnSQRL,btnPlusMinus;
    //Interface via which we communicate to hosting Activity
    private ActivityCommunicator activityCommunicator;
    private String activityAssignedValue ="";
    private static final String STRING_VALUE ="stringValue";
    //As per Android Fragment documentation an empty constructor
    public ScientistFragment(){
    }
    //Since Fragment is Activity dependent we need Activity context in various cases
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        context = getActivity();
        activityCommunicator =(ActivityCommunicator)context;
    }
    //Now on the entire fragment I use context rather than getActivity()
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null)
            activityAssignedValue = savedInstanceState.getString(STRING_VALUE);
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STRING_VALUE,activityAssignedValue);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
    public void init() {
        dialog = new ProgressDialog(context);
        dialog.setCancelable(true);
        //Communicating to activity via ActivityCommunicator interface

        View.OnClickListener myClickButtonListener= new View.OnClickListener() {
            public void onClick(View v) {
                String tag = (String) v.getTag();
                activityCommunicator.passDataToActivity(tag);
            }
        };
        btnSIN.setOnClickListener(myClickButtonListener);
        btnCOS.setOnClickListener(myClickButtonListener);
        btnTAN.setOnClickListener(myClickButtonListener);
        btnXp2.setOnClickListener(myClickButtonListener);
        btnSINm1.setOnClickListener(myClickButtonListener);
        btnCOSm1.setOnClickListener(myClickButtonListener);
        btnTANm1.setOnClickListener(myClickButtonListener);
        btnXp3.setOnClickListener(myClickButtonListener);
        btnEpX.setOnClickListener(myClickButtonListener);
        btn10pX.setOnClickListener(myClickButtonListener);
        btn1DivX.setOnClickListener(myClickButtonListener);
        btnXpY.setOnClickListener(myClickButtonListener);
        btnLN.setOnClickListener(myClickButtonListener);
        btnLOG.setOnClickListener(myClickButtonListener);
        btnSQRL.setOnClickListener(myClickButtonListener);
        btnPlusMinus.setOnClickListener(myClickButtonListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scientist,
                container, false);

        btnSIN = (Button) view.findViewById(R.id.btnSIN);
        btnCOS = (Button) view.findViewById(R.id.btnCOS);
        btnTAN = (Button) view.findViewById(R.id.btnTAN);
        btnXp2 = (Button) view.findViewById(R.id.btnXp2);
        btnSINm1 = (Button) view.findViewById(R.id.btnSINm1);
        btnCOSm1 = (Button) view.findViewById(R.id.btnCOSm1);
        btnTANm1 = (Button) view.findViewById(R.id.btnTANm1);
        btnXp3 = (Button) view.findViewById(R.id.btnXp3);
        btnEpX = (Button) view.findViewById(R.id.btnEpX);
        btn10pX = (Button) view.findViewById(R.id.btn10pX);
        btn1DivX = (Button) view.findViewById(R.id.btn1DivX);
        btnXpY = (Button) view.findViewById(R.id.btnXpY);
        btnLN = (Button) view.findViewById(R.id.btnLN);
        btnLOG = (Button) view.findViewById(R.id.btnLOG);
        btnSQRL = (Button) view.findViewById(R.id.btnSQRL);
        btnPlusMinus = (Button) view.findViewById(R.id.btnPlusMinus);

        btnSIN.setTag("sin");
        btnCOS.setTag("cos");
        btnTAN.setTag("tan");
        btnXp2.setTag("x2");
        btnSINm1.setTag("sin-1");
        btnCOSm1.setTag("cos-1");
        btnTANm1.setTag("tan-1");
        btnXp3.setTag("x3");
        btnEpX.setTag("E^X");
        btn10pX.setTag("10^X");
        btn1DivX.setTag("1/X");
        btnXpY.setTag("X^Y");
        btnLN.setTag("ln");
        btnLOG.setTag("log");
        btnSQRL.setTag("sqrl");
        btnPlusMinus.setTag("+/-");

        setRetainInstance(true);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
    }
}
