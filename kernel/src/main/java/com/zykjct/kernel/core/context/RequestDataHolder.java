package com.zykjct.kernel.core.context;

import com.zykjct.kernel.core.reqres.request.RequestData;

/**
 * @description:  请求数据的临时容器
 * @author: huzhiwen
 * @create: 2019-01-26 20:19
 **/

public class RequestDataHolder {

    private static ThreadLocal<RequestData> holder = new ThreadLocal<>();

    public static void put(RequestData s) {
        holder.set(s);
    }

    public static RequestData get() {
        return holder.get();
    }

    public static void remove() {
        holder.remove();
    }
}
