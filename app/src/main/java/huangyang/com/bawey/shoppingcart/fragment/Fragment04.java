package huangyang.com.bawey.shoppingcart.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import huangyang.com.bawey.shoppingcart.R;
import huangyang.com.bawey.shoppingcart.activity.LoginActivity;

/**
 * 创建人:hy
 * 日期:  2017/8/1
 */

public class Fragment04 extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment04, container, false);

        ImageView image_arrow= (ImageView) view.findViewById(R.id.image_arrow);

        image_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });


        return view;

    }
}
