package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingBrightActivty extends AppCompatActivity
{
    TextView textview1, textview2;
    SeekBar seekbar;
    Button btncomplete;
    int seekbar_number = 255;

    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bright);

        textview1 = findViewById(R.id.textView);
        textview2 = findViewById(R.id.textView2);
        seekbar = findViewById(R.id.seekBar);
        btncomplete = findViewById(R.id.btnComplete);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //seekbar_number = seekbar.getProgress();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                //seekbar_number = seekbar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                seekbar_number = seekbar.getProgress();
                update();
            }
        });
        complete_seekbar();
    }

    public void complete_seekbar()
    {
        btncomplete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent bringt_outintent = new Intent();
                bringt_outintent.putExtra("brightNum", seekbar_number);
                setResult(RESULT_OK,bringt_outintent);
                finish();
            }
        });
    }

    public void update()
    {
        textview2.setText(new StringBuilder().append(seekbar_number));
    }
}
