package muhanxi.okhttpdemos;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    List<View> list = new ArrayList<>();
    private List listems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        tabLayout = (TabLayout) findViewById(R.id.activity_tablayout);

        viewPager = (ViewPager) findViewById(R.id.activity_viewpager);

        listems = new ArrayList();
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        listems.add("1");
        for (int i = 0; i < 10; i++) {
            tabLayout.addTab(tabLayout.newTab().setText("卡片"+i));//添加选项
            View view1 =  View.inflate(this,R.layout.viewpager_layout,null);
            RecyclerView recyclerView =  view1.findViewById(R.id.listview_activity);


            RAdapter adapter = new RAdapter();
            recyclerView.setAdapter(adapter);

            LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

            recyclerView.setLayoutManager(manager);

            list.add(view1);
        }
        tabLayout.setupWithViewPager(viewPager);
        IAdapter adapter = new IAdapter();
        viewPager.setAdapter(adapter);






    }


    class IAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        /**
         * 实例化 一个 页卡
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 添加一个 页卡

            container.addView(list.get(position));

            return list.get(position);
        }

        /**
         * 销毁 一个 页卡
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // 删除
            container.removeView(list.get(position));
        }



    }



    class RAdapter extends RecyclerView.Adapter<IHolder>{


        @Override
        public IHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new IHolder(View.inflate(Main2Activity.this,R.layout.recyclerview_item,null));
        }

        @Override
        public void onBindViewHolder(IHolder holder, int position) {


            holder.textView.setText("" + position);

        }

        @Override
        public int getItemCount() {
            return listems.size();
        }
    }


    static class IHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public IHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.recycleview_item_textview);
        }
    }

}
