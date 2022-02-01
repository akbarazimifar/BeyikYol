package com.geekspace.beyikyol.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

//import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import static android.content.Context.MODE_PRIVATE;

import com.geekspace.beyikyol.Activity.App.MainMenu;
import com.geekspace.beyikyol.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentC#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentC extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView skip;

    public FragmentC() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentC.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentC newInstance(String param1, String param2) {
        FragmentC fragment = new FragmentC();
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_c, container, false);
        skip=view.findViewById(R.id.skip);



        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = container.getContext().getSharedPreferences("Splash", MODE_PRIVATE).edit();
                editor.putString("isFistTime", "1");
                editor.apply();
                startActivity(new Intent(container.getContext(), MainMenu.class));
              //  Animatoo.animateInAndOut(container.getContext());
                ((Activity) container.getContext()).finish();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}