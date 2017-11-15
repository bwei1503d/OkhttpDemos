package muhanxi.okhttpdemos;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import muhanxi.okhttpdemos.okhttp.AbstractUiCallBack;
import muhanxi.okhttpdemos.okhttp.OkhttpUtils;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static muhanxi.okhttpdemos.SDCardUtils.copyStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        get();



//      Type type =    MainActivity.class.getGenericSuperclass() ;



//        test();


//        findViewById(R.id.xiangce).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                toPhoto();
//            }
//        });
//
//
//
//        findViewById(R.id.xiangce).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                toCamera();
//
//            }
//        });



        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
        Request request = new Request.Builder()
                .url("http://120.27.23.105/product/searchProducts?keywords=笔记本&page=1")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                System.out.println("e = " + e);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String result = response.body().string() ;

                System.out.println("result = " + result);

            }
        });




    }



    private void test(){


        Map<String,String> map = new HashMap();
        String url = "http://qhb.2dyt.com/Bwei/news" ;
        map.put("type","7");
        map.put("postkey","109rff1d1AK");


//        OkhttpUtils.asy(map, url, new AbstractUiCallBack<Bean>() {
//
//            @Override
//            public void success(Bean bean) {
//
//                Toast.makeText(MainActivity.this,bean.toString(),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void failure(Exception e) {
//
//            }
//        });



        OkhttpUtils.getInstance().asy(map, url, new AbstractUiCallBack<Bean>() {
            @Override
            public void success(Bean o) {

            }

            @Override
            public void failure(Exception e) {

            }
        });



    }




    private void postFile(){

        String url = "https://www.zhaoapi.cn/file/upload" ;

        Map<String,String> map = new HashMap<>();
        map.put("uid","100");

//        OkhttpUtils.postFile(map,url,new AbstractUiCallBack<>());

    }


    static final int INTENTFORCAMERA = 1 ;
    static final int INTENTFORPHOTO = 2 ;

    /**
     * 打开相册
     */
    public void toPhoto(){
        try {
            createLocalPhotoName();
            Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
            getAlbum.setType("image/*");
            startActivityForResult(getAlbum, INTENTFORPHOTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *  打开相机
     */
    public void toCamera(){
        try {
            Intent intentNow = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            Uri uri = Uri.fromFile(SDCardUtils.getMyFaceFile(createLocalPhotoName())) ;
            intentNow.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intentNow, INTENTFORCAMERA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String LocalPhotoName;
    public String createLocalPhotoName() {
        LocalPhotoName = System.currentTimeMillis() + "face.jpg";
        return  LocalPhotoName ;
    }







    public void get(){



            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {




                    OkHttpClient client = new OkHttpClient.Builder()
//                            .addInterceptor(new LoggingInterceptor())
                            .addNetworkInterceptor(new LoggingInterceptor())
                            .build();


                    Request request = new Request.Builder()
                            .url("https://publicobject.com/helloworld.txt")
                            .build();


                    Call call =  client.newCall(request) ;


                    Response response =  call.execute() ;

                    if(response.isSuccessful()){


                        System.out.println("response = " + response.body().string());

                    }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();





    }


    private void post(){
        try {
            OkHttpClient client = new OkHttpClient();
            String s = Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;

            Request request = new Request.Builder()
                    .url("http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0")
                    .addHeader("User-Agent",""+s)
                    .build();


            Call call =  client.newCall(request) ;


            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                    System.out.println("e = " + e);

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    System.out.println("response.body().string() = " + response.body().string());
                    
                    
                }
            });

            
            
        } catch (Exception e) {
            e.printStackTrace();
        }




    }





    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");
    private void postString(){


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client = new OkHttpClient();

                    String postBody = ""
                            + "Releases\n"
                            + "--------\n"
                            + "\n"
                            + " * _1.0_ May 6, 2013\n"
                            + " * _1.1_ June 15, 2013\n"
                            + " * _1.2_ August 11, 2013\n";

                    Request request = new Request.Builder()
                            .url("https://api.github.com/markdown/raw")
                            .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
                            .build();

                    Response response = client.newCall(request).execute();

                    if (response.isSuccessful()){


                        System.out.println(response.body().string());

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }






    private void from(){

        //表单 post 请求 携带参数
        RequestBody requestBody = new FormBody.Builder()
                .add("search", "Jurassic Park")
                .build();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://en.wikipedia.org/w/index.php").post(requestBody).build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });


    }
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");


    private void multipartBody(){


        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key","value")
                .addFormDataPart("key","filename",RequestBody.create(MEDIA_TYPE_PNG,new File("")))
                .build();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.imgur.com/3/image")
                .post(requestBody)
                .build();

        Call call =  client.newCall(request) ;
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });


//        call.cancel();

    }





    public void cache(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Cache cache = new Cache(getCacheDir(),10*1024*1024);


                    OkHttpClient client = new OkHttpClient.Builder()
                            .cache(cache)
                            .build();

                    Request request = new Request.Builder()
                            .url("http://publicobject.com/helloworld.txt")
                            .cacheControl(CacheControl.FORCE_NETWORK)
                            .build();

                    Response response1 = client.newCall(request).execute();

                    String response1Body = response1.body().string();

                    System.out.println("Response 1 response:          " + response1);
                    System.out.println("Response 1 cache response:    " + response1.cacheResponse());
                    System.out.println("Response 1 network response:  " + response1.networkResponse());


                    Response response2 = client.newCall(request).execute();
                    String response2Body = response2.body().string();

                    System.out.println("Response 2 response:          " + response2);
                    System.out.println("Response 2 cache response:    " + response2.cacheResponse());
                    System.out.println("Response 2 network response:  " + response2.networkResponse());




                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    OkHttpClient client = new OkHttpClient();


    public void perCall(){


        Request request = new Request.Builder().url("")
                .build();


        OkHttpClient okHttpClient1 =   client.newBuilder().writeTimeout(10, TimeUnit.SECONDS).build();


        OkHttpClient okHttpClient2 =   client.newBuilder().writeTimeout(20, TimeUnit.SECONDS).build();



    }

    int width;
    int height ;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case INTENTFORPHOTO:
                //相册

                try {
                    // 必须这样处理，不然在4.4.2手机上会出问题
                    Uri originalUri = data.getData();
                    File f = null;
                    if (originalUri != null) {
                        f = new File(SDCardUtils.photoCacheDir, LocalPhotoName);
                        String[] proj = {MediaStore.Images.Media.DATA};
                        Cursor actualimagecursor =  this.getContentResolver().query(originalUri, proj, null, null, null);
                        if (null == actualimagecursor) {
                            if (originalUri.toString().startsWith("file:")) {
                                File file = new File(originalUri.toString().substring(7, originalUri.toString().length()));
                                if(!file.exists()){
                                    //地址包含中文编码的地址做utf-8编码
                                    originalUri = Uri.parse(URLDecoder.decode(originalUri.toString(),"UTF-8"));
                                    file = new File(originalUri.toString().substring(7, originalUri.toString().length()));
                                }
                                FileInputStream inputStream = new FileInputStream(file);
                                FileOutputStream outputStream = new FileOutputStream(f);
                                copyStream(inputStream, outputStream);
                            }
                        } else {
                            // 系统图库
                            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                            actualimagecursor.moveToFirst();
                            String img_path = actualimagecursor.getString(actual_image_column_index);
                            if (img_path == null) {
                                InputStream inputStream = this.getContentResolver().openInputStream(originalUri);
                                FileOutputStream outputStream = new FileOutputStream(f);
                                copyStream(inputStream, outputStream);
                            } else {
                                File file = new File(img_path);
                                FileInputStream inputStream = new FileInputStream(file);
                                FileOutputStream outputStream = new FileOutputStream(f);
                                copyStream(inputStream, outputStream);
                            }

                        }
                        Bitmap bitmap = ImageResizeUtils.resizeImage(f.getAbsolutePath(),720);
                        width = bitmap.getWidth();
                        height = bitmap.getHeight();
                        FileOutputStream fos = new FileOutputStream(f.getAbsolutePath());
                        if (bitmap != null) {
                            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fos)) {
                                fos.close();
                                fos.flush();
                            }
                            if (!bitmap.isRecycled()) {
                                bitmap.isRecycled();
                            }

//                            uploadFile(f);

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }


                break;
            case INTENTFORCAMERA:
//                相机
                try {

                    //file 就是拍照完 得到的原始照片
                    File file = new File(SDCardUtils.photoCacheDir, LocalPhotoName);
                    Bitmap bitmap = ImageResizeUtils.resizeImage(file.getAbsolutePath(), 720);
                    width = bitmap.getWidth();
                    height = bitmap.getHeight();
                    FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
                    if (bitmap != null) {
                        if (bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fos)) {
                            fos.close();
                            fos.flush();
                        }
                        if (!bitmap.isRecycled()) {
                            //通知系统 回收bitmap
                            bitmap.isRecycled();
                        }
                        uploadFile(file);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }



                break;
        }


    }


    private void uploadFile(File file){
        String url = "http://qhb.2dyt.com/Bwei/upload" ;

//        String url = "https://www.zhaoapi.cn/file/upload";

        Map<String,String> map = new HashMap<>();
        map.put("uid","100");


        OkhttpUtils.postFile(map,url,file,new AbstractUiCallBack<UploadBean>(){
            @Override
            public void success(UploadBean bean) {

                Toast.makeText(MainActivity.this,"upload success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(Exception e) {

            }
        });


    }

}
