package com.zlx.reverce.constant.response;

import com.zlx.reverce.entity.TCaseInfo;

import java.util.List;

public class CaseResp {
    private String caseId;
    private String caseName;
    private List<TCaseInfo> caseInfoList;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public List<TCaseInfo> getCaseInfoList() {
        return caseInfoList;
    }

    public void setCaseInfoList(List<TCaseInfo> caseInfoList) {
        this.caseInfoList = caseInfoList;
    }
}
