<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Servlet : Web Fragment</title>
</head>
<body>


<script type="javascript">

    var wsocket;
    function connect() {
        wsocket = new WebSocket("ws://localhost:8080/ee/ws");
        wsocket.onmessage = onMessage;
    }

    function onMessage(evt) {
        var arraypv = evt.data.split("/");
        document.getElementById("price").innerHTML = arraypv[0];
        document.getElementById("volume").innerHTML = arraypv[1];
    }

    window.addEventListener("load", connect, false);

</script>
<h1>Servlet : Web Fragment</h1>

Do you see output from Servlet Filter (packaged in web fragment)? <br><br>
Access the <a href="${pageContext.request.contextPath}/TestServlet">Servlet</a> and check output in server log.
</body>



</html>