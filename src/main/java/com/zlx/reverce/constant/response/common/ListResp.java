package com.zlx.reverce.constant.response.common;

import java.util.List;
import java.util.Map;

public class ListResp<T> {
    private List<T> list;

    public ListResp(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
