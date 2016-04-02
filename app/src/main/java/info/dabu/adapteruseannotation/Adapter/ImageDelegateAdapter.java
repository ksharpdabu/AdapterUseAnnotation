package info.dabu.adapteruseannotation.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.dabu.adapteruseannotation.DelegateAdapter;
import info.dabu.adapteruseannotation.annotation.DelegateAdapterType;

/**
 * 含ImageView的
 */
@DelegateAdapterType(itemType = 1)
public class ImageDelegateAdapter implements DelegateAdapter {


    @Override
    public View getView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, Object item) {
        return null;
    }
}
