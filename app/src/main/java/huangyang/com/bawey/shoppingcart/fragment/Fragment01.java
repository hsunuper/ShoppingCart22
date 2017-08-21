package huangyang.com.bawey.shoppingcart.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import huangyang.com.bawey.shoppingcart.R;
import huangyang.com.bawey.shoppingcart.adapter.MyAdapterlv1;
import huangyang.com.bawey.shoppingcart.adapter.MyAdapterlv2;
import huangyang.com.bawey.shoppingcart.bean.Bean;
import huangyang.com.bawey.shoppingcart.utils.NetUtils;


/**
 * 创建人:hy
 * 日期:  2017/8/1
 */

public class Fragment01 extends Fragment {

    private View view;
    private ListView lv1,lv2;
    private List<Bean.DataBean.CategoriesBean> beanList;
    Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String url=msg.obj.toString();
                Gson gson=new Gson();
                Bean bean=gson.fromJson(url,Bean.class);
                beanList.addAll(bean.getData().getCategories());
                adapter1.notifyDataSetChanged();
            }
        };
    private MyAdapterlv1 adapter1;
    private MyAdapterlv2 adapter2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment01, container, false);
        init();
        LoadData();

        return view;
    }

    private void LoadData() {
        new Thread(){


            @Override
            public void run() {
                String url= NetUtils.getUrlConnect("http://api.eleteam.com/v1/category/list-with-product");

                if(url!=null){
                    Message msg=Message.obtain();
                    msg.obj=url;
                    handler.sendMessage(msg);
                }
            }

        }.start();


    }

    private void init() {

        lv1 = (ListView) view.findViewById(R.id.lv1);
        lv2 = (ListView) view.findViewById(R.id.lv2);

        beanList = new ArrayList<>();

        adapter1 = new MyAdapterlv1(beanList,getContext());
        lv1.setAdapter(adapter1);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter1.setSelectItem(position);
                adapter2 = new MyAdapterlv2(beanList.get(position).getProducts(),getContext());
                lv2.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();
            }
        });
    }

 /*   private class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return beanList.size();
        }

        @Override
        public Object getItem(int position) {
            return beanList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                convertView=View.inflate(getActivity(),R.layout.item1,null);
                holder=new ViewHolder();
                holder.text_name= (TextView) convertView.findViewById(R.id.text_name);

                convertView.setTag(holder);

            }else{
                holder= (ViewHolder) convertView.getTag();
            }

            holder.text_name.setText(beanList.get(position).getName());
            return convertView;
        }
        class ViewHolder{
            TextView text_name;
        }
    }*/
}
