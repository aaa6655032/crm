$(function () {
    var departmentDialog, departmentDatagrid, departmentDialogForm, departmentDatagridBtn, departmentRoleCombotree, departmentManagerCombogrid;
    departmentDialog = $("#department_dialog");
    departmentDatagrid = $("#department_datagrid");
    departmentDialogForm = $("#department_dialog_form");
    departmentDatagridBtn = $("#department_datagrid_btn a");
    departmentManagerCombogrid = $("#department_manager_combogrid");
    departmentRoleCombotree = $("#department_role_combotree");

    // 显示管理员名称
    function managerFormatter(value, record, index) {
        if (value) {
            return value.username;
        } else {
            return null;

        }
    }

    // 显示父部门名称
    function parentFormatter(value, record, index) {
        if (value) {
            return value.name;

        } else {
            return null;
        }
    }

    function stateFormatter(value, record, index) {
        if (value) {
            return "<font color='green'>正常</font>"

        } else {
            return "<font color='red'>停用</font>";
        }
    }


    departmentDatagrid.datagrid({
        url: "/department_list",
        fit: true,
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        pageList: [1, 5, 10, 20],
        toolbar: "#department_datagrid_btn",
        onClickRow: function (rowIndex, rowData) {
            if (rowData.state) {
                departmentDatagridBtn.eq(1).linkbutton("enable");
                departmentDatagridBtn.eq(2).linkbutton("enable");
            } else {
                departmentDatagridBtn.eq(1).linkbutton("disable");
                departmentDatagridBtn.eq(2).linkbutton("disable");
            }
        },
        columns: [[
            {field: "sn", title: "部门编号", width: 1, align: "center"},
            {field: "name", title: "部门名称", width: 1, align: "center"},
            {field: "manager", title: "部门经理", width: 1, align: "center", formatter: managerFormatter},
            {field: "parent", title: "父级部门", width: 1, align: "center", formatter: parentFormatter},
            {field: "state", title: "状态", width: 1, align: "center", formatter: stateFormatter}
        ]]

    });


    departmentDialog.dialog({
        width: 300,
        height: 300,
        buttons: "#department_dialog_bb",
        closed: true

    });


    departmentManagerCombogrid.combogrid({
        panelWidth: 400,
        idField: 'id',
        textField: 'username',
        url: '/manager_list',
        method: 'get',
        columns: [[
            {field: "username", title: "用户名", width: 80},
            {field: "realname", title: "真实姓名", width: 80},
            {field: "email", title: "邮箱", width: 120},
            {field: "dept", title: "部门", width: 80, formatter: departmentFormatter},
        ]]
    })

    function departmentFormatter(value, record, index) {
        if (value) {
            return value.name;
        } else {
            return value;
        }
    }


    // 获取按钮的点击事件
    $("a").on("click", function () {

        var cmd = $(this).data("cmd");
        console.log(cmd);
        console.log(cmdObj[cmd])
        if (cmd) {
            cmdObj[cmd]();
        }
    });


    var cmdObj = {

        add: function add() {

            // 打开新增对话框
            departmentDialog.dialog("open");
            // 设置标题为新增
            departmentDialog.dialog("setTitle", "新增");
            // 清除表单的缓存数据
            $("#department_dialog_form").form("clear");
            //departmentRoleCombotree.combobox("loadData",{rows:[]});


        },
        edit: function () {

            // 返回选中的行对象
            var rowData = departmentDatagrid.datagrid("getSelected");
            console.log(rowData)
            if (rowData) {
                // 打开编辑对话框
                departmentDialog.dialog("open");
                // 打开编辑对话框
                departmentDialog.dialog("setTitle", "编辑");
                // 清除表单的缓存数据
                departmentDialogForm.form("clear");
                // 回显管理者名称
                if (rowData.manager) {
                    rowData["manager.id"] = rowData.manager.id;
                }
                // 回显父部门名称
                if (rowData.parent) {
                    rowData["parent.id"] = rowData.parent.id;
                }


                // 回显表单的数据
                departmentDialogForm.form("load", rowData);

            } else {
                $.messager.alert("温馨提示", "请选中要编辑数据", "info");
            }
        },

        del: function () {
            // 返回选中的行对象
            var row = departmentDatagrid.datagrid("getSelected");
            if (row) {
                $.messager.confirm("温馨提示", "你确定要删除这个部门的数据吗", function (yes) {
                    if (yes) {
                        // 发送请求去后台删除数据
                        $.get("/department_delete?id=" + row.id, function (data) {
                            if (data.success) {
                                // 删除成功后,重新加载数据
                                departmentDatagrid.datagrid("reload");
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        });
                    }
                });

            } else {
                $.messager.alert("温馨提示", "请选中要删除的行!", "warning");
            }
        },
        /**
         * 刷新列表
         */
        refresh: function () {
            departmentDatagrid.datagrid("reload");
        },
        /**
         * 高级查询:根据关键字,录入时间,员工状态查询
         */
        searchContent: function () {
            // 创建一个json空对象:存取要查询的条件
            var param = {};
            // 获取表单中所有的数据的数组 [Object { name="keyword",  value=""}, Object {                         name="beginDate",  value=""}, Object { name="endDate",  value=""}]
            var paramArr = $("#department_searchForm").serializeArray();

            // 设置格式为 Object { keyword="",  beginDate="",  endDate=""}的json对象
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            // 根据查询的条件去重新查询后台,加载到前台中
            departmentDatagrid.datagrid("load", param);

        },
        /**保存/更新操作:
         * id:null 保存
         * id:不为null 更新
         * */
        save: function () {
            var url = null;
            // 根据id,设置发送的是保存还是更新请求的地址
            var id = $("input[name=id]").val();
            if (id) {
                url = "/department_update"
            } else {
                url = "/department_save"
            }

            // 表单的提交操作
            departmentDialogForm.form("submit", {
                url: url,
                // 传递选中角色的Id到后台中
                onSubmit: function (param) {
                    // 获取选中的角色Id数组
                    var values = departmentRoleCombotree.combobox("getValues");
                    for (var i = 0; i < values.length; i++) {
                        param["roles[" + i + "].id"] = values[i];
                    }
                },
                success: function (data) {
                    data = $.parseJSON(data)
                    if (data.success) {
                        $.messager.alert("温馨提示", data.msg, "info");
                        departmentDialog.dialog("close");
                        departmentDatagrid.datagrid("reload");
                    } else {
                        $.messager.alert("温馨提示", data.msg, "warning");
                    }
                }
            });

            
            
            
        },
        cancel: function () {
            departmentDialog.dialog("close");
        }


    };

});




