<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <style>
        .modal .login-dialog {
            width: 900px;
            margin-left: 40%;
            margin-top: 10px;
        }

        .condition {
            float: left;
            clear: both;
            margin-left: 20px;
        }

        .title {
            font-size: 14px;
        }

        .item1 {
            float: left;
            clear: both;
            height: 28px;
            vertical-align: middle;
            line-height: 28px;
            width: 100%
        }

        .item2 {
            float: left;
            height: 35px;
            font-size: 13px
        }

        .item3 {
            float: left;
            clear: both;
            height: 27px;
            padding-top: 5px;
        }

        .item4 {
            height: 26px;
            width: 35px;
            font-size: 12px;
            vertical-align: middle;
            line-height: 26px;
            display: inline;
            float: left;
            border: solid red 1px;
            text-align: center
        }

        .item41 {
            height: 26px;
            width: 35px;
            font-size: 12px;
            vertical-align: middle;
            line-height: 26px;
            display: inline;
            float: left;
            border: solid green 1px;
            text-align: center;
            margin-left: 5px
        }

        .item42 {
            height: 26px;
            width: 35px;
            font-size: 12px;
            vertical-align: middle;
            line-height: 26px;
            display: inline;
            float: left;
            border: solid blue 1px;
            text-align: center;
            margin-left: 5px
        }

        .item5 {
            float: right;
            height: 40px;
            font-size: 16px;
            vertical-align: middle;
            line-height: 40px;
            clear: both;
        }

        .storename {
            height: 33px;
            font-size: 14px;
            vertical-align: middle;
            line-height: 33px;
            float: left;
            clear: both;
            padding-top: 3px;
        }

        .price {
            float: right;
            clear: both;
            height: 24px;
            padding-top: 5px;
            text-align: right !important;
            font-size: 14px !important;
        }

        .monthSale {
            float: left;
            clear: both;
            height: 24px;
            padding-top: 5px;
        }
        .categoryname
         {
             height: 27px;
             width: 110px;
             margin-left: 10px;
             display: inline-block;
             line-height: 30px;
             vertical-align: middle;
             text-align: center;
             background-color: transparent;
         }
        .threecategoryname
        {
            height: 27px;
            width: 110px;
            margin-left: 10px;
            display: inline-block;
            line-height: 30px;
            vertical-align: middle;
            text-align: center;
            background-color: transparent;
        }
        .twocategoryname
        {
            height: 27px;
            width: 110px;
            margin-left: 10px;
            display: inline-block;
            line-height: 30px;
            vertical-align: middle;
            text-align: center;
            background-color: transparent;
        }
        .twoItem {
            width: 100px;
            height: 27px;
            float: left;
            background-color: #fcfcfc;
            text-align: center;
            vertical-align: middle;
            line-height: 27px;
        }

        .propertyItem
        {
            width: 100px;
            height: 27px;
            float: left;
            line-height: 27px;
            vertical-align: middle;
            background-color: #fcfcfc;
            text-align: center;
        }
        .oneItem
        {
            width: 100px;
            height: 243px;
            float: left;
            text-align: center;
            background-color:#fcfcfc!important;
        }
        .allItem
        {
            width: 100px;
            float: left;
            height: 27px;
            line-height: 27px;
            vertical-align: middle;
            display: inline-block;
            text-align: center;
            color:red
        }
        .listItem
        {
            width: 750px;
            height: 250px;
            float: left;
            display: inline-block;
        }
        .listproperty
        {
            width: 850px;
            height: 27px;
            float: left;
            display: inline-block;
        }
        .TowCategory
        {
            width:900px;
            height: auto;
            float: left;
            display: inline-block;
            /*background-color: transparent;*/
        }
        .sortItem
        {
        width: 100px;
        height: 27px;
        float: left;
        line-height: 27px;
        vertical-align: middle;
        background-color:#fcfcfc!important;
        text-align: center;
        }
        .sortRight
        {
            width: 800px;
            height: 27px;
            float: left;
            display: inline-block;
            line-height: 27px;
            vertical-align: middle;
        }
        .CommissionRate
        {
            background-color: transparent;
            width: 60px;
            height: 27px;
            line-height: 27px;
            vertical-align: middle;
            display: inline-block;
            float: left;
            margin-left: 5px;
        }
        .Commission
        {
            background-color: transparent;
            width: 60px;
            height: 27px;
            line-height: 27px;
            vertical-align: middle;
            float: left;
            text-align: center;
        }
        .con1
        {
            background-color: transparent;
            width: 100px;
            height: 27px;
            line-height: 27px;
            vertical-align: middle;
            float: left;
            text-align: center;
            display: inline-block;
            margin-left: 15px;
        }
    </style>
    <title>京东推广商品</title>
