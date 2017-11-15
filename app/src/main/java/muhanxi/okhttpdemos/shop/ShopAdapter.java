package muhanxi.okhttpdemos.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import muhanxi.okhttpdemos.R;

import static com.amap.api.col.s3.dc.G;

/**
 * Created by muhanxi on 17/11/15.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.IViewHolder> {

    private Context context;
    private List<ShopBean.OrderDataBean.CartlistBean> list ;
    public ShopAdapter(Context context) {
        this.context = context;
    }


    public void add(List<ShopBean.OrderDataBean.CartlistBean> list){
        if(this.list == null){
            this.list = new ArrayList<>();
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ShopAdapter.IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.shop_adapter, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShopAdapter.IViewHolder holder, final int position) {



        holder.checkbox.setChecked(list.get(position).isCheck());



        holder.danjia.setText(list.get(position).getPrice()+"");

        ImageLoader.getInstance().displayImage(list.get(position).getDefaultPic(),holder.shopface);





        holder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(position).setCheck(holder.checkbox.isChecked());
                notifyDataSetChanged();

                if(checkBoxListener != null){
                    checkBoxListener.check(position,holder.customviewid.getCurrentCount(),holder.checkbox.isChecked());
                }
            }
        });

//        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//
//
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class IViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.checkbox)
        CheckBox checkbox;
        @BindView(R.id.shopface)
        ImageView shopface;
        @BindView(R.id.danjia)
        TextView danjia;
        @BindView(R.id.customviewid)
        CustomView customviewid;

        IViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public CheckBoxListener checkBoxListener;
    public void setCheckBoxListener(CheckBoxListener listener){
        this.checkBoxListener = listener;
    }
    public interface CheckBoxListener {
        public void check(int position,int count, boolean check);
    }
}
