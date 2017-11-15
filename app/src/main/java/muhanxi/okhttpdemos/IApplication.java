package muhanxi.okhttpdemos;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by muhanxi on 17/11/10.
 */

public class IApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

    }
}
