package com.zlx.reverce.constant.response;

import java.util.List;
import java.util.Map;

public class ListResp {
    private List<Map> list;

    public ListResp(List<Map> list) {
        this.list = list;
    }

    public List<Map> getList() {
        return list;
    }

    public void setList(List<Map> list) {
        this.list = list;
    }
}
