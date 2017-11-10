package com.liji.as.pictureselect.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liji.as.pictureselect.R;
import com.liji.takephoto.TakePhoto;

import java.io.File;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        Button btn = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TakePhoto takePhoto = new TakePhoto(Main2Activity.this);
                takePhoto.setOnPictureSelected(new TakePhoto.onPictureSelected() {
                    @Override
                    public void select(String path, String compresspath) {
                        showInfo(path, compresspath);
                    }
                });
                takePhoto.show();
            }
        });
    }
    
    private void showInfo(String path, String compresspath) {
        
        StringBuffer sb = new StringBuffer();
        sb.append("原始大小：" + new File(path).length() / 1024 + " k");
        sb.append("\n");
        sb.append("现在大小：" + new File(compresspath).length() / 1024 + " k");
        
        sb.append("原始路径：" + path);
        sb.append("\n");
        sb.append("现在路径：" + compresspath);
        
        textView.setText(sb.toString());
    }
}
