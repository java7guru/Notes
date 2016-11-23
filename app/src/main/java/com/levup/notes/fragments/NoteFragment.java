package com.levup.notes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.levup.notes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by java on 23.11.2016.
 */

public class NoteFragment extends Fragment {

    @BindView(R.id.titleEditText)
    protected EditText mTitleEditText;
    @BindView(R.id.contentEditText)
    protected EditText mContentEditText;

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(
                R.layout.fragment_note,
                container,
                false);
        ButterKnife.bind(this, view);
        return view;
    }
}
