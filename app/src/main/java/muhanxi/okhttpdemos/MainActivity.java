package muhanxi.okhttpdemos;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

import static android.os.Build.VERSION_CODES.O;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get();





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

}
