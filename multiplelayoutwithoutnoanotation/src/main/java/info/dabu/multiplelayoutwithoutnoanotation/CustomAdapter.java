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

        final TextViewHolder textViewHolder;
        final ImageViewHolder imageViewHolder;



        //必须将要设置的控件单独提取出来
        TextView textView = null;
        ImageView imageView = null;


        if ( convertView == null){
            switch (getItemViewType(position)){

                case 0:

                    convertView = LayoutInflater.from(mActivity).inflate(R.layout.type_textview,parent,false);

                    textViewHolder = new TextViewHolder();

                    textView = (TextView) convertView.findViewById(R.id.text);


                    textViewHolder.textview = textView;


                    convertView.setTag(textViewHolder);


                    break;
                case 1:



                    convertView = LayoutInflater.from(mActivity).inflate(R.layout.type_imageview,parent,false);

                    imageViewHolder = new ImageViewHolder();

                    imageView= (ImageView) convertView.findViewById(R.id.image);


                    imageViewHolder.imageView = imageView;



                    convertView.setTag(imageViewHolder);

                    break;


                default:

                    break;

            }




        }else {



            switch ( getItemViewType(position)){
                case 0:

                    textViewHolder = (TextViewHolder) convertView.getTag();


                    textView = textViewHolder.textview;

                    break;
                case 1:
                    imageViewHolder = (ImageViewHolder) convertView.getTag();


                    imageView = imageViewHolder.imageView;
                    break;

            }

        }



        switch (getItemViewType(position)){
            case 0:

                if ( null != textView){
                    textView.setText(mList.get(position).getString());

                }
                break;

            case 1:

                if ( null != imageView){
                    imageView.setImageResource(R.mipmap.bangalore);

                }
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
