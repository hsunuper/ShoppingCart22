package huangyang.com.bawey.shoppingcart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import huangyang.com.bawey.shoppingcart.R;
import huangyang.com.bawey.shoppingcart.adapter.MyAdapterTian;
import huangyang.com.bawey.shoppingcart.bean.TianTianBean;

/**
 * 创建人:hy
 * 日期:  2017/8/13
 */

public class One extends Fragment{

    private View view;
    private List<TianTianBean.DataBean.ProductsBean> list = new ArrayList<>();
    private String url = "http://api.eleteam.com/v1/product/list-featured-price";
    private MyAdapterTian adapter;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.one, container, false);
        lv = (ListView) view.findViewById(R.id.lvtian);
        initView();
        adapter = new MyAdapterTian(list,getActivity());
        lv.setAdapter(adapter);

        return view;
    }

    private void initView() {
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                TianTianBean bean = new Gson().fromJson(result, TianTianBean.class);
                list.addAll(bean.getData().getProducts());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
