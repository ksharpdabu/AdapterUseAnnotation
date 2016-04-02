package info.dabu.multiplelayoutwithoutnoanotation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by AlexY on 2016/4/2.
 * 这个接口的作用就是定义一个方法用来返回不同的View
 */
public interface DelegateAdapter {


    public View getView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, Object item);
}
