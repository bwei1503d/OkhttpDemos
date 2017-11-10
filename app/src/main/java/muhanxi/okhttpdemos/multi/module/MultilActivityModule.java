package muhanxi.okhttpdemos.multi.module;

import muhanxi.okhttpdemos.multi.MultiBean;
import muhanxi.okhttpdemos.okhttp.AbstractUiCallBack;
import muhanxi.okhttpdemos.okhttp.OkhttpUtils;

/**
 * Created by muhanxi on 17/11/10.
 */

public class MultilActivityModule {



    /**
     *
     * up true 上啦 false 下啦
     */
    public void onRefresh(boolean up, final ModuleCallBack callBack) {


        OkhttpUtils.getInstance().asy(null, "http://v.juhe.cn/toutiao/index?type=top&key=597b4f9dcb50e051fd725a9ec54d6653", new AbstractUiCallBack<MultiBean>() {
            @Override
            public void success(MultiBean bean) {

                callBack.success(bean);
            }

            @Override
            public void failure(Exception e) {

                callBack.failure(e);
            }
        });


    }


    public  interface ModuleCallBack {
        public void success(MultiBean bean);
        public void failure(Exception bean);

    }


}
