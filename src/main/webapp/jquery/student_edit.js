$(function() {  // 在页面加载的时候执行
    $("#insertForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
        },
        rules: {   // 为每一个表单编写验证规则

            "st_name": {
                required: true,  // 此字段不允许为空
            },
            "st_number": {
                required: true,  // 此字段不允许为空
            }
        }
    });
});