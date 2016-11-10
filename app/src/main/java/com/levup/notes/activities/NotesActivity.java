package com.levup.notes.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.levup.notes.R;
import com.levup.notes.adapters.NotesAdapter;
import com.levup.notes.model.Note;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotesActivity extends AppCompatActivity {

    @BindView(R.id.notes_recycler_view)
    protected RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        NotesAdapter adapter = new NotesAdapter();
        List<Note> dataSource = new ArrayList<>();
        for(int i = 0; i < 100; i ++) {
            Note note = new Note();
            note.setTitle("title: " + i);
            note.setText("text: " + i);
            note.setTime(System.currentTimeMillis());
            dataSource.add(note);
        }
        recyclerView.setAdapter(adapter);
        adapter.setDataSource(dataSource);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_menu, menu);
        return true;
    }

    @OnClick(R.id.fab_button)
    public void onFabBtnClick() {
        startActivity(EditNoteActivity.newInstance(this));
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Snackbar.make(recyclerView, R.string.settings, Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.action_help:
                Snackbar.make(
                        recyclerView,
                        R.string.help,
                        Snackbar.LENGTH_LONG)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
