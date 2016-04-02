package info.dabu.adapteruseannotation.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import info.dabu.adapteruseannotation.DelegateAdapter;
import info.dabu.adapteruseannotation.R;
import info.dabu.adapteruseannotation.annotation.DelegateAdapterType;

/**
 * 含ImageView的
 */
@DelegateAdapterType(itemType = 1)
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
