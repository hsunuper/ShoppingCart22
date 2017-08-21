package huangyang.com.bawey.shoppingcart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import huangyang.com.bawey.shoppingcart.R;

/**
 * 创建人:hy
 * 日期:  2017/8/13
 */

public class Two extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.two,container,false);
    }
}
