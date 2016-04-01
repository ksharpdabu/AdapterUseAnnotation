package info.dabu.multiplelayoutwithoutnoanotation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AlexY on 2016/4/1.
 *
 *
 *
 */
public class CustomAdapter extends BaseAdapter {


    private Activity mActivity;


    private List<ListViewItem > mList;


    public CustomAdapter() {
    }


    public CustomAdapter(Activity activity, List<ListViewItem> list) {
        mActivity = activity;
        mList = list;
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
        return 2;
    }

//    获取Item的View的类型
    @Override
    public int getItemViewType(int position) {
        return  mList.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {




            switch (getItemViewType(position)){

                case 0:
                    TextViewHolder textViewHolder;


                    if ( convertView == null){


                        convertView = LayoutInflater.from(mActivity).inflate(R.layout.type_textview,parent,false);

                        textViewHolder = new TextViewHolder();
                        textViewHolder.textview = (TextView) convertView.findViewById(R.id.text);

                        convertView.setTag(textViewHolder);

                    }else {

                        textViewHolder = (TextViewHolder) convertView.getTag();
                    }


                    if ( null !=  textViewHolder.textview){
                        textViewHolder.textview.setText(mList.get(position).getString());

                    }


                    return  convertView;



                case 1:

                    ImageViewHolder imageViewHolder;


                    if ( convertView == null){
                        convertView = LayoutInflater.from(mActivity).inflate(R.layout.type_imageview,parent,false);

                        imageViewHolder = new ImageViewHolder();
                        imageViewHolder.imageView = (ImageView) convertView.findViewById(R.id.image);

                        convertView.setTag(imageViewHolder);
                    }else {
                        imageViewHolder = (ImageViewHolder) convertView.getTag();
                    }


                    if ( null != imageViewHolder.imageView){
                        imageViewHolder.imageView.setImageResource(R.mipmap.bangalore);
                    }



                    return  convertView;




                default:

                    break;

            }


        return convertView;
    }




    //用来优化含TextView的布局
    public class TextViewHolder {
        TextView  textview;


    }


//    用来优化含ImageView的布局
    public class ImageViewHolder {
        ImageView imageView;

    }






}
