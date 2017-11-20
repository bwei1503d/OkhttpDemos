package muhanxi.okhttpdemos.shop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import muhanxi.okhttpdemos.R;
import muhanxi.okhttpdemos.okhttp.AbstractUiCallBack;
import muhanxi.okhttpdemos.okhttp.OkhttpUtils;

import static muhanxi.okhttpdemos.shop.ShopActivity.convertStreamToString;

public class ExpandAdapterActivity extends Activity {


    private Map<String,List<ShopBean.OrderDataBean.CartlistBean>> map = new HashMap<>();
    private ExpandableListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_adapter);

        getData();
        listView = (ExpandableListView) findViewById(R.id.expandable_listview);

        listView.setGroupIndicator(null);

        ExpandAdapter adapter = new ExpandAdapter(this,map);

        listView.setAdapter(adapter);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });

        int groupCount = listView.getCount();
        for (int i=0; i<groupCount; i++) {
            listView.expandGroup(i);
        };

        Map map = new HashMap();
        map.put("uid","100");





    }


    public void getData() {
        try {
            //模拟网络请求
            InputStream inputStream = getAssets().open("shop.json");
            String data = convertStreamToString(inputStream);
            Gson gson = new Gson();
            ShopBean shopBean = gson.fromJson(data, ShopBean.class);


            for (int i = 0; i < shopBean.getOrderData().size(); i++) {
                int length = shopBean.getOrderData().get(i).getCartlist().size();
                List<ShopBean.OrderDataBean.CartlistBean> mAllOrderList = new ArrayList<>();
                for (int j = 0; j < length; j++) {
                    mAllOrderList.add(shopBean.getOrderData().get(i).getCartlist().get(j));
                }
                map.put(shopBean.getOrderData().get(i).getShopName(),mAllOrderList);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
