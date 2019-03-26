package com.docx.farmersupport.utility;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.io.File;

public class AppUtils {
    public static Typeface findTypeface(Context context, String initPath,
                                        String typeface) {
        AssetManager assets = context.getAssets();
        return Typeface.createFromAsset(assets, initPath + File.separator + typeface);
    }
}
