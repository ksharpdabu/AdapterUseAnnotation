package info.dabu.multiplelayoutwithoutnoanotation.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import info.dabu.multiplelayoutwithoutnoanotation.DelegateAdapter;
import info.dabu.multiplelayoutwithoutnoanotation.ListViewItem;
import info.dabu.multiplelayoutwithoutnoanotation.R;


/**
 * 含TextView的
 */



public class TextDelegateAdapter implements DelegateAdapter {




    @Override
    public View getView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, Object item) {

        final  TextViewHolder textViewHolder;


        if ( convertView == null){


            convertView = inflater.inflate(R.layout.type_textview,parent,false);

            textViewHolder = new TextViewHolder();
            textViewHolder.textview = (TextView) convertView.findViewById(R.id.text);

            convertView.setTag(textViewHolder);

        }else {

            textViewHolder = (TextViewHolder) convertView.getTag();
        }


        if ( null !=  textViewHolder.textview){
            textViewHolder.textview.setText( (  (ListViewItem) item).getString());

        }


        return  convertView;


    }





    //用来优化含TextView的布局
    public class TextViewHolder {
        TextView textview;


    }
}
