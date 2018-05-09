<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String path = request.getContextPath(); %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <!-- jquery -->
    <script type="text/javascript" src="<%=path %>/js/jquery-3.2.1/jquery-3.2.1.js"></script>
    <!-- bootstrap -->
    <link rel="stylesheet" href="<%=path %>/js/boot/bootstrap/css/bootstrap-theme.min.css" >
    <link rel="stylesheet" href="<%=path %>/js/boot/bootstrap/css/bootstrap.min.css" >
    <script type="text/javascript" src="<%=path %>/js/boot/bootstrap/js/bootstrap.min.js"></script>
    <!-- treeview -->
    <link rel="stylesheet" href="<%=path %>/js/boot/bootstrap-treeview/dist/bootstrap-treeview.min.css" >
    <script type="text/javascript" src="<%=path %>/js/boot/bootstrap-treeview/dist/bootstrap-treeview.min.js"></script>
    <!-- tabs -->
    <link rel="stylesheet" href="<%=path %>/js/boot/bootStrap-addTabs/bootstrap.addtabs.css" >
    <script type="text/javascript" src="<%=path %>/js/boot/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>
    <!-- table -->
    <link rel="stylesheet" href="<%=path %>/js/boot/bootstrap-table/dist/bootstrap-table.css" >
    <script type="text/javascript" src="<%=path %>/js/boot/bootstrap-table/dist/bootstrap-table.js"></script>
    <!-- dialog -->
    <link rel="stylesheet" href="<%=path %>/js/boot/bootstrap-dialog/dist/css/bootstrap-dialog.css" >
    <script type="text/javascript" src="<%=path %>/js/boot/bootstrap-dialog/dist/js/bootstrap-dialog.js"></script>
    <!-- datetimepicker -->
    <link rel="stylesheet" href="<%=path %>/js/boot/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css" >
    <script type="text/javascript" src="<%=path %>/js/boot/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="<%=path %>/js/boot/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <!-- fileinput -->
    <link rel="stylesheet" href="<%=path %>/js/boot/bootstrap-fileinput/css/fileinput.css" >
    <script type="text/javascript" src="<%=path %>/js/boot/bootstrap-fileinput/js/fileinput.js"></script>
    <script type="text/javascript" src="<%=path %>/js/boot/bootstrap-fileinput/js/locales/zh.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12" style="background-color:red; height: 200px">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                            <img alt="Brand" src="<%=path %>/js/img/5.png" width="30px" height="30px">
                        </a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-2" style="background-color:orange; height: 770px">
            <div id="boottree"></div>

        </div>
        <div class="col-xs-10" style="background-color:yellow; height: 770px">
            <ul id="myTab" class="nav nav-tabs"></ul>
            <div class="tab-content"></div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function getTree(){
        var treedata = "";
        $.ajax({
            url:"<%=request.getContextPath()%>/login!getMenu.action",
            data:{"name":"123"},
            type:"post",
            dataType:"json",
            async:false,
            success:function(data){
                treedata = data;
            },
            error:function(){
                alert("查询出错");
            }
        });
        return treedata;
    }


    $("#boottree").treeview({
        data:getTree(),
        collapseIcon:"glyphicon glyphicon-star-empty",
        expandIcon:"glyphicon glyphicon-star",
        onNodeSelected: function(event, node) {
            if(node.nodes == undefined){
                if(node.url!=null){
                    $.ajax({
                        url:node.url,
                        type:"post",
                        dataType:"html",
                        success:function(data){
                            $.addtabs.add({
                                title:node.text,
                                content:data
                            })
                        }
                    })
                }
            }

        }
    })


</script>
</body>
</html>