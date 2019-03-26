package com.docx.farmersupport.customs;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.docx.farmersupport.R;

public class CustomTextView extends AppCompatTextView {

    private Context con = null;
    private String typeface = null;

    public CustomTextView(Context context, String tyface) {
        super(context);
        this.con = context;
        this.typeface = tyface;
    }

    public CustomTextView(Context context, AttributeSet attributes) {
        super(context,attributes);
        this.con = context;
        typeface = context.obtainStyledAttributes((AttributeSet) attributes,
                R.styleable.TextView).getString(R.styleable.TextView_ctypeface);
        //typeface = a
        setCTypeFace(typeface);
    }
    @Override
    public void setInputType(int type) {
        super.setInputType(type);
        setCTypeFace(typeface);
    }
    public void setCTypeFace(String typeface) {
        typeface = typeface;
        if (typeface != null) {
            FontManager.getInstance(con).setTypeFace(this, typeface);
        }
    }
}
