
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<html>
<head>
    <title>Insert title here</title>
    <!-- jquery -->
    <script type="text/javascript" src="<%=path %>/js/jquery-3.2.1/jquery-3.2.1.js"></script>
    <link rel="shortcut icon" href="#" />
    <!--easyui-->
    <script type="text/javascript" src="<%=path %>/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path %>/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/js/easyui/themes/icon.css">
</head>
<body>
<table id="wtcheckee" border="1" bgcolor="#0099ff"></table>
<div id="wtcheckaa">
    <a href="javascript:wtaddCheck()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
</div>
<div id="wtcheckdd"></div>
<script type="text/javascript">
    //查询会员方法
    $('#wtcheckee').datagrid({
        url:'<%=path%>/wt!getMenu.action',
        columns:[[
            {field:'',title:'',checkbox:true},
            {field:'memberid',title:'主键Id',width:52 },
            {field:'membernum',title:'会员帐号',width:52 },
            {field:'membername',title:'会员姓名',width:52 },
            {field:'memberdj',title:'会员等级',width:52 },
            {field:'memberjf',title:'会员积分 ',width:52 },
            {field:'memberflag',title:'会员状态',width:52},
            {field:'memberdate',title:'创建日期',width:52 },
            {field:'membersex',title:'会员性别',width:52 },
            {field:'memberphone',title:'手机号 ',width:52 },
            {field:'memberidcard',title:'身份证号 ',width:52 }
        ]],
        //分页
        fit:true,
        //fitColumns:true,
        striped:true,
        pagination:true,
        //singleSelect:true,
        ctrlSelect:true,
        pageList:[5,10,15,20],
        toolbar:'#wtcheckaa',

    });
</script>
<script type="text/javascript">
    //新增或修改
    $(function (){
        wtaddCheck();
    })
    function wtaddCheck(){
        $('#wtcheckdd').dialog({
            title: "寄存录入",
            width: 700,
            height: 500,
            closed: false,
            cache: false,
            href: "<%=path%>/wt/toaddshare.do",
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    $("#wtaddForm").form('submit',{
                        url:"<%=path%>/wt/wtaddCheck.do",
                        onSubmit:function(){
                            var isValid = $(this).form('validate');
                            if(!isValid){
                                $.messager.alert("提示",'输入有误！请检查输入！');
                                return false;
                            }
                        },
                        success:function(data){
                            var data = eval('(' + data + ')');
                            if(data.success){
                                $.messager.alert("提示",data.msg);
                                $('#wtcheckdd').dialog('close');
                                $('#wtcheckee').datagrid('load');
                            }else{
                                $.messager.alert("提示",data.msg);
                            }
                        }
                    });
                }
            }]


        });
    }

</script>
</body>
</html>
