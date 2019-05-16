package com.luer.comm.bean;

import com.github.pagehelper.PageHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author max
 * Jqgrid查询参数包装类
 * 可继承此类扩展查询参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JqgridFilter {
    private Boolean search;
    private String filters,sidx,sord;
    //default value
    private Integer page = 1,rows = 15;

    public void  refresh(){
        PageHelper.startPage(this.getPage(), this.getRows());
    }

}
