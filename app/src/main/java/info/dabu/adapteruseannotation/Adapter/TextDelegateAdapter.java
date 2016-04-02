package info.dabu.adapteruseannotation.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.dabu.adapteruseannotation.DelegateAdapter;
import info.dabu.adapteruseannotation.annotation.DelegateAdapterType;

/**
 * 含TextView的
 */


@DelegateAdapterType(itemType = 0)
public class TextDelegateAdapter implements DelegateAdapter {
    @Override
    public View getView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, Object item) {
        return null;
    }
}
