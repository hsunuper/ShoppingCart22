package huangyang.com.bawey.shoppingcart.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import huangyang.com.bawey.shoppingcart.R;
import huangyang.com.bawey.shoppingcart.bean.Bean;

/**
 * 类描述：
 * 创建人：xuyaxi
 * 创建时间：2017/8/2 20:30
 */
public class MyAdapterlv1 extends BaseAdapter {

    private List<Bean.DataBean.CategoriesBean> list;
    private Context context;
    private int selectItem = 0;

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
        notifyDataSetChanged();
    }

    public MyAdapterlv1(List<Bean.DataBean.CategoriesBean> list, Context context) {
        this.list = list;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.item1, null);
            holder = new ViewHolder();


            x.view().inject(holder, view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Bean.DataBean.CategoriesBean bean = list.get(i);
        holder.txt1.setText(bean.getName());

        if (selectItem == i) {
            holder.txt1.setTextColor(Color.GRAY);
        } else {
            holder.txt1.setTextColor(Color.BLACK);
        }

        return view;
    }


    class ViewHolder {
        @ViewInject(R.id.text_name)
        TextView txt1;
    }
}
