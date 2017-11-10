package muhanxi.okhttpdemos.multi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import muhanxi.okhttpdemos.R;

/**
 * Created by muhanxi on 17/11/10.
 */

public class MultilActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;

    private List<MultiBean.ResultBean.DataBean> list ;

    public MultilActivityAdapter(Context context) {

        this.context = context;
    }


    public void addData(List<MultiBean.ResultBean.DataBean> list){

        if(this.list == null){
            this.list = new ArrayList<>();
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
            return new ViewHolder1(view1);
        } else if (viewType == 1) {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
            return new ViewHolder2(view2);

        } else {
            View view3 = LayoutInflater.from(context).inflate(R.layout.item3, parent, false);
            return new ViewHolder3(view3);

        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ViewHolder1){
            ViewHolder1 holder1 =  (ViewHolder1)holder ;


            holder1.listItem1Textview.setText(list.get(position).getTitle());

            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder1.listItem1Imageview);
        } else if(holder instanceof ViewHolder2){
            ViewHolder2 holder2 =  (ViewHolder2)holder ;
            holder2.listItem2Textview.setText(list.get(position).getTitle());

            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder2.listItem2Imageview1);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder2.listItem2Imageview2);

        } else {
            ViewHolder3 holder3 =  (ViewHolder3)holder ;
            holder3.listItem3Textview.setText(list.get(position).getTitle());
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder3.listItem3Imageview1);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder3.listItem3Imageview2);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s03(),holder3.listItem3Imageview3);

        }




    }


    @Override
    public int getItemViewType(int position) {

        if(!TextUtils.isEmpty(list.get(position).getThumbnail_pic_s03())){
            return 2;
        }else  if(!TextUtils.isEmpty(list.get(position).getThumbnail_pic_s02())){
            return 1;
        }else {
            return 0;

        }


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    static class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.list_item1_imageview)
        ImageView listItem1Imageview;
        @BindView(R.id.list_item1_textview)
        TextView listItem1Textview;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.list_item2_textview)
        TextView listItem2Textview;
        @BindView(R.id.list_item2_imageview1)
        ImageView listItem2Imageview1;
        @BindView(R.id.list_item2_imageview2)
        ImageView listItem2Imageview2;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder3  extends RecyclerView.ViewHolder{
        @BindView(R.id.list_item3_textview)
        TextView listItem3Textview;
        @BindView(R.id.list_item3_imageview1)
        ImageView listItem3Imageview1;
        @BindView(R.id.list_item3_imageview2)
        ImageView listItem3Imageview2;
        @BindView(R.id.list_item3_imageview3)
        ImageView listItem3Imageview3;

        ViewHolder3(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
