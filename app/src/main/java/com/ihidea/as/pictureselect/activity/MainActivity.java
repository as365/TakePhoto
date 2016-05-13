package com.ihidea.as.pictureselect.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baoyz.actionsheet.ActionSheet;
import com.ihidea.as.pictureselect.R;
import com.ihidea.as.pictureselect.adapter.PhotoRecyclerViewAdapter;
import com.ihidea.as.pictureselect.utils.XCallbackListener;

import java.util.ArrayList;
import java.util.List;

import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

public class MainActivity extends AppCompatActivity {
    
    RecyclerView mRecyclerAddPhoto;
    
    private final int REQUEST_CODE_CAMERA = 1000;
    
    private final int REQUEST_CODE_GALLERY = 1001;
    
    FunctionConfig functionConfig;
    
    private List<PhotoInfo> mPhotoList;
    
    PhotoRecyclerViewAdapter mPhotoRecyclerViewAdapter;
    
    private LinearLayoutManager mLayoutManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
    }
    
    private void initView() {
        
        mRecyclerAddPhoto = (RecyclerView) findViewById(R.id.my_recycler_addphoto);

        //配置功能
        functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
                .build();


        mPhotoList = new ArrayList<>();
        mPhotoRecyclerViewAdapter = new PhotoRecyclerViewAdapter(MainActivity.this, mPhotoList, new XCallbackListener() {
            @Override
            protected void callback(Object... obj) {
                int pos = Integer.parseInt(obj[0].toString());
            }
        });


        //设置水平布局
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerAddPhoto.setLayoutManager(mLayoutManager);
        mRecyclerAddPhoto.setAdapter(mPhotoRecyclerViewAdapter);


    }
    
    /**
     * 打开相机和相册功能
     */
    public void openChoiceDialog() {
        ActionSheet.createBuilder(MainActivity.this, getSupportFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles("打开相册", "拍照")
                .setCancelableOnTouchOutside(true)
                .setListener(new ActionSheet.ActionSheetListener() {
                    @Override
                    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {
                        
                    }
                    
                    @Override
                    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                        switch (index) {
                            case 0://相册
                                GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY,
                                        functionConfig,
                                        mOnHanlderResultCallback);
                                break;
                            
                            case 1://相机
                                GalleryFinal.openCamera(REQUEST_CODE_CAMERA, functionConfig, mOnHanlderResultCallback);
                                break;
                        }
                        
                    }
                })
                .show();
        
    }
    
    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, final List<PhotoInfo> resultList) {
            if (resultList != null) {
                mPhotoList.addAll(resultList);
                mPhotoRecyclerViewAdapter.notifyDataSetChanged();
            }
        }
        
        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {
        }
    };
    
}
