package info.dabu.multiplelayoutwithoutnoanotation;

import android.app.Activity;
import android.support.v4.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import info.dabu.multiplelayoutwithoutnoanotation.Adapter.ImageDelegateAdapter;
import info.dabu.multiplelayoutwithoutnoanotation.Adapter.TextDelegateAdapter;

/**
 * Created by AlexY on 2016/4/1.
 *
 *
 *
 */
public class CustomAdapter extends BaseAdapter {

    private LongSparseArray<DelegateAdapter> mDelegateAdapterSparseArray;




    private Activity mActivity;


    private List<ListViewItem > mList;


    private LayoutInflater mLayoutInflater;


    public CustomAdapter() {
    }


    public CustomAdapter(Activity activity, List<ListViewItem> list) {
        mActivity = activity;
        mList = list;

        mLayoutInflater = LayoutInflater.from(mActivity);

        mDelegateAdapterSparseArray = new LongSparseArray<>();

        DelegateAdapter delegateAdapter0 =   new TextDelegateAdapter();
        mDelegateAdapterSparseArray.put(0,delegateAdapter0);

        DelegateAdapter delegateAdapter1 =  new ImageDelegateAdapter();
        mDelegateAdapterSparseArray.put(1,delegateAdapter1);


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

//    总共有几种布局
    @Override
    public int getViewTypeCount() {
        return mDelegateAdapterSparseArray.size();
    }

//    获取Item的View的类型
    @Override
    public int getItemViewType(int position) {
        return  mList.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        int itemType = getItemViewType(position);

        switch (itemType){

            case 0:

                return   mDelegateAdapterSparseArray.get(itemType).getView(position,convertView,parent,mLayoutInflater,getItem(position));


            case 1:

                return mDelegateAdapterSparseArray.get(itemType).getView(position,convertView,parent,mLayoutInflater,getItem(position));


              default:

                  break;
        }




        return convertView;
    }





}
