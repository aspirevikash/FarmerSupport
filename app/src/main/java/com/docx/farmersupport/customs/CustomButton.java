package com.docx.farmersupport.customs;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.docx.farmersupport.R;


public class CustomButton extends AppCompatButton {
    private Context con = null;
    private String typeface = null;

    public CustomButton(Context context, String tyface) {
        super(context);
        this.con = context;
        this.typeface = tyface;
    }

    public CustomButton(Context context, AttributeSet attributes) {
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
