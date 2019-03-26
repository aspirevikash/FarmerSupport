package com.docx.farmersupport.customs;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;


import com.docx.farmersupport.utility.AppUtils;

import java.util.ArrayList;
import java.util.HashMap;

class FontManager {
    private ArrayList fontNames;
    private HashMap typeFaceStore;
    private Context context;
    private static FontManager manager;
    //public static  FontManager.Companion Companion = new FontManager.Companion((DefaultConstructorMarker)null);

    public final void setTypeFace( View view,  String fontNamees) {
       String  fontName = fontNamees;

        if (view instanceof TextView) {
            return;
        }
        int index = fontNames.indexOf(fontName);
        if (index == -1) {
            this.fontNames.add(fontName);
        } else {
            fontName = (String) this.fontNames.get(index);
        }
        Typeface typeface = (Typeface)this.typeFaceStore.get(fontName);
        if (typeface == null) {
            typeface = AppUtils.findTypeface(context, "fonts", fontName);
            typeFaceStore.put(fontName, typeface);
        }
        if (typeface != null) {
            ((TextView)view).setTypeface(typeface);
        } else {
            ((TextView)view).setTypeface(Typeface.DEFAULT);
        }
        }

    private FontManager(Context context) {
        this.context = context;
        this.fontNames = new ArrayList();
        this.typeFaceStore = new HashMap();
    }


    public static final FontManager getInstance(Context context) {
        if (FontManager.manager == null) {
            FontManager.manager = new FontManager(context);
        }
        return FontManager.manager;
    }

}
