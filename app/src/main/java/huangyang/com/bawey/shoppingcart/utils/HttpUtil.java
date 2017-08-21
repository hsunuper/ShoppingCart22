package huangyang.com.bawey.shoppingcart.utils;


/**
 * 类描述：
 * 创建人：xuyaxi
 * 创建时间：2017/8/16 17:16
 */


import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Http工具类
 * 注意声明权限
 *  <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 *  <uses-permission android:name="android.permission.INTERNET"/>
 */


public class HttpUtil {

    //网络请求OKHttp
    public static void sendOkHttpRequest(String address, Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }


}

