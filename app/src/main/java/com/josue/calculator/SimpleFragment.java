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


public class SimpleFragment extends Fragment {
    public Context context;
    private ProgressDialog dialog;
    private Button btnDiv,btnMult,btnAdd,btnSub,btnComma,btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine;
    //Interface via which we communicate to hosting Activity
    private ActivityCommunicator activityCommunicator;
    private String activityAssignedValue ="";
    private static final String STRING_VALUE ="stringValue";
    //As per Android Fragment documentation an empty constructor
    public SimpleFragment(){
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
        btnDiv.setOnClickListener(myClickButtonListener);
        btnMult.setOnClickListener(myClickButtonListener);
        btnAdd.setOnClickListener(myClickButtonListener);
        btnSub.setOnClickListener(myClickButtonListener);
        btnComma.setOnClickListener(myClickButtonListener);
        btnZero.setOnClickListener(myClickButtonListener);
        btnOne.setOnClickListener(myClickButtonListener);
        btnTwo.setOnClickListener(myClickButtonListener);
        btnThree.setOnClickListener(myClickButtonListener);
        btnFour.setOnClickListener(myClickButtonListener);
        btnFive.setOnClickListener(myClickButtonListener);
        btnSix.setOnClickListener(myClickButtonListener);
        btnSeven.setOnClickListener(myClickButtonListener);
        btnEight.setOnClickListener(myClickButtonListener);
        btnNine.setOnClickListener(myClickButtonListener);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple,
                container, false);

        btnDiv = (Button) view.findViewById(R.id.btnDiv);
        btnMult = (Button) view.findViewById(R.id.btnMult);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        btnSub = (Button) view.findViewById(R.id.btnSub);
        btnComma = (Button) view.findViewById(R.id.btnComma);
        btnZero = (Button) view.findViewById(R.id.btnZero);
        btnOne = (Button) view.findViewById(R.id.btnOne);
        btnTwo = (Button) view.findViewById(R.id.btnTwo);
        btnThree = (Button) view.findViewById(R.id.btnThree);
        btnFour = (Button) view.findViewById(R.id.btnFour);
        btnFive = (Button) view.findViewById(R.id.btnFive);
        btnSix = (Button) view.findViewById(R.id.btnSix);
        btnSeven = (Button) view.findViewById(R.id.btnSeven);
        btnEight = (Button) view.findViewById(R.id.btnEight);
        btnNine = (Button) view.findViewById(R.id.btnNine);

        btnDiv.setTag("/");
        btnMult.setTag("*");
        btnAdd.setTag("+");
        btnSub.setTag("-");
        btnComma.setTag(".");

        btnZero.setTag("0");
        btnOne.setTag("1");
        btnTwo.setTag("2");
        btnThree.setTag("3");
        btnFour.setTag("4");
        btnFive.setTag("5");
        btnSix.setTag("6");
        btnSeven.setTag("7");
        btnEight.setTag("8");
        btnNine.setTag("9");

        setRetainInstance(true);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
    }
}