<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/18
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@ include file="common.jsp" %>
    <script type="text/javascript" src="/js/views/systemDictionary.js"></script>

    <title>Title</title>
</head>
<body>
<div id="cc" class="easyui-layout" style="width:600px;height:400px;" fit="true">
    <div data-options="region:'west',title:'数据字典'" style="width:550px;">

        <table id="dictionary_datagrid"></table>


    </div>
    <div data-options="region:'center',iconCls:'icon-reload',title:'数据字典明细'" style="width:600px;">
        <table id="dictionaryItem_datagrid"></table>
        <div id="dictionaryItem_btn">
            <a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
            <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">编辑</a>
            <a id="forbiddenId" class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="forbidden">禁用</a>
            <a  class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">删除</a>
            <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
        </div>
    </div>

    <div id="dictionaryItem_dialog">
        <form id="dictionaryItem_dialog_form" method="post">
            <input type="hidden" name="id"/>
            <input type="hidden" name="dict.id"/>
            <table>
                <tr>
                    <td>字典目录</td>
                    <td><input name="dict.name" disabled="true"/></td>
                </tr>

                <tr>
                    <td>字典明细名称</td>
                    <td><input name="name"/></td>
                </tr>
                <tr>
                    <td>字典明细简介</td>
                    <td><textarea name="intro" style="width: 250px;height: 150px;"></textarea></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="dictionaryItem_bb">
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>

    </div>

</div>


</body>
</html>
