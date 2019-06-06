var APP=function () {
    var masterCheckbox=$('input[type="checkbox"].minimal.icheck_master');
    var checkbox=$('input[type="checkbox"].minimal');
    /**
     * 私有方法初始化 icheck
     *
     */

    var handlerInitCheckbox= function () {
        //激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });
        //获取控制端的 CheckBox
        masterCheckbox=$('input[type="checkbox"].minimal.icheck_master');
        //获取全部集合
        checkbox=$('input[type="checkbox"].minimal');
    };

    /**
     * 全选功能
     */
    var handlerCheckboxall=function () {
        var checkbox=$('input[type="checkbox"].minimal');
        masterCheckbox.on("ifClicked",function (e) {
            if (e.target.checked) {
                checkbox.iCheck("uncheck");
            }
            else {
                checkbox.iCheck("check")
            }
        })
    };

    /**
     * 初始化DataTables
     */
    var handlerInitDataTables=function (url,columns) {
        var dataTable= $("#example1").DataTable({
            "paging":true,
            "info":true,
            "lengthChange":false,
            "ordering":false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url
            },
            "columns":columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function(settings) {
                handlerInitCheckbox();
                handlerCheckboxall();
            }
        });
    };

    return{
        init:function () {
            handlerInitCheckbox();
            handlerCheckboxall();
        },

        initDataTables:function (url,columns) {
            handlerInitDataTables(url,columns)
        }
    }
}();

