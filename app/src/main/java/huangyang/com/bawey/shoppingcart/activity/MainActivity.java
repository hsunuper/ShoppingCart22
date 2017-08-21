package huangyang.com.bawey.shoppingcart.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import huangyang.com.bawey.shoppingcart.R;
import huangyang.com.bawey.shoppingcart.fragment.Fragment01;
import huangyang.com.bawey.shoppingcart.fragment.Fragment02;
import huangyang.com.bawey.shoppingcart.fragment.Fragment03;
import huangyang.com.bawey.shoppingcart.fragment.Fragment04;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton radiao01= (RadioButton) findViewById(R.id.radio01);
        RadioButton radiao02= (RadioButton) findViewById(R.id.radio02);
        RadioButton radiao03= (RadioButton) findViewById(R.id.radio03);
        RadioButton radiao04= (RadioButton) findViewById(R.id.radio04);

        radiao01.setOnClickListener(this);
        radiao02.setOnClickListener(this);
        radiao03.setOnClickListener(this);
        radiao04.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radio01:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Fragment01()).commit();
                break;
            case R.id.radio02:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Fragment02()).commit();
                break;
            case R.id.radio03:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Fragment03()).commit();
                break;
            case R.id.radio04:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Fragment04()).commit();
                break;
        }

    }
}
