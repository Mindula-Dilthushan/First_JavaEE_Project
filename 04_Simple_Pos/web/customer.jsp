<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer View</title>
    <link rel="stylesheet" href="assests/css/bootstrap.min.css">
</head>
<%--scriplet--%>
<%
    String id = "C001";
    String name = "Dasun";
    String address = "Galle";
    double salary = 10000;
%>

<%--declaration--%>
<%! int age=10;%>

<body>
<section class="container-fluid">
    <section class="row">
        <h1>Customer View</h1>
    </section>
    <section class="row">
        <div class="col-md-6">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Salary</th>
                </tr>
                </thead>
                <tbody>
                <tr>
<%--                    expression--%>
                    <td><%=id%></td>
                    <td><%=name%></td>
                    <td><%=address%></td>
                    <td><%=salary%></td>
                </tr>
                </tbody>
            </table>
        </div>
    </section>
</section>


<script src="assests/js/bootstrap.min.js"></script>
</body>
</html>


<%--<%%> scriplet
<%=%> expression
<%!%> declaration--%>
