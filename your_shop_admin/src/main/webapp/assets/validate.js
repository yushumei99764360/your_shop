/**
 * 函数对象
 */
var Validate =function () {
    /**
     * 初始化
     */
    var handlerInitValidate =function (url) {

        $.validator.addMethod("phonenumber",function (value,element) {
            var length=value.length;
            var phonenumber = /^(((13[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
            return this.optional(element) || (length == 11 && phonenumber.test(value));
        });
        $().ready(function() {
            $("#commentForm").validate({
                rules: {
                    firstname: "required",
                    lastname: "required",
                    username: {
                        required: true,
                        minlength: 2,
                        remote:{
                            url:url,
                            type:"post",
                            data:{
                                username:function () {
                                    return $("#username").val();
                                }
                            }
                        }
                    },
                    password: {
                        required: true,
                        minlength: 2
                    },
                    confirm_password: {
                        required: true,
                        minlength: 2,
                        equalTo: "#password"
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    phonenumber: {
                        required: true,
                        phonenumber: true
                    },
                    topic: {
                        required: "#newsletter:checked",
                        minlength: 2
                    },
                    agree: "required"
                },
                messages: {
                    firstname: "请输入您的名字",
                    lastname: "请输入您的姓氏",
                    username: {
                        required: "请输入用户名",
                        minlength: "用户名必需由两个字母组成",
                        remote:"用户名已存在"
                    },
                    password: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 5 个字母"
                    },
                    confirm_password: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 5 个字母",
                        equalTo: "两次密码输入不一致"
                    },
                    phonenumber: {
                        required: "请输入手机号",
                        phonenumber: "手机号格式不正确"
                    },
                    email: "请输入一个正确的邮箱",
                    agree: "请接受我们的声明",
                    topic: "请选择两个主题"
                }
            })
        })


    };
    return{
        init:function (url) {
            handlerInitValidate(url);
        }
    }

}();
