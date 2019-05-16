package com.luer.dataManage.controller;

import com.alibaba.fastjson.JSONObject;
import com.luer.comm.bean.*;
import com.luer.dataManage.bean.BaseLabel;
import com.luer.dataManage.service.BaseLabelService;
import com.luer.comm.bean.ResultSet;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/baseLabel")
public class BaseLabelController {
    @Autowired
    private BaseLabelService baseLabelService;

    @ResponseBody
    @RequestMapping("/insert")
    public ResultSet insert(BaseLabel baseLabel) {
        baseLabelService.insert(baseLabel);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/deleteById")
    public ResultSet deleteById(String id) {
        baseLabelService.delete(id);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/updateById")
    public ResultSet updateById(BaseLabel baseLabel) {
        baseLabelService.updateById(baseLabel);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public JqgridResponse<BaseLabel> selectAll(JqgridFilter filter) {
        filter.refresh();
        List<BaseLabel> baseLabelList = baseLabelService.selectAll();
        return JqgridResponseContext.getJqgridResponse(filter, baseLabelList);
    }

    @ResponseBody
    @PostMapping("/addLabels")
    public ResultSet addLabels() {
        baseLabelService.addBaseLabels();
        return ResultSet.getSuccess();
    }

    //获得所有的有用的标签及其分类
    @ResponseBody
    @RequestMapping("/getLabelListEx")
    public ResultSet getLabelListEx() {
        //加入redis 缓存
        StringBuilder sb = new StringBuilder();
        List<BaseLabel> list = baseLabelService.getOneStepLabelExclude();//一级，排除关于汽车的
        List<BaseLabel> listchild = null;
        int i = 0;

        for (BaseLabel baseLabel : list) {
            i++;
            if (baseLabel.getKeyss().equals("reside")) {
                sb.append("<tr style=\"height: 46px\"><td style=\"font-size: 14px\">" + i + "." + baseLabel.getText() + "<span class=\"mustItem\">(*必填)</span>：</td><td>");
                sb.append("<textarea id=\"selliveCitys\" name=\"selliveCitys\" readonly onclick=\"showCity();\" cols=\"40\" rows=\"30\" placeholder=\"选择常驻地省/市\" style=\"width:400px;height:70px;\"></textarea>");
                sb.append("<input type=\"hidden\" id=\"musthdnselCityKeys\" name=\"musthdnselCityKeys\" value='' />");
                sb.append("<input type=\"hidden\" id=\"musthdnselCityKeysname\" name=\"musthdnselCityKeysname\" value='' />");
                sb.append("</td></tr>");
            } else {
                sb.append("<tr style=\"height: 23px\">");
                if (baseLabel.getIsMust() == 1) {
                    sb.append("<td  style=\"font-size: 14px\">" + i + "." + baseLabel.getText() + "<span class=\"mustItem\">(*必填)</span>：</td><td>");
                } else {
                    sb.append("<td  style=\"font-size: 14px\">" + i + "." + baseLabel.getText() + "：</td><td>");

                }
                sb.append("<table style=\"font-size: 14px\">");
                listchild = baseLabelService.getLabelChildren(baseLabel.getKeyss());
                sb.append("<tr>");
                for (BaseLabel childbaseLabel : listchild) {
                    if (baseLabel.getIsMust() == 1) {
                        sb.append("<td><input type=\"checkbox\" onclick=\"getDataMust(this);\" name=\"" + childbaseLabel.getParentKey() + "\" title=\"" + childbaseLabel.getText() + "\" value=\"" + childbaseLabel.getKeyss() + "\" />" + childbaseLabel.getText() + "&nbsp;</td>");
                    } else {
                        sb.append("<td><input type=\"checkbox\" onclick=\"getDataNotMust(this);\" name=\"" + childbaseLabel.getParentKey() + "\" title=\"" + childbaseLabel.getText() + "\" value=\"" + childbaseLabel.getKeyss() + "\" />" + childbaseLabel.getText() + "&nbsp;</td>");
                    }
                }

                if (baseLabel.getIsMust() == 1) {
                    sb.append("<td style=\"font-size: 12px;color:red\">" +
                            "<input type=\"hidden\" id=\"must" + baseLabel.getKeyss() + "\" value='' />" +
                            "<input type=\"hidden\" id=\"must" + baseLabel.getKeyss() + "name\" value='' />");
                    System.out.println("getKeyss"+ baseLabel.getKeyss());
                } else {
                    sb.append("<td style=\"font-size: 12px;color:red\">" +
                            "<input type=\"hidden\" id=\"notmust" + baseLabel.getKeyss() + "\" value='' />" +
                            "<input type=\"hidden\" id=\"notmust" + baseLabel.getKeyss() + "name\" value='' />");
                }
                sb.append("</td></tr>");
                sb.append("</table>");
                sb.append("</td>");
                sb.append("</tr>");
            }
        }
        return ResultSet.getSuccess(sb.toString());
    }

    //获得网易定义的城市标签
    @ResponseBody
    @RequestMapping("/get163LabelCity")
    public List<TreeViewItem> get163LabelCity() {
        List<TreeViewItem> list = baseLabelService.get163LabelCity();
        return list;
    }

    @ResponseBody
    @RequestMapping("/selectByType")
    public List<BaseLabel> selectByType(@Param("selectType") String selectType, @Param("selectValue") String selectValue, @Param("source") Integer source) {

        List<BaseLabel> list = baseLabelService.selectByType(selectType, selectValue, source);
        return list;
    }

    //通过来源和级别获取标签
    @ResponseBody
    @RequestMapping("/selectBySourceAndStep")
    public List<BaseLabel> selectBySourceAndStep(@Param("source") Integer source, @Param("step") Integer step) {
        List<BaseLabel> list = baseLabelService.selectBySourceAndStep(source, step);

        return list;
    }

    //通过来源获取所有标签（包括被禁止的）
    @ResponseBody
    @RequestMapping("/selectBySource")
    public JqgridResponse<BaseLabel> selectBySource(JqgridFilter filter, @Param("source") Integer source) {
        filter.refresh();
        List<BaseLabel> baseLabelList = baseLabelService.selectBySource(source);
        return JqgridResponseContext.getJqgridResponse(filter, baseLabelList);
    }

    //禁用或者启用某个标签
    @ResponseBody
    @RequestMapping("/updateIsValid")
    public ResultSet updateIsValid(@Param("id") String id, @Param("isValid") Integer isValid) {

        baseLabelService.updateIsValid(id, isValid);
        return ResultSet.getSuccess();
    }

    //禁用或者启用网易或自定义标签
    @ResponseBody
    @RequestMapping("/prohibitAll")
    public ResultSet prohibitAll(@Param("source") Integer source, @Param("isValid") Integer isValid) {


        baseLabelService.prohibitAll(source, isValid);
        return ResultSet.getSuccess();
    }
}
