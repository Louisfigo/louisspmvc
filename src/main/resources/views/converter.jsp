<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Uploadfile</title>
    </head>
    <body>
        <div id="resp"></div>
        <input type="button" id="myreq" value="请求" />
        <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>
    <script>


        $("#myreq").bind("click",req);
        function req() {

            $.ajax({
                url:"ctr",
                data:"120-louis",
                type:"POST",
                contentType:"application/x-louis",
                success:function (data) {
                    $("#resp").html(data);

                }
            })

        }
    </script>
    </body>
</html>