package info.dabu.adapteruseannotation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by AlexY on 2016/4/2.
 */
public interface DelegateAdapter {


    public View getView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, Object item);
}
