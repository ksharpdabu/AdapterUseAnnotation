package info.dabu.multiplelayoutwithoutnoanotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<ListViewItem> mListViewItems;


    ListView mListView;


    CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.Lv);


        mListViewItems = new ArrayList<>();




        for (int i = 0; i < 100 ; i++) {

             ListViewItem temp = new ListViewItem();

             int x = (int)(Math.random() * 1000);

             if ( x % 2 == 0){

                 temp.setType(0);
                 temp.setString(String.valueOf(x));

             }else {
                 temp.setType(1);
                 temp.setString(String.valueOf(x));
             }


            mListViewItems.add(temp);


        }


        mAdapter = new CustomAdapter(this,mListViewItems);

        mListView.setAdapter(mAdapter);





    }
}
