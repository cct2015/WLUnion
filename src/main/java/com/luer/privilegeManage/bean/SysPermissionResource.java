package com.luer.privilegeManage.bean;

public class SysPermissionResource {
    private String id;

    private String permname;

    private String permtag;

    private Integer isMenu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPermname() {
        return permname;
    }

    public void setPermname(String permname) {
        this.permname = permname == null ? null : permname.trim();
    }

    public String getPermtag() {
        return permtag;
    }

    public void setPermtag(String permtag) {
        this.permtag = permtag == null ? null : permtag.trim();
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }
}