</head>
<body class="nav-md">
<div class="right_col" role="main">
    <input type="hidden" value="0" id="parentId" name="parentId"/>
    <input type="hidden" value="0" id="grade" name="grade"/>
    <div class="container body">
        <div class="x_title">
            <input placeholder="请输入您要搜索的商品名或商品ID" type="text" id="txtkey" style="width: 400px"/>
            <input type="button" onclick="NextpageQuery('1');" value="搜 索"/>

            <div class="row" style="margin-top: 5px">
                <div class="oneItem">
                    一级类目
                </div>
                <div class="allItem" id="oneAll" onclick="ChangeOneAllColor();">
                    全部
                </div>
                <div id="category" class="listItem">

                </div>
            </div>
            <div class="row" style="display: none;" id="divCategory">
                <div class="twoItem" id="twoItem" >
                    二级类目
                </div>
                <div class="allItem" id="twoAllItem" onclick="changeTwoColor();">
                    全部
                </div>
                <div id="TowCategory" class="TowCategory"></div>
            </div>

            <div class="row" style="display: none; margin-top: 5px" id="threedivCategory">
                <div class="twoItem" id="threeItem">
                    三级类目
                </div>
                <div class="allItem" id="threeAllItem" onclick="changeThreeColor();">
                    全部
                </div>
                <div id="threeCategory" class="TowCategory"></div>
            </div>

            <div class="row" style="margin-top: 3px">
                <div class="propertyItem">
                    属性
                </div>
                <div class="allItem"  style="height:27px">
                   &nbsp;
                </div>
                <div class="listproperty">
                      <input type="checkbox" onclick="checkAttribute();" id="isCoupon" checked="checked" value="1" style="margin-top: 0px;vertical-align: middle">优惠券&nbsp;&nbsp;&nbsp;&nbsp;
                      <input type="checkbox" onclick="checkAttribute();" id="owner" value="g" style="margin-top: 0px;vertical-align: middle">自营&nbsp;&nbsp;&nbsp;&nbsp;
                      <input type="checkbox" onclick="checkAttribute();" id="isPG" value="1" style="margin-top: 0px;vertical-align: middle">拼购&nbsp;&nbsp;&nbsp;&nbsp;
                      <input type="checkbox" onclick="checkAttribute();" id="isHot" value="1" style="margin-top: 0px;vertical-align: middle">爆款
                </div>
            </div>
            <div class="row" style="margin-top: 3px">
                <div class="sortItem">
                    排序
                </div>
                <div class="allItem"  style="height:27px;text-align: right; padding-right: 10px;color: inherit">
                    综合
                </div>
                <div class="sortRight">
                    <a href="#" class="Commission" id="commission" onclick="checkSortName('commission');">佣金↓</a>
                    <a href="#"  class="CommissionRate" id="commissionShare" onclick="checkSortName('commissionShare');">佣金比例↓</a>
                    <input type="number" value="" min="1" max="80" placeholder="%" oninput="if(value < 1 || value > 80 ){alert('佣金比例只能输入1到80！');value = ''}"
                    id="commissionShareStart" name="commissionShareStart" style="height: 27px;width: 50px;
                    float:left;display: inline-block; text-align: right;margin-left: 8px" />
                     <label style="float:left;display: inline-block;">～</label>
                    <input type="number" value="" min="1" max="80" placeholder="%" oninput="if(value < 1 || value > 80 ){alert('佣金比例只能输入1到80！');value = ''}" id="commissionShareEnd" name="commissionShareEnd" style="height: 27px;width: 50px;
                    float:left;display: inline-block; text-align: right;" />

                    <div id="price" style="float:left;display: inline-block; margin-left: 20px" onclick="checkPrice();">价格</div>
                    <div style="width: 22px;height: 27px;float:left;display: inline-block; margin-left: 5px">
                        <div style="width: 22px; height: 13px;color:#cccccc; font-size: 7px;
                        text-align: center;vertical-align: bottom; margin-top: 0px;float:top;
                        line-height: 10px;padding-top: 2px" id="top" onclick="changeColor('top');">▲</div>
                        <div style="width: 22px; height: 13px;color:red; font-size: 7px;
                        margin-top: 0px;text-align: center;vertical-align: top;
                        line-height: 12px; padding-top: 0px;" id="bottom" onclick="changeColor('bottom');">▼</div>
                    </div>
                    <input type="number" value="" placeholder="￥" min="0.1" max="10000000" id="pricefrom" name="pricefrom" style="height: 27px;width: 50px;float:left;display: inline-block;" />
                    <div style="float:left;display: inline-block;">～</div>
                    <input type="number" value="" placeholder="￥" min="0.1" max="10000000" id="priceto" name="priceto" style="height: 27px;width: 50px;float:left;display: inline-block;" />

                    <a href="#" class="con1" id="inOrderCount30Days" onclick="checkSortName('inOrderCount30Days');">30天引入订单量↓</a>
                    <a href="#" class="con1" id="inOrderComm30Days" onclick="checkSortName('inOrderComm30Days');">30天支出佣金↓</a>
                </div>
            </div>
        </div>
        <div class="container" id="container1"></div>
    </div>
    <input type="hidden" id="sortName" value="price" />
    <input type="hidden" id="cid1" value="" />
    <input type="hidden" id="cid2" value="" />
    <input type="hidden" id="cid3" value="" />
    <input type="hidden" id="sort" value="desc" />
    <input type="hidden" id="pageIndex" value="1" />
