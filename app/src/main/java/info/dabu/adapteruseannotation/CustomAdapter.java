package info.dabu.adapteruseannotation;

import android.app.Activity;
import android.support.v4.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import info.dabu.adapteruseannotation.Adapter.ImageDelegateAdapter;
import info.dabu.adapteruseannotation.Adapter.TextDelegateAdapter;
import info.dabu.adapteruseannotation.annotation.DelegateAdapterType;
import info.dabu.adapteruseannotation.annotation.DelegateAdapters;

/**
 * 自定义的适配器
 */

@DelegateAdapters(  delegateAdapters = {
        TextDelegateAdapter.class,
        ImageDelegateAdapter.class

})
public class CustomAdapter extends BaseAdapter {

    private LongSparseArray<DelegateAdapter> mDelegateAdapterSparseArray;


    private  Activity mActivity;


    private LayoutInflater mLayoutInflater;


    private List<ListViewItem> mList;


    public CustomAdapter( Activity activity,List<ListViewItem> list) {
        mList = list;
        mActivity = activity;
        mLayoutInflater = LayoutInflater.from(mActivity);

        initDelegates();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public int getViewTypeCount() {
        return mDelegateAdapterSparseArray.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        long itemtype = getItemViewType(position);


        DelegateAdapter delegateAdapter  = mDelegateAdapterSparseArray.get(itemtype);

        if (delegateAdapter != null){
            throw new RuntimeException("Unknown type "+itemtype+" called");
        }


        //返回每种适配器对应的View
        return mDelegateAdapterSparseArray.get(itemtype).getView(position, convertView, parent, mLayoutInflater, getItem(position));
    }


    //通过反射，初始化的mDelegateAdapterSparseArray，
    private void initDelegates(){
        mDelegateAdapterSparseArray = new LongSparseArray<DelegateAdapter>();

        DelegateAdapters annotation = getClass().getAnnotation(DelegateAdapters.class);

        if ( annotation != null){
            Class[] clazzs = annotation.delegateAdapters();

            for ( Class<?> clazz : clazzs){
                DelegateAdapterType delegateAdapterAnnotation = clazz.getAnnotation(DelegateAdapterType.class);

                if ( delegateAdapterAnnotation == null){
                    throw new RuntimeException("The class "+clazz.getName()+" should have the annotation DelegateAdapterType");
                }

                long itemType = delegateAdapterAnnotation.itemType();

                if ( mDelegateAdapterSparseArray.get(itemType) != null){
                    throw new RuntimeException("The item type "+itemType+" is already defined!");
                }

                DelegateAdapter adapter  = null;

                try {

                    adapter = (DelegateAdapter) clazz.newInstance();
                }catch (Exception e){

                    throw  new RuntimeException("Error while instantiating "+clazz.getName()+" with default constructor: "+e.getMessage(), e);

                }


                mDelegateAdapterSparseArray.put(itemType, adapter);

            }

        }

    }





}
