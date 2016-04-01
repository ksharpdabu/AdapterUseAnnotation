package info.dabu.multiplelayoutwithoutnoanotation;

/**
 * Created by AlexY on 2016/4/1.
 */
public class ListViewItem {

    private String mString;

    //布局的类型
    private int mType;


    public ListViewItem() {
    }

    public ListViewItem(String string, int type) {
        mString = string;
        mType = type;
    }

    public String getString() {
        return mString;
    }

    public void setString(String string) {
        mString = string;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }
}
