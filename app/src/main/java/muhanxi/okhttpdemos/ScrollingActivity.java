package muhanxi.okhttpdemos;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


//http://blog.csdn.net/xyz_lmn/article/details/48055919
public class ScrollingActivity extends Activity {

    /**
     * 替换活动条的工具条
     */
    private Toolbar toolbar;

    /**
     * 选型卡布局
     */
    private TabLayout tabLayout;

    /**
     * 复用的控件,用来显示内容
     */
    private RecyclerView recyclerView;

    /**
     * 存放RecyclerView的数据
     */
    private ArrayList<String> data = new ArrayList<>();;
    private MyAdapter myAdapter;
//    https://www.cnblogs.com/tangs/articles/5934281.html
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);


        initToolbar();
        initTabLayout();
        initRecyclerView();

    }

    /**
     * 初始化Toolbar的数据
     */
    private void initToolbar() {
        //也可以在布局中设置这些属性,具体见布局文件
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置最左侧图标
        toolbar.setTitle("toolbar标题");
        toolbar.setSubtitle("子标题");
        toolbar.setTitleTextColor(Color.parseColor("#ff0000"));//设置标题的字体颜色
        toolbar.setSubtitleTextColor(Color.parseColor("#00ff00"));//设置子标题的字体颜色
//        setSupportActionBar(toolbar); //取代原本的actionbar,继承activity可以不设置,不替换显示不了菜单
        //单击事件需要在setSupportActionBar方法后,因为原本的actionbar也有这个单击事件
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ScrollingActivity.this, "点击了最左边的图标", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    /**
     * 初始化recyclerView的设置
     */
    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        addRecyclerViewData(0);//先显示第0页数据
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
    }

    /**
     * 模拟为RecyclerView添加数据,pager为当前显示的卡片页
     */
    private void addRecyclerViewData(int pager) {
        data.removeAll(data);
        for (int i = 0; i < 50; i++) {
            data.add("pager=" + pager + ",第" + i + "个item");
        }
    }

    /**
     * 初始化选项卡的数据
     */
    private void initTabLayout() {
        for (int i = 0; i < 10; i++) {
            tabLayout.addTab(tabLayout.newTab().setText("卡片"+i));//添加选项
        }
        //选项卡的切换监听,都在主线程中运行的
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("tag", "点击的第"+tab.getPosition()+"个卡片");
                addRecyclerViewData(tab.getPosition());//添加数据
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.i("tag", "取消了第"+tab.getPosition()+"个卡片的显示");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //当前选中的选项被再次点击的时候调用
                Log.i("tag", "第"+tab.getPosition()+"个卡片重新被点击");
            }
        });
    }

    /**
     * RecyclerView适配器
     */
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.item_layout,parent,false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{

            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.textView);
            }
        }
    }
}
