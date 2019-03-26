package com.docx.farmersupport.views.dummymodels;

public class DashboardMenuModels {

    private String id;
    private String menuName;
    private int drawableImageId;


    public DashboardMenuModels(){

    }

    public DashboardMenuModels(String id,String menu,int resource){
        this.id=id;
        this.menuName=menu;
        this.drawableImageId=resource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getDrawableImageId() {
        return drawableImageId;
    }

    public void setDrawableImageId(int drawableImageId) {
        this.drawableImageId = drawableImageId;
    }
}
