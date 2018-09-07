<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Uploadfile</title>
    </head>
    <body>
        <div id="msgFromPush"></div>
        <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>
    <script>
        if(!window.EventSource)
        {
            var source = new EventSource('pushsse');
            s= ' ';
            source.addEventListener('message',function(e){
                s+= e.data+"<br/>";
                $("#msgFromPush").html(s);
            });

            source.addEventListener('open',function (e) {
                console.log("connection open");
            },false);

            source.addEventListener('error',function (e) {
                if(e.readyState == EventSoure.CLOSED)
                {
                    console.log("connection cloase");
                }
                else
                {
                    console.log(e.readyState);
                }
            },false);
        }
        else {

            defer();
        }

        function defer() {

            $.get('defer',function (data) {
                console.log(data);
                defer();
            })

        };




    </script>
    </body>
</html>