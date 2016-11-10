package com.levup.notes.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import com.levup.notes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditNoteActivity extends AppCompatActivity {

    @BindView(R.id.titleEditText)
    protected EditText mTitleEditText;
    @BindView(R.id.contentEditText)
    protected EditText mContentEditText;
    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    public static Intent newInstance(Context context) {
        return new Intent(context, EditNoteActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
