package com.example.utsav.beercheer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link aboutUsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link aboutUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class aboutUsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String[] address = {"BeerCheer@gmail.com"};
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public aboutUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment aboutUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static aboutUsFragment newInstance(String param1, String param2) {
        aboutUsFragment fragment = new aboutUsFragment();
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
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        //create the button for the emailintent
        Button emailButton = view.findViewById(R.id.emailButton);
        //create the button for the callintent
        Button callButton = view.findViewById(R.id.callButton);
        //create the button for the locationintent
        Button locationButton = view.findViewById(R.id.locationButton);

        //create the on clicklistener for the emailbutton
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create the intent
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                //set the data for the intent
                intent.setData(Uri.parse("mailto:"));
                //put the data inside the intent on launch
                intent.putExtra(Intent.EXTRA_EMAIL,address);

                //if statement to see if the phone has the correct software to manage this request
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getContext(), "You do not have the correct software",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        //create the on clicklistener for the callbutton
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create the intent
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //set the data for the intent
                intent.setData(Uri.parse("tel:5196779787"));
                //if statement to see if the phone has the correct software to manage this request
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getContext(),
                            "You do not have the correct software",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        //create the on clicklistener for the locationButton
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create the intent
                Uri location = Uri.parse("geo:0,0?q=42.248204,-83.019325(St clair college");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //set the data for the intent
                intent.setData(location);
                //if statement to see if the phone has the correct software to manage this request
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getContext(),
                            "You do not have the correct software",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
