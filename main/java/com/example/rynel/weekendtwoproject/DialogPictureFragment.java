package com.example.rynel.weekendtwoproject;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogPictureFragment extends DialogFragment {

    private ImageView imageView;

    public DialogPictureFragment() {
        // Required empty public constructor
    }

    //Creating java object dpf from constructor to return string value
    public static DialogPictureFragment newInstance( String title ) {
        DialogPictureFragment dpf = new DialogPictureFragment();

        Bundle args = new Bundle();
        args.putString("title", title);
        dpf.setArguments(args);

        return dpf;
    }

    //default onCreate method
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_picture, container, false);
    }


    //onViewCreated for image view relations and new string object to retrieve from args.putString()
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //bind the views
        imageView = view.findViewById( R.id.ivDialogImage );

        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
    }


}


