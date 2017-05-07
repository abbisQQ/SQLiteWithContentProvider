package com.abbisqq.timemanager.fragments;


import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.abbisqq.timemanager.MainActivity;
import com.abbisqq.timemanager.R;
import com.abbisqq.timemanager.data.ContractTimeManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddTasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTasksFragment extends Fragment implements View.OnClickListener{

    EditText title, info;
    ImageButton okButton;

    public AddTasksFragment() {
        // Required empty public constructor
    }


    public static AddTasksFragment newInstance() {
        return new AddTasksFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_tasks, container, false);

        title = (EditText) view.findViewById(R.id.title_edit_text);
        info = (EditText) view.findViewById(R.id.info_edit_text);
        okButton = (ImageButton)view.findViewById(R.id.ok_button);
        okButton.setOnClickListener(this);

        return view;
    }


    public int hasText() {
        if (title.length() > 0 && info.length() > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public void onClick(View v) {

        String input1 = title.getText().toString();
        String input2 = info.getText().toString();

        if (input1.length() == 0) {
            return;
        }


        ContentValues contentValues = new ContentValues();
        // Put the task description and selected mPriority into the ContentValues
        contentValues.put(ContractTimeManager.TasksEntry.TITLE, input1);
        contentValues.put(ContractTimeManager.TasksEntry.INFO, input2);


        // Insert the content values via a ContentResolver
        Uri uri = getActivity().getContentResolver().insert(ContractTimeManager.TasksEntry.CONTENT_URI, contentValues);


        if(uri != null) {
            Toast.makeText(getContext(), uri.toString(), Toast.LENGTH_LONG).show();
        }

        // Finish activity (this returns back to MainActivity)

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new StaringFragment())
                .commit();
    }
}