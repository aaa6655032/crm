$(function () {

    var dictionaryDatagrid, dictionaryItemDatagrid, dictionaryItemDialog, dictionaryItemDialogForm;

    dictionaryDatagrid = $("#dictionary_datagrid");
    dictionaryItemDatagrid = $("#dictionaryItem_datagrid");
    dictionaryItemDialog = $("#dictionaryItem_dialog");
    dictionaryItemDialogForm = $("#dictionaryItem_dialog_form");


    dictionaryDatagrid.datagrid({
        url: "dictionary_list",
        width: 500,
        fit:true,
        fitColumns: true,
        singleSelect: true,
        onClickRow: function (rowIndex, rowData) {
            dictionaryItemDatagrid.datagrid("load", {
                "id": rowData.id
            })

        },
        columns: [[
            {field: "sn", title: "字典编号", width: 100, align: "center"},
            {field: "name", title: "字典名称", width: 100, align: "center"},
            {field: "intro", title: "字典简介", width: 100, align: "center"},
        ]],

    });
    dictionaryItemDatagrid.datagrid({
        url: "/queryByDictionaryId",
        width: 500,
        fit: true,
        fitColumns: true,
        singleSelect: true,
        toolbar: "#dictionaryItem_btn",
        columns: [[
            {field: "id", title: "字典明细编号", width: 100, align: "center"},
            {field: "name", title: "字典明细名称", width: 150, align: "center"},
            {field: "intro", title: "字典明细简介", width: 150, align: "center"},
            {field: "dict", title: "字典目录", width: 150, align: "center", formatter: dictFormatter},
            {field: "state", title: "状态", width: 150, align: "center", formatter: stateFormatter},
        ]],

    });

    function dictFormatter(value, rows, index) {
        if (value) {
            return value.name;
        } else {
            return null;
        }
    }

    function stateFormatter(value, rows, index) {
        if (value) {
            return "<font color='green'>正常</font>";
        } else {
            return "<font color='red'>禁用</font>";
        }

    }

    dictionaryItemDialog.dialog({
        width: 400,
        height: 300,
        buttons: "#dictionaryItem_bb",
        closed: true
    });


    $("a").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    dictionaryItemDatagrid.datagrid({
        onClickRow: function (rowIndex, rowData) {
            console.log(rowData);
            if (rowData.state) {
                $("#forbiddenId").linkbutton({"text": "禁用"});
            } else {
                $("#forbiddenId").linkbutton({"text": "启用"});
            }
        }
    })


    var cmdObj = {

            add: function () {
                var rowdata = dictionaryDatagrid.datagrid("getSelected");
                if (rowdata) {
                    // 打开新增对话框
                    dictionaryItemDialog.dialog("open");
                    // 设置标题为新增
                    dictionaryItemDialog.dialog("setTitle", "新增");
                    // 清除表单的缓存数据
                    dictionaryItemDialogForm.form("clear");
                    // 回显表单的数据
                    $("input[name='dict.name']").val(rowdata.name);
                    $("input[name='dict.id']").val(rowdata.id);
                } else {
                    $.messager.alert("温馨提示", "请选择至少一行数据", "info");
                }


            },
            edit: function () {
                // 返回选中的行对象
                var rowData = dictionaryItemDatagrid.datagrid("getSelected");

                if (rowData) {
                    // 打开编辑对话框
                    dictionaryItemDialog.dialog("open");
                    // 打开编辑对话框
                    dictionaryItemDialog.dialog("setTitle", "编辑");
                    // 清除表单的缓存数据
                    dictionaryItemDialogForm.form("clear");
                    console.log(rowData);
                    // 回显部门信息
                    if (rowData.dict) {
                        rowData["dict.name"] = rowData.dict.name;
                        rowData["dict.id"] = rowData.dict.id;
                    }

                    // 回显表单的数据
                    dictionaryItemDialogForm.form("load", rowData);
                } else {
                    $.messager.alert("温馨提示", "请选中要编辑数据", "info");
                }
            },


            forbidden: function () {
                // 返回选中的行对象
                var row = dictionaryItemDatagrid.datagrid("getSelected");
                if(!row){
                    $.messager.alert("温馨提示", "请选中数据", "info");
                    return;
                }
                if (row.state) {
                    if (row) {
                        $.messager.confirm("温馨提示", "你确定要禁用这条明细吗", function (yes) {
                            if (yes) {
                                // 发送请求去后台禁用数据
                                $.get("/dictionaryItem_forbidden?id=" + row.id, function (data) {
                                    if (data.success) {
                                        // 禁用成功后,重新加载数据
                                        dictionaryItemDatagrid.datagrid("reload");
                                        $.messager.alert("温馨提示", data.msg, "warning");
                                    } else {
                                        $.messager.alert("温馨提示", data.msg, "warning");
                                    }
                                });
                            }
                        });

                    } else {
                        $.messager.alert("温馨提示", "请选中要删除的行!", "warning");
                    }
                } else {
                    if (row) {
                        $.messager.confirm("温馨提示", "你确定要启用这条明细吗", function (yes) {
                            if (yes) {
                                // 发送请求去后台删除数据
                                $.get("/dictionaryItem_start?id=" + row.id, function (data) {
                                    if (data.success) {
                                        // 删除成功后,重新加载数据
                                        dictionaryItemDatagrid.datagrid("reload");
                                        $.messager.alert("温馨提示", data.msg, "warning");
                                    } else {
                                        $.messager.alert("温馨提示", data.msg, "warning");
                                    }
                                });
                            }
                        });

                    } else {
                        $.messager.alert("温馨提示", "请选中要删除的行!", "warning");
                    }
                }
            },


            del:function () {
                if (row) {
                    $.messager.confirm("温馨提示", "你确定要启用这条明细吗", function (yes) {
                        if (yes) {
                            // 发送请求去后台删除数据
                            $.get("/dictionaryItem_delete?id=" + row.id, function (data) {
                                if (data.success) {
                                    // 删除成功后,重新加载数据
                                    dictionaryItemDatagrid.datagrid("reload");
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
                dictionaryItemDatagrid.datagrid("reload");
            },
            /**
             * 高级查询:根据关键字,录入时间,员工状态查询
             */
            searchContent: function () {
                // 创建一个json空对象:存取要查询的条件
                var param = {};
                // 获取表单中所有的数据的数组 [Object { name="keyword",  value=""}, Object {                         name="beginDate",  value=""}, Object { name="endDate",  value=""}]
                var paramArr = $("#dictionaryItem_searchForm").serializeArray();

                // 设置格式为 Object { keyword="",  beginDate="",  endDate=""}的json对象
                for (var i = 0; i < paramArr.length; i++) {
                    param[paramArr[i].name] = paramArr[i].value;
                }
                // 根据查询的条件去重新查询后台,加载到前台中
                dictionaryItemDatagrid.datagrid("load", param);

            }
            ,
            /**保存/更新操作:
             * id:null 保存
             * id:不为null 更新
             * */
            save: function () {
                var url = null;
                // 根据id,设置发送的是保存还是更新请求的地址
                var id = $("input[name=id]").val();
                var dictId = $("input[name='dict.id']").val();
                console.log("id" + id);
                if (id) {
                    url = "/dictionaryItem_update"
                } else {
                    url = "/dictionaryItem_save"
                }
                // 表单的提交操作
                dictionaryItemDialogForm.form("submit", {
                    url: url,
                    // 传递选中角色的Id到后台中
                    onSubmit: function (param) {
                        param["dict.id"] = dictId;
                    },
                    success: function (data) {
                        data = $.parseJSON(data)
                        if (data.success) {
                            $.messager.alert("温馨提示", data.msg, "info");
                            dictionaryItemDialog.dialog("close");
                            dictionaryItemDatagrid.datagrid("reload");
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }
                });

            }
            ,
            cancel: function () {
                dictionaryItemDialog.dialog("close");
            }


        }
        ;


});