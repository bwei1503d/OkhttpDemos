package muhanxi.okhttpdemos.location;

import android.app.Activity;
import android.os.Bundle;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

import java.util.Map;

import muhanxi.okhttpdemos.R;

public class LocationActivity extends Activity {



    public AMapLocationClient client ;

//    public AMapLocationListener locationListener ;


    public AMapLocationClientOption option ;
    private MapView mMapView;
    AMap aMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

//        0a65e0aebab0f75908c42c1ee2ae3a59




//        startLocation();


        mMapView = (MapView) findViewById(R.id.mapview);

        mMapView.onCreate(savedInstanceState);

        //初始化地图控制器对象
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
    }


    private void startLocation(){

        client = new AMapLocationClient(getApplicationContext());

        client.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {

                if(aMapLocation.getErrorCode() == 0 ){
                    // 定位成功
                    if(aMapLocation != null){

                        double lat = aMapLocation.getLatitude() ;
                        double lng = aMapLocation.getLongitude();

                        System.out.println("lat = " + lat + "  " + lng);
                    }
                } else{
                    System.out.println("aMapLocation = " + aMapLocation.getErrorCode() + "   "+ aMapLocation.getErrorInfo());
                    client.stopLocation();
                }


            }
        });


        option = new AMapLocationClientOption();

        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

//        option.setOnceLocation(true);

//        option.setOnceLocationLatest(true);

        option.setNeedAddress(true);

        option.setHttpTimeOut(30000);

        option.setLocationCacheEnable(false);

        client.setLocationOption(option);

        client.startLocation();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


    }
}
