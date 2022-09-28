package com.example.wenote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wenote.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
ActivityDataInsertBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding=ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String type=getIntent().getStringExtra("type");//for update
        if(type.equals("update")){
            setTitle("update");
            binding.titles.setText(getIntent().getStringExtra("title"));
            binding.descr.setText(getIntent().getStringExtra("desc"));
            int id=getIntent().getIntExtra("id",0);
            binding.button.setText("Update Task");
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.titles.getText().toString());
                    intent.putExtra("descr", binding.descr.getText().toString());
                    intent.putExtra("id",id);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
        else {
            setTitle("Add Note");
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.titles.getText().toString());
                    intent.putExtra("descr", binding.descr.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this,MainActivity.class));
    }
}