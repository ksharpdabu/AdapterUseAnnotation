package info.dabu.adapteruseannotation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import info.dabu.adapteruseannotation.Adapter.ImageDelegateAdapter;
import info.dabu.adapteruseannotation.Adapter.TextDelegateAdapter;
import info.dabu.adapteruseannotation.annotation.DelegateAdapters;

/**
 * 自定义的适配器
 */

@DelegateAdapters(  delegateAdapters = {
        TextDelegateAdapter.class,
        ImageDelegateAdapter.class

})
public class CustomeAdapter extends BaseAdapter {




    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
