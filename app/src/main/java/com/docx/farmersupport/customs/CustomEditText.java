package com.docx.farmersupport.customs;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.docx.farmersupport.R;


public class CustomEditText extends AppCompatEditText {
    private Context con = null;
    private String typeface = null;

    public CustomEditText(Context context, String tyface) {
        super(context);
        this.con = context;
        this.typeface = tyface;
    }

    public CustomEditText(Context context, AttributeSet attributes) {
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