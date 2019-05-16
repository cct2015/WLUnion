package com.luer.comm.bean;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @author max
 */
public class JqgridResponseContext {


    public static <E extends Serializable> JqgridResponse<E> getJqgridResponse(JqgridFilter filter, List<E> results) {
        JqgridResponse jqgridResponse = new JqgridResponse();
        jqgridResponse.setRows(results);
        jqgridResponse.setPage(filter.getPage());
        PageInfo page = new PageInfo(results);
        jqgridResponse.setRecords(page.getTotal());
        jqgridResponse.setTotal(page.getPages());
        return jqgridResponse;
    }

}