</div>
<script>
    $(function () {
        getGoodsCategory();
        NextpageQuery('1');
    });
    //修改排序列
    function checkSortName(SortName) {
       $('#sortName').val(SortName);
       switch(SortName)
       {
           case 'commission':
               $('#commission').css("backgroundColor",'red');
               $('#commissionShare').css("backgroundColor",'inherit');
               $('#inOrderCount30Days').css("backgroundColor",'inherit');
               $('#inOrderComm30Days').css("backgroundColor",'inherit');
               $('#price').css("color",'inherit');
               break;
           case 'commissionShare':
               $('#commission').css("backgroundColor",'inherit');
               $('#commissionShare').css("backgroundColor",'red');
               $('#inOrderCount30Days').css("backgroundColor",'inherit');
               $('#inOrderComm30Days').css("backgroundColor",'inherit');
               $('#price').css("color",'inherit');
               break;
           case 'inOrderCount30Days':
               $('#commission').css("backgroundColor",'inherit');
               $('#commissionShare').css("backgroundColor",'inherit');
               $('#inOrderCount30Days').css("backgroundColor",'red');
               $('#inOrderComm30Days').css("backgroundColor",'inherit');
               $('#price').css("color",'inherit');
               break;
           case 'inOrderComm30Days':
               $('#commission').css("backgroundColor",'inherit');
               $('#commissionShare').css("backgroundColor",'inherit');
               $('#inOrderCount30Days').css("backgroundColor",'inherit');
               $('#inOrderComm30Days').css("backgroundColor",'red');
               $('#price').css("color",'inherit');
               break;
       }
        NextpageQuery('1');
    }
    //获得所有一级商品类目
    function getGoodsCategory() {
        var parentId = $('#parentId').val();
        var grade = $('#grade').val();
        $.ajax({
            url: "/JD/getGoodsCategory",
            dataType: 'json',
            cache: false,
            data: {parentId: parentId, grade: grade},
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//送到后台的中文数据就不会出现乱码
            success: function (result) {
                showCategory(result);
            },
            error: function (status, e) {
                alert("系统错误: " + e);
            }
        });
    }
     //选择一级类目
    function checkOne(id) {
        $('#cid1').val(id);
        var idStr="one"+id;
        //别人字体颜色变灰
        $(".categoryname").css('color','inherit');
        //自己的字体颜色变红
        $("#"+idStr).css('color','red');
        $("#oneAll").css('color','inherit');
       //获得二级目录
       $.ajax({
           url: "/JD/getGoodsCategory",
           dataType: 'json',
           cache: false,
           data: {parentId:id,grade: 1},
           type: 'POST',
           contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//送到后台的中文数据就不会出现乱码
           success: function (result) {
               showTowCategory(result);
           },
           error: function (status, e) {
               alert("系统错误: " + e);
           }
       });
        NextpageQuery('1');
   }
    //选择二级类目
    function checkTwo(id) {
        $('#cid2').val(id);
        var idStr="two"+id;
        //别人字体颜色变灰
        $(".twocategoryname").css('color','inherit');
        //自己的字体颜色变红
        $("#"+idStr).css('color','red');
        $("#twoAllItem").css('color','inherit');

        //获得三级目录
        $.ajax({
            url: "/JD/getGoodsCategory",
            dataType: 'json',
            cache: false,
            data: {parentId:id,grade: 2},
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//送到后台的中文数据就不会出现乱码
            success: function (result) {
                showThreeCategory(result);
            },
            error: function (status, e) {
                alert("系统错误: " + e);
            }
        });
        NextpageQuery('1');
    }
    //选择三级类目
    function checkThree(id) {
        $('#cid3').val(id);
        var idStr="three"+id;
        //别人字体颜色变灰
        $(".threecategoryname").css('color','inherit');
        //自己的字体颜色变红
        $("#"+idStr).css('color','red');
        $("#threeAllItem").css('color','inherit');

        NextpageQuery('1');
    }
    //展示二级类目
    function showTowCategory(result) {
       $('#divCategory').css("display","block");
       $('#threedivCategory').css("display","none");

       $('#TowCategory').html('');
       $('#threeCategory').html('');
       var html="";
       var items = result.data;
       var id="";
       $.each(items, function (index, item) {
            id="two"+item.id;
           html += "<a href=\"#\" id='"+id+"' class='twocategoryname' onclick=\"checkTwo('"+item.id+"')\">"+item.name+"</a>";
           }
       );
       $('#TowCategory').html(html);
       var height=$('#TowCategory').height();
       $('#twoItem').css("height",height);
       $('#twoAllItem').css("height",height);
        $('#twoAllItem').css("color",'red');
   }
    //展示三级类目
    function showThreeCategory(result) {
        $('#threedivCategory').css("display","block");
        $('#threeCategory').html('');
        var html="";
        var items = result.data;
        var id="";
        $.each(items, function (index, item) {
                id="three"+item.id;
                html += "<a href=\"#\" id='"+id+"' class='threecategoryname' onclick=\"checkThree('"+item.id+"')\">"+item.name+"</a>";
            }
        );
        $('#threeCategory').html(html);
        var height=$('#threeCategory').height();
        $('#threeItem').css("height",height);
        $('#threeAllItem').css("height",height);
        $('#threeAllItem').css("color",'red');
    }
    //查询商品
    function Query() {
        var cid1=$('#cid1').val();
        var cid2=$('#cid2').val();
        var cid3=$('#cid3').val();
        var pageIndex=$('#pageIndex').val();
        var pageSize=20;
        //var skuIds;
        var keyword=$('#txtkey').val();
        var pricefrom=$('#pricefrom').val();
        var priceto=$('#priceto').val();
        var commissionShareStart=$('#commissionShareStart').val();
        var commissionShareEnd=$('#commissionShareEnd').val();
        //排序字段(price：单价, commissionShare：佣金比例, commission：佣金，
        // inOrderCount30Days：30天引单量， inOrderComm30Days：30天支出佣金)
        var sortName=$('#sortName').val();
        //是升序还是降序
        var sort=$('#sort').val();

        //商品类型：自营[g]，POP[p]
        var owner;
        if($("#owner").is(':checked'))
        {
            owner=$("#owner").val();
        }
        // else
        // {
        //     owner="p";
        // }
        //是否是优惠券商品，1：有优惠券，0：无优惠券
        var isCoupon;
        if($("#isCoupon").is(':checked'))
        {
            isCoupon=$("#isCoupon").val();
        }
        // else
        // {
        //     isCoupon="0";
        // }
        //是否是拼购商品，1：拼购商品，0：非拼购商品
        var isPG;
        if($("#isPG").is(':checked'))
        {
            isPG=$("#isPG").val();
        }
        // else
        // {
        //     isPG="0";
        // }
        //是否是爆款，1：爆款商品，0：非爆款商品
        var isHot;
        if($("#isHot").is(':checked'))
        {
            isHot=$("#isHot").val();
        }
        // else
        // {
        //     isHot="0";
        // }
         //拼购价格区间开始
         //var pingouPriceStart;
         //拼购价格区间结束
         //var pingouPriceEnd;
        //品牌code
        // var brandCode;
        // 店铺Id
        // var shopId;
        $("#container1").html('');
        $.ajax({
            url: "/JD/goodsQuery",
            dataType: 'json',
            cache: false,
            data: {
                 cid1:cid1,
                 cid2:cid2,
                 cid3:cid3,
                 pageIndex:pageIndex,
                 pageSize:pageSize,
                 keyword:keyword,
                 pricefrom:pricefrom,
                 priceto:priceto,
                 commissionShareStart:commissionShareStart,
                 commissionShareEnd:commissionShareEnd,
                 sortName:sortName,
                 sort:sort,
                 owner:owner,
                 isCoupon:isCoupon,
                 isPG:isPG,
                 isHot:isHot
            },
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//送到后台的中文数据就不会出现乱码
            success: function (result) {
                showList(result,pageSize);
            },
            error: function (status, e) {
                alert("系统错误: " + e);
            }
        });
    }
    //展示一级类目
    function showCategory(result) {
        var items = result.data;
        var html = "";
        var balance = -1;
        var url = "";
        var name = "";
        var length = items.length;
        var id="";
        $.each(items, function (index, item) {
                id="one"+item.id
                if (length - 1 == index) {
                    html += " <a href=\"#\" id='"+id+"' class='categoryname' onclick=\"checkOne('"+item.id+"')\">"+item.name+"</a>";
                    html += "</div>";
                }
                else {
                    balance = index % 5;
                    if (balance == 0) {
                        html += "<div class=\"row\">";
                        html += " <a href=\"#\" id='"+id+"' class='categoryname' onclick=\"checkOne('"+item.id+"')\">"+item.name+"</a>";

                    }
                    else if (balance == 4) {

                        html += " <a href=\"#\" id='"+id+"' class='categoryname' onclick=\"checkOne('"+item.id+"')\">"+item.name+"</a>";
                        html += "</div>";

                    }
                    else {
                        html += " <a href=\"#\" id='"+id+"' class='categoryname' onclick=\"checkOne('"+item.id+"')\">"+item.name+"</a>";

                    }
                }

            }
        );
        $("#category").html(html);
    }
    //打开选择商户
    function openChooseMerchant(goodsId, materialId, couponUrl) {
        var dialog = BootstrapDialog.show({
            type: BootstrapDialog.TYPE_DEFAULT,
            title: "<span style=\"color:#73879C\">选择联合营销商户</span>",
            closable: false,
            draggable: true,
            cssClass: 'login-dialog',
            message: $('<div></div>').load('${ctx}/template/JD/merchantChoose.jsp'),//加载弹出页面
            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
            onshown: function () {
                $('#goodsId').val(goodsId);
                $('#materialId').val(materialId);
                $('#couponUrl').val(couponUrl);

            },
            //数据回显
            buttons: [
                {
                    label: '生成营销方案',
                    icon: 'fa fa-check-circle',
                    cssClass: 'btn-primary',
                    action: function (dialogItself) {
                        if (checkBox.length == 0) {
                            getCode('check', "请选择要营销的企业!");
                        } else {

                            var json = {
                                materialId: $("#materialId").val(),
                                couponUrl: $("#couponUrl").val(),
                                goodsId: $("#goodsId").val()
                            }

                            $.ajax({
                                url: "${ctx}/marketingPlan/addMarketingPlanByJD",
                                type: "post",
                                data: {
                                    "merchants": JSON.stringify(checkBox),
                                    "good": JSON.stringify(json)
                                },
                                cache: false,
                                success: function (response) {
                                    if (response.code == 200) {
                                        dialogItself.close();
                                        getCode('add', "成功生成营销方案!");
                                        $('#jqGrid').trigger('reloadGrid');
                                    } else {
                                        getCode('add', "营销方案生成失败!");
                                    }
                                },
                                error: function (textStatus, e) {
                                    getCode('add', "系统ajax交互错误!")

                                }
                            });
                        }

                    }
                },
                {
                    label: '关闭',
                    icon: 'fa fa-close',
                    action: function (dialogItself) {
                        dialogItself.close();
                    }
                }]
        });
    }
    //展示已经类目
    function showList(result,pageSize) {
        var items = result.data;
        var html = "";
        var balance = -1;
        var url = "";
        var name = "";
        var storename = "";
        var commission = "";
        var commissionShare = "";
        var price = 0;
        var length = items.length;
        var skuId = "";
        var owner = "";
        var materialUrl = "";
        var tempmaterialUrl = "";
        var couponUrl = "";
        var couponList = [];
        $.each(items, function (index, item) {
                url = item.imageInfo[0].imageList[0].url;
                name = item.skuName;
                storename = item.shopInfo[0].shopName;
                commission = item.commissionInfo[0].commission;
                commissionShare = item.commissionInfo[0].commissionShare;
                price = item.priceInfo[0].price;
                skuId = item.skuId;
                owner = item.owner;
                materialUrl = "https://" + item.materialUrl;
                tempmaterialUrl = item.materialUrl;
                couponList = item.couponInfo[0].couponList
                if (couponList.length > 0) {
                    couponUrl = item.couponInfo[0].couponList[0].link;
                }
                else {
                    couponUrl = "";
                }

                if (length - 1 == index) {
                    html += "<a href='" + materialUrl + "' target='_blank'><div class=\"col-sm-6 col-md-3\">" +
                        "                <div class=\"thumbnail\" style=\"height: 515px\">" +
                        "                    <img style=\"margin-top: 2px\" src='" + url + "' alt=\"商品图片\"/>" +
                        "                    <div class=\"item1\"><label style=\"float: left\">佣金：￥" + commission + "</label>  <label style=\"float: right\">佣金比例：" + commissionShare + "%</label></div>" +
                        "                    <div id=\"name1\" class=\"item2\">" + name + "</div>" +
                        "                    <div class=\"price\">￥" + price + "</div>" +
                        "                    <div class=\"monthSale\">月销：" + item.inOrderCount30Days + "</div>" +
                        "                    <div class=\"item3\">" +
                        "                            <div class=\"item4\">自营</div>" +
                        "                            <div class=\"item41\" >京配</div>" +
                        "                            <div class=\"item42\">通用</div>" +
                        "                    </div>" +
                        "                    <div id=\"store2\"  class=\"storename\">" + storename + "</div>" +
                        "                    <div class=\"item5\">" +
                        // "                        <a href=\"#\" class=\"btn btn-default\" role=\"button\">我要推广</a>" +
                        "                        <a href=\"#\" class=\"btn btn-default\" role=\"button\" onclick=\"openChooseMerchant('" + skuId + "','" + tempmaterialUrl + "','" + couponUrl + "');\">购买</a>" +
                        "                    </div>" +
                        "                </div>" +
                        "            </div></a>";
                    html += "</div>";
                }
                else {
                    balance = index % 4;
                    if (balance == 0) {
                        html += "<div class='row'>";
                        html += "<a href='" + materialUrl + "' target='_blank'><div class=\"col-sm-6 col-md-3\">" +
                            "                <div class=\"thumbnail\" style=\"height: 515px\">" +
                            "                    <img style=\"margin-top: 2px\" src='" + url + "' alt=\"商品图片\"/>" +
                            "                    <div class=\"item1\"><label style=\"float: left\">佣金：￥" + commission + "</label>  <label style=\"float: right\">佣金比例：" + commissionShare + "%</label></div>" +
                            "                    <div id=\"name1\" class=\"item2\">" + name + "</div>" +
                            "                    <div class=\"price\">￥" + price + "</div>" +
                            "                    <div class=\"monthSale\">月销：" + item.inOrderCount30Days + "</div>" +
                            "                    <div class=\"item3\">" +
                            "                            <div class=\"item4\">自营</div>" +
                            "                            <div class=\"item41\">京配</div>" +
                            "                            <div class=\"item42\">通用</div>" +
                            "                    </div>" +
                            "                    <div id=\"store2\" class=\"storename\">" + storename + "</div>" +
                            "                    <div class=\"item5\">" +
                            //"                        <a href=\"#\" class=\"btn btn-default\" role=\"button\">我要推广</a>" +
                            "                        <a href=\"#\" class=\"btn btn-default\" role=\"button\" onclick=\"openChooseMerchant('" + skuId + "','" + tempmaterialUrl + "','" + couponUrl + "');\">购买</a>" +
                            "                    </div>" +
                            "                </div>" +
                            "            </div></a>";
                    }
                    else if (balance == 3) {

                        html += "<a href='" + materialUrl + "' target='_blank'><div class=\"col-sm-6 col-md-3\">" +
                            "                <div class=\"thumbnail\" style=\"height: 515px\">" +
                            "                    <img style=\"margin-top: 2px\" src='" + url + "' alt=\"商品图片\"/>" +
                            "                    <div class=\"item1\"><label style=\"float: left\">佣金：￥" + commission + "</label>  <label style=\"float: right\">佣金比例：" + commissionShare + "%</label></div>" +
                            "                    <div id=\"name1\" class=\"item2\">" + name + "</div>" +
                            "                    <div class=\"price\">￥" + price + "</div>" +
                            "                    <div class=\"monthSale\">月销：" + item.inOrderCount30Days + "</div>" +
                            "                    <div class=\"item3\">" +
                            "                            <div class=\"item4\">自营</div>" +
                            "                            <div class=\"item41\">京配</div>" +
                            "                            <div class=\"item42\">通用</div>" +
                            "                    </div>" +
                            "                    <div id=\"store2\" class=\"storename\">" + storename + "</div>" +
                            "                    <div class=\"item5\">" +
                            //"                        <a href=\"#\" class=\"btn btn-default\" role=\"button\">我要推广</a>" +
                            "                        <a href=\"#\" class=\"btn btn-default\" role=\"button\" onclick=\"openChooseMerchant('" + skuId + "','" + tempmaterialUrl + "','" + couponUrl + "');\">购买</a>" +
                            "                    </div>" +
                            "                </div>" +
                            "            </div></a>";
                        html += " </div>";

                    }
                    else {
                        html += " <a href='" + materialUrl + "' target='_blank'> <div class=\"col-sm-6 col-md-3\">" +
                            "                <div class=\"thumbnail\" style=\"height: 515px\">" +
                            "                    <img style=\"margin-top: 2px\" src='" + url + "' alt=\"商品图片\"/>" +
                            "                    <div class=\"item1\"><label style=\"float: left\">佣金：￥" + commission + "</label>  <label style=\"float: right\">佣金比例：" + commissionShare + "%</label></div>" +
                            "                    <div id=\"name1\" class=\"item2\">" + name + "</div>" +
                            "                    <div class=\"price\">￥" + price + "</div>" +
                            "                    <div class=\"monthSale\">月销：" + item.inOrderCount30Days + "</div>" +
                            "                    <div class=\"item3\">" +
                            "                            <div class=\"item4\">自营</div>" +
                            "                            <div class=\"item41\">京配</div>" +
                            "                            <div class=\"item42\">通用</div>" +
                            "                    </div>" +
                            "                    <div id=\"store2\"  class=\"storename\">" + storename + "</div>" +
                            "                    <div class=\"item5\">" +
                            //"                        <a href=\"#\" class=\"btn btn-default\" role=\"button\">我要推广</a>" +
                            "                        <a href=\"#\" class=\"btn btn-default\" role=\"button\" onclick=\"openChooseMerchant('" + skuId + "','" + tempmaterialUrl + "','" + couponUrl + "');\">购买</a>" +
                            "                    </div>" +
                            "                </div>" +
                            "            </div></a>";
                    }
                }

            }
        );
        if (html != "") {
            debugger;
             //翻页的控制
            var count=result.totalCount;
            // 总页数
            var pageCount=0;
            //当前页
            var currentIndex=parseInt($('#pageIndex').val());
            var pagebalance=count%pageSize;
            if(pagebalance>0)
            {
                pageCount=Math.floor(count/pageSize)+1;
            }
            else
            {
                pageCount=Math.floor(count/pageSize);
            }
            //上一页
            var pre=currentIndex-1;
            if(pre<=0)
            {
                pre=currentIndex;
            }
            //下一页
            var next=currentIndex+1;
            if(next>pageCount)
            {
                next=pageCount;
            }
            var prenext1=pre+1;
            if(prenext1>=pageCount)
            {
                prenext1=0;
            }
            var prenext2=prenext1+1;
            if(prenext2>=pageCount)
            {
                prenext2=0;
            }
            var prenext3=prenext2+1;
            if(prenext3>=pageCount)
            {
                prenext3=0;
            }
            var beforenext1=next-1
            if(beforenext1<=1)
            {
                beforenext1=0;
            }
            var beforenext2=beforenext1-1;
            if(beforenext2<=1)
            {
                beforenext2=0;
            }
            var beforenext3=beforenext2-1;
            if(beforenext3<=1)
            {
                beforenext3=0;
            }
            //去掉重叠的
            if(beforenext3<=prenext3)
            {
                beforenext3=0;
            }
            if(beforenext2<=prenext3)
            {
                beforenext2=0;
            }
            if(beforenext1<=prenext3)
            {
                beforenext1=0;
            }
            if(beforenext1==prenext1|| beforenext1==prenext2||beforenext1==prenext3)
            {
                beforenext1=0;
            }
            if(beforenext2==prenext1|| beforenext2==prenext2||beforenext2==prenext3)
            {
                beforenext2=0;
            }

            if(beforenext3==prenext1|| beforenext3==prenext2||beforenext3==prenext3)
            {
                beforenext3=0;
            }


            html += "<nav aria-label=\"Page navigation example\" style=\"float: right; margin-bottom: 0px;clear: both;margin-right: 2px;\">"
                + "<ul class=\"pagination\">"
                + "<li class=\"page-item\"><a class=\"page-link\" onclick=\"NextpageQuery('"+pre+"');\"  href=\"#\">上一页</a></li>";
            if(prenext1!=0)
            {
                html += "<li class=\"page-item\"><a  onclick=\"NextpageQuery('"+prenext1+"');\" class=\"page-link\" href=\"#\">"+prenext1+"</a></li>";
            }

            if(prenext2!=0)
            {
                html += "<li class=\"page-item\"><a onclick=\"NextpageQuery('"+prenext2+"');\" class=\"page-link\" href=\"#\">"+prenext2+"</a></li>";
            }

            if(prenext3!=0)
            {
                html += "<li class=\"page-item\"><a onclick=\"NextpageQuery('"+prenext3+"');\" class=\"page-link\" href=\"#\">"+prenext3+"</a></li>";
            }
            html +=  "<li class=\"page-item\"><a  class=\"page-link\" href=\"#\">......</a></li>"

            if(beforenext3!=0)
            {
                html += "<li class=\"page-item\"><a onclick=\"NextpageQuery('"+beforenext3+"');\" class=\"page-link\" href=\"#\">"+beforenext3+"</a></li>";
            }

            if(beforenext2!=0)
            {
                html += "<li class=\"page-item\"><a onclick=\"NextpageQuery('"+beforenext2+"');\" class=\"page-link\" href=\"#\">"+beforenext2+"</a></li>";
            }

            if(beforenext1!=0)
            {
                html += "<li class=\"page-item\"><a onclick=\"NextpageQuery('"+beforenext1+"');\" class=\"page-link\" href=\"#\">"+beforenext1+"</a></li>";
            }
            html += "<li class=\"page-item\"><a class=\"page-link\" onclick=\"NextpageQuery('"+next+"');\" href=\"#\">下一页</a></li>";
            html += "<li class=\"page-item\" ><a  class=\"page-link\" href=\"#\">总页数："+pageCount+"</a></li>";
            html +=  "</ul>";
            html +=  "</nav>";
        }
        $("#container1").html(html);
    }
    function checkPrice() {
        $('#price').css("color",'red');
        $('#commission').css("backgroundColor",'inherit');
        $('#commissionShare').css("backgroundColor",'inherit');
        $('#inOrderCount30Days').css("backgroundColor",'inherit');
        $('#inOrderComm30Days').css("backgroundColor",'inherit');
        $('#SortName').val('price');
        var color=$("#top").css("color");
        if(color=='rgb(204, 204, 204)')
        {
            $('#top').css('color',"red");
            $('#bottom').css('color',"#cccccc");
            $('#sort').val('asc');
        }
        else
        {
            $('#top').css('color',"#cccccc");
            $('#bottom').css('color',"red");
            $('#sort').val('desc');
        }
        NextpageQuery('1');
    }
    function checkAttribute() {
        NextpageQuery('1');
    }
    //改变排序
    function changeColor(id) {
        $('#SortName').val('price');
        if(id=='top')
        {
            var color=$("#top").css("color");
            if(color=='rgb(204, 204, 204)')
            {
                $('#top').css('color',"red");
                $('#bottom').css('color',"#cccccc");
                $('#sort').val('asc');
            }
            else
            {
                $('#top').css('color',"#cccccc");
                $('#bottom').css('color',"red");
                $('#sort').val('desc');
            }
        }
        else
        {
            var color=$("#bottom").css("color");
            if(color=='rgb(204, 204, 204)')
            {
                $('#bottom').css('color',"red");
                $('#top').css('color',"#cccccc");
                $('#sort').val('desc');
            }
            else
            {
                $('#top').css('color',"red");
                $('#bottom').css('color',"#cccccc");
                $('#sort').val('asc');
            }
        }
        NextpageQuery('1');
    }
    function ChangeOneAllColor() {
        $('#cid1').val('');
        $('#cid2').val('');
        $('#cid3').val('');
        $('#oneAll').css('color','red');
        $(".categoryname").css('color','inherit');
        NextpageQuery('1');
    }
    function changeTwoColor() {
        $('#cid2').val('');
        $('#cid3').val('');
        $('#twoAllItem').css('color','red');
        $(".twocategoryname").css('color','inherit');
        NextpageQuery('1');
    }
    function changeThreeColor() {
        $('#cid3').val('');
        $('#threeAllItem').css('color','red');
        $(".threecategoryname").css('color','inherit');
        NextpageQuery('1');
    }
    function NextpageQuery(pageindex) {
        $('#pageIndex').val(pageindex);
        Query();
    }
</script>
</body>
</html>
