<%--
  Created by IntelliJ IDEA.
  User: Ma
  Date: 2019/12/18
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testAjaxAndJson</title>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":30}',
                    dadaType:"json",
                    type:"post",
                    success:function (user) {
                        alert(user.username);
                    }
                })
            })

            $("#btn1").click(function () {
                $.ajax({
                    url:"user/testJson",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data);
                    }
                })
            })

        })
    </script>
</head>
<body>
<button id="btn">发送ajax的请求</button>
<button id="btn1">接收json数据</button>


</body>
</html>
