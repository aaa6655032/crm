<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/14
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
    <%@ include file="common.jsp" %>
    <script type="text/javascript" src="/js/views/department.js"></script>
</head>
<body>
<table id="department_datagrid"></table>
<div id="department_datagrid_btn">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="department_searchForm">
            关键字:<input type="text" name="keyword">

            状态:
            <select name="state">
                <option value="">全部</option>
                <option value="1">正常</option>
                <option value="0">停用</option>
            </select>
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
        </form>
    </div>
</div>
<div id="department_dialog">
    <form id="department_dialog_form" method="post">
        <input type="hidden" name="id"/>
        <table align="center">
            <tr>
                <td>部门编号</td>
                <td><input name="sn"/></td>
            </tr>
            <tr>
                <td>部门名称</td>
                <td><input name="name"/></td>
            </tr>
            <tr>
                <td>部门经理</td>
                <td><select name="manager.id" id="department_manager_combogrid" style="width: 150px;"></select>
                </td>
            </tr>
            <tr>
                <td>父级部门</td>
                <td><select name="parent.id" class="easyui-combotree" id="department_role_combotree"
                            data-options="url:'/department_menu'" style="width:150px;" ></select>
                </td>
            </tr>

        </table>
    </form>
    <div id="department_dialog_bb">
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>


</body>
</html>
