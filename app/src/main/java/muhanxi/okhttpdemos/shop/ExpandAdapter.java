package muhanxi.okhttpdemos.shop;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import muhanxi.okhttpdemos.R;

/**
 * Created by muhanxi on 17/11/17.
 */

public class ExpandAdapter extends BaseExpandableListAdapter {

    private Map<String,List<ShopBean.OrderDataBean.CartlistBean>> map = new HashMap<>();
    private Context context;
    public ExpandAdapter(Context context,Map<String,List<ShopBean.OrderDataBean.CartlistBean>> map){
        this.context = context;
        this.map = map;
    }



    @Override
    public int getGroupCount() {
        return map.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Set<String> set =  map.keySet() ;
        List<String> list = new ArrayList<>(set);
        return map.get(list.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return new ArrayList<String>(map.keySet()).get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        Set<String> set =  map.keySet() ;
        List<String> list = new ArrayList<>(set);
        return map.get(list.get(groupPosition)).get(childPosition);
    }

    //  获得某个父项的id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //  获得某个父项的某个子项的id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ParentViewHolder parentViewHolder = null ;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.parent_groupview,parent,false);
            parentViewHolder = new ParentViewHolder();
            parentViewHolder.checkBoxParent = convertView.findViewById(R.id.parent_groupview);
            parentViewHolder.textViewParent = convertView.findViewById(R.id.parent_groupview_name);
            convertView.setTag(parentViewHolder);
        }else {
            parentViewHolder = (ParentViewHolder) convertView.getTag();
        }

        parentViewHolder.textViewParent.setText(new ArrayList(map.keySet()).get(groupPosition)+"");


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder = null ;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.child_groupview,parent,false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.textView_name = convertView.findViewById(R.id.expand_group_name);
            childViewHolder.textView_price = convertView.findViewById(R.id.expand_group_price);
            convertView.setTag(childViewHolder);
        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        childViewHolder.textView_name.setText(map.get(new ArrayList(map.keySet()).get(groupPosition)).get(childPosition).getProductName());
        childViewHolder.textView_price.setText(map.get(new ArrayList(map.keySet()).get(groupPosition)).get(childPosition).getPrice()+"");


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    static class ParentViewHolder {
        CheckBox checkBoxParent;
        TextView textViewParent;
    }


    static class ChildViewHolder {
        CheckBox checkBoxChild;
        ImageView imageViewChild;
        TextView textView_name;
        TextView textView_price;
    }


}
