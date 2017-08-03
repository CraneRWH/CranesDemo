package com.crane.cranesdemoa.activity.gong;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.crane.cranesdemoa.R;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class RegistrationXiuActivity extends AppCompatActivity {

    private static final int PHOTO_REQUEST_CAMERA = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果

    private Bitmap bitmap;
    private final static int FILE_CHOOSER_RESULT_CODE = 10000;
    private static final String PHOTO_FILE_NAME = "head_picture.jpg";
    private File pictureFile;

    private ImageView picImageView;

    private ImageView backView;
    private TextView titleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_xiu);

        backView = (ImageView) findViewById(R.id.headLeftImage);
        titleView = (TextView) findViewById(R.id.headTitle);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        titleView.setText("报修登记");

        picImageView = (ImageView) findViewById(R.id.imageView);
        picImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGetPictureSelect();
            }
        });
    }

    private void showGetPictureSelect() {
        new AlertDialog.Builder(this).setItems(new String[]{"拍一张照片","从相册中获取"}, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int position) {
                try {
                    if(position == 0) {
                        getPictureFromCamera();
                    }
                    else {
                        getPictureFromPhone();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).create().show();
    }

    private void getPictureFromPhone() throws Exception {
        // 激活系统图库，选择一张图片
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }

    private void getPictureFromCamera() throws Exception {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment
                            .getExternalStorageDirectory(), PHOTO_FILE_NAME)));
        }
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }

    /**
     * 剪切图片
     * @param uri
     */
    private void cropPicture(Uri uri) throws Exception {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        // 图片格式
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);// true:不返回uri，false：返回uri
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            if (data != null) {
                // 得到图片的全路径
                try {
                    Uri uri = data.getData();
                    cropPicture(uri);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

        } else if (requestCode == PHOTO_REQUEST_CAMERA) {
            if (hasSdcard()) {
                try {
                    pictureFile = new File(Environment.getExternalStorageDirectory(),
                            PHOTO_FILE_NAME);
                    cropPicture(Uri.fromFile(pictureFile));
                } catch (Exception e) {

                }
            } else {
               Toast.makeText(this, "未找到存储卡，无法存储照片",Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == PHOTO_REQUEST_CUT) {
            try {
                bitmap = data.getParcelableExtra("data");
                this.picImageView.setImageBitmap(bitmap);
                boolean delete = pictureFile.delete();
                System.out.println("delete = " + delete);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 判断存储卡是否可以用，可用进行存储
     * @return
     */
    private boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
}
