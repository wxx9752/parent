<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <% String path = request.getContextPath(); %>
            <link href="<%=path %>/js/easyui_full.css" rel="stylesheet" type="text/css">
            <script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
            <script type="text/javascript" src="<%=path %>/js/jquery.easyui-1.5.1.min.js"></script>
            <script type="text/javascript" src="<%=path %>/js/insdep-extend.min.js"></script>
<body>



<div id="tiaocha" class="easyui-layout" style="width:600px;height:400px;" data-options="fit:true">
    <div data-options="region:'north',title:'条件查询',split:true" style="height:100px;">
        分店：
        <input id = "brandOfficeid" name="brandOfficeId" >

        员工姓名：
        <input id = "employeename" name="employeeName" class="easyui-textbox">
        员工状态：
        <select name = "employeeState" id = "employeestate"  class="easyui-combobox" style="width:150px;" name = "employeeState">
            <option value = "2">请选择
            <option value = "1">工作中
            <option value = "0">休息中


        </select>

        员工等级：<select id = "employeelevel"  class="easyui-combobox" style="width:150px;" name = "employeeLevel">
        <option value = "0">请选择
        <option value = "2">普通员工
        <option value = "1">高级员工


    </select>


        <input type="button" class="easyui-linkbutton" value="查询" onclick="search()">
    </div>
    <div data-options="region:'center',title:'数据展示'" >
        <table id="employeeTable" class="easyui-datagrid"  data-options="fit:true"></table>
    </div>

</div>




<div id="addDiv"></div>



<script type="text/javascript">
















    $(function(){
        queryData();
    })

    function queryData()
    {
        $('#employeeTable').datagrid({
            url:'<%=path%>/test!toShow.action',
            queryParams:{
                "employeeName":$("#employeename").val(),
                "employeeState":$("#employeestate").val(),
                "employeeLevel":$("#employeelevel").val(),
                "brandOfficeId":$("#brandOfficeid").val()
            },
            fitColumns:true,
            pagination:true,
            height:546,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,7],
            columns:[[
                {field:'box',checkbox:true},
                {field:'jinprice',title:'进价',width:100,align:'center'},
                {field:'goodsprice',title:'商品价格',width:50,align:'center'},
                {field:'goodsname',title:'商品名称',width:50,align:'center'



                },

                {field:'profit',title:'利润',width:50,align:'center'},
                {field:'cwdate',title:'处理时间',width:50,align:'center'},
                {field:'membernum',title:'会员账号',width:50,align:'center',


                },
                {field:'membernum',title:'订单号',width:50,align:'center'},





                {field:'State',title:'删除订单',width:50,align:'center',
                    formatter: function(value,row,index){
                        return "<a href='javascript:frozen2("+row.employeeId+")'>开除</a>";
                    }
                },

            ]],
            onLoadSuccess:function(data){
                $(".btn").linkbutton({
                    iconCls: 'icon-remove'
                })
            },
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#addDiv').dialog({
                        title: '新增员工',
                        width: 300,
                        height:400,
                        closed: false,
                        cache: false,
                        href:'<%=path%>/jumpemp/jumpToAddemp.do',
                        modal: true,
                        buttons:[{
                            text:'新增员工信息',
                            handler:function(){
                                /* 									var userAddres = $('#provinces').combobox('getText')+$('#city').combobox('getText')+$('#area').combobox('getText')+$("#addres").val();
                                 */

                                $.ajax({
                                    url:'<%=path%>/employee/addemp.do',
                                    type:'post',
                                    data:$("#addemp").serialize(),
                                    dataType:'text',
                                    async:false,
                                    success:function(result){

                                        $('#addDiv').dialog("close");
                                        $('#employeeTable').datagrid("reload");

                                    },
                                    error:function(){
                                        $.messager.alert('Warning','Addfail,dataSendFail');
                                    }
                                })
                            }
                        }]
                    });
                }
            },'-',{
                iconCls: 'icon-edit',
                handler: function(){
                    var id = $("#employeeTable").datagrid("getSelected").employeeId;

                    $('#addDiv').dialog({
                        title: 'updatePage',
                        width: 300,
                        height:400,
                        closed: false,
                        cache: false,
                        href:"<%=path%>/employee/queryEmpbyId.do?employeeId="+id,
                        modal: true,
                        buttons:[{
                            text:'update',
                            handler:function(){

                                $.ajax({
                                    url:"<%=path%>/employee/updateEmp.do",
                                    type:"post",
                                    data:$("#updateemp").serialize(),
                                    dataType:"text",
                                    async:false,
                                    success:function(result){

                                        $('#addDiv').dialog("close");
                                        $('#employeeTable').datagrid("reload");

                                    },
                                    error:function(){
                                        $.messager.alert('warning','UpdateFail,dataSendFail');
                                    }
                                })
                            }
                        }]
                    });
                }
            }]
        });
    }

    function frozen1(id)
    {
        $.ajax({
            url:"<%=path%>/employee/employeestat.do",
            type:"post",
            data:{"id":id},
            dataType:"text",
            async:false,
            success:function(result){

                $('#employeeTable').datagrid("reload");

            },
            error:function(){
                $.messager.alert('warning','FrozenFail,dataSendFail');
            }
        })
    }
    function frozen3(id)
    {
        $.ajax({
            url:"<%=path%>/employee/employeestat1.do",
            type:"post",
            data:{"id":id},
            dataType:"text",
            async:false,
            success:function(result){

                $('#employeeTable').datagrid("reload");

            },
            error:function(){
                $.messager.alert('warning','FrozenFail,dataSendFail');
            }
        })
    }





    function frozen2(id)
    {
        $.ajax({
            url:"<%=path%>/employee/delemployee.do",
            type:"post",
            data:{"id":id},
            dataType:"text",
            async:false,
            success:function(result){

                $('#employeeTable').datagrid("reload");

            },
            error:function(){
                $.messager.alert('warning','FrozenFail,dataSendFail');
            }
        })
    }



    $('[name="brandOfficeId"]').combobox({
        url:'<%=path%>/employee/queryEmpbyBar.do',
        valueField:'brandOfficeId',
        textField:'brandOfficeName'
    });





    function search(){

        queryData();



    }













</script>






</body>
</html>
