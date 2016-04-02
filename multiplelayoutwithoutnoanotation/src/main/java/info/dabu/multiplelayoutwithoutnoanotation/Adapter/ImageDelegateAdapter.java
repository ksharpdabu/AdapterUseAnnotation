package info.dabu.multiplelayoutwithoutnoanotation.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import info.dabu.multiplelayoutwithoutnoanotation.DelegateAdapter;
import info.dabu.multiplelayoutwithoutnoanotation.R;


/**
 * 含ImageView的
 */

public class ImageDelegateAdapter implements DelegateAdapter {


    @Override
    public View getView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, Object item) {

        final  ImageViewHolder imageViewHolder;


        if ( convertView == null){
            convertView =  inflater.inflate(R.layout.type_imageview,parent,false);

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



    }



    //    用来优化含ImageView的布局
    public class ImageViewHolder {
        ImageView imageView;

    }

}
