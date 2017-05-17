package com.example.song.songapplication.Activity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.song.songapplication.Interfaces.TaskComplatedListener;
import com.example.song.songapplication.R;
import com.example.song.songapplication.Thread.UpsellCollageInitTask;
import com.example.song.songapplication.widget.PicPickerDialog;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

import static com.example.song.songapplication.Utils.PermissionUitls.mContext;

public class ImageUploadActivity extends BaseActivity {
    @BindView(R.id.img_userInfo_photo)
    ImageView imgUserInfoPhoto;
    @BindView(R.id.btn_userInfo_next)
    Button btnUserInfoNext;
    @BindView(R.id.pbar_waiting)
    ProgressBar pbarWaiting;
    @BindView(R.id.uploadImageResult)
    TextView uploadImageResult;
    private GalleryFinal.OnHanlderResultCallback mOnHandle;
    private final int REQUEST_CODE_GALLERY = 1002;
    private final int REQUEST_CODE_CAMERA = 1003;
    private String selectImageUrl = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);
        ButterKnife.bind(this);
        setEvents();
    }

    private void setEvents() {
        imgUserInfoPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAvatarPickerDialog();
            }
        });

        btnUserInfoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbarWaiting.setVisibility(View.VISIBLE);
                TaskComplatedListener listener = new TaskComplatedListener() {
                    @Override
                    public void onCompleted(Object result) {
                        uploadImageResult.setVisibility(View.VISIBLE);
                        pbarWaiting.setVisibility(View.INVISIBLE);
                    }
                };
                UpsellCollageInitTask upsellCollageGroupTask = new UpsellCollageInitTask(mContext, selectImageUrl, listener);
                upsellCollageGroupTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });
    }

    private void showAvatarPickerDialog() {
        mOnHandle = new GalleryFinal.OnHanlderResultCallback() {
            @Override
            public void onHanlderSuccess(final int reqeustCode, final List<PhotoInfo> resultList) {
                if (resultList != null) {
                    selectImageUrl = resultList.get(0).getPhotoPath();
                    switch (reqeustCode) {
                        case REQUEST_CODE_GALLERY:
                        case REQUEST_CODE_CAMERA:
                            ImageLoader.getInstance().displayImage("file://" + selectImageUrl, imgUserInfoPhoto);
                            break;
                    }
                }
            }

            @Override
            public void onHanlderFailure(int requestCode, String errorMsg) {
//      Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        };
        PicPickerDialog dialog = new PicPickerDialog();
        dialog.setOnClickListener(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FunctionConfig functionConfig = new FunctionConfig.Builder()
                        .setEnableCamera(true)
                        .setEnableEdit(true)
                        .setCropSquare(true)
                        .setEnableCrop(true)
                        .setForceCrop(true).build();
                switch (which) {
                    case 0:
                        GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, functionConfig, mOnHandle);
                        break;
                    case 1:
                        GalleryFinal.openCamera(REQUEST_CODE_CAMERA, functionConfig, mOnHandle);
                        break;
                }
            }
        });
        dialog.show(getFragmentManager(), "child_info");
    }
}
