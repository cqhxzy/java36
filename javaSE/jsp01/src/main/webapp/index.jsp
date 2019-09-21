<%@page contentType="text/html; charset=utf-8" %>

<html>
<meta charset="UTF-8" />
<body>
<h2>Hello World!</h2>


<%
    int sum = 0;
    for(int i = 1;i <= 100;i++){
        sum += i;
    }
%>
1-100的和：<%=sum%>
</body>
</html>
