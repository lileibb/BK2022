package com.example.bookmanager.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;

public class IronUtils {
    private Context context;

    public IronUtils(Context context) {
        this.context = context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public static void  changeDraw(Context context, EditText edit, int key) {
        Drawable drawable=context.getResources().getDrawable(key);
        drawable.setBounds(5,10,60,60);//第一个参数是左边距，第二个参数是上边距，第三个和第四个分别是图片长和宽
        edit.setCompoundDrawables(drawable,null,null,null);//将图片放在左边
    }


}
