package com.luer.membershipManage.bean;

import java.io.Serializable;

public class MarketingMemberLabel  implements Serializable {
    private String id;

    private String memberId;

    private String labelId;

    private Integer isValib;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId == null ? null : labelId.trim();
    }

    public Integer getIsValib() {
        return isValib;
    }

    public void setIsValib(Integer isValib) {
        this.isValib = isValib;
    }
}