package huangyang.com.bawey.shoppingcart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import huangyang.com.bawey.shoppingcart.R;


/**
 * 创建人:hy
 * 日期:  2017/8/1
 */

public class Fragment02 extends Fragment {

    private ViewPager vp;
    private TabLayout tablayout;
    private List<Fragment> list;
    private String str[] = new String[]{"天天优惠", "为你精选", "亲的最爱"};
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment02, container, false);
        initView();

        return view;
    }

    private void initView() {
        //使用适配器将ViewPager与Fragment绑定在一起
        vp = (ViewPager) view.findViewById(R.id.vp);
        //添加数据
        listadd();
        Vpadapter adapter = new Vpadapter(getChildFragmentManager());
        vp.setAdapter(adapter);
        //将TabLayout与ViewPager绑定在一起
        tablayout = (TabLayout) view.findViewById(R.id.tab);
        //绑定
        tablayout.setupWithViewPager(vp);
        //字体颜色
        tablayout.setTabTextColors(getResources().getColor(R.color.black), getResources().getColor(R.color.red));
        //指示器颜色（选中状态下划线的颜色）
        tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.red));
        //模式
        tablayout.setTabMode(TabLayout.MODE_FIXED);

    }

    private void listadd() {
        list = new ArrayList<>();
        list.add(new One());
        list.add(new Two());
        list.add(new Three());
    }
    private class Vpadapter extends FragmentPagerAdapter {
        @Override
        public CharSequence getPageTitle(int position) {
            return str[position];
        }

        public Vpadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
