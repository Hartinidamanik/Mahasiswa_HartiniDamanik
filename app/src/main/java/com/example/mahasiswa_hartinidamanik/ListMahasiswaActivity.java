package com.example.mahasiswa_hartinidamanik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import com.example.mahasiswa_hartinidamanik.adapter.MahasiswaAdapter;
import com.example.mahasiswa_hartinidamanik.db.DbHelper;
import com.example.mahasiswa_hartinidamanik.model.Mahasiswa;

import java.util.ArrayList;
public class ListMahasiswaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> studentsArrayList;
    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);
        recyclerView = (RecyclerView) findViewById(R.id.rview);
        adapter = new MahasiswaAdapter(this);
        dbHelper = new DbHelper(this);
        studentsArrayList = dbHelper.getAllUsers();
        adapter.setListStudents(studentsArrayList);
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(ListMahasiswaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        studentsArrayList = dbHelper.getAllUsers();
        adapter.setListStudents(studentsArrayList);
        adapter.notifyDataSetChanged();
    }
}