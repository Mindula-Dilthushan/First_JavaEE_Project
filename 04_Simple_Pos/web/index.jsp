<%@ page import="java.sql.ResultSet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer View</title>
    <link rel="stylesheet" href="assests/css/bootstrap.min.css">
</head>
<body>
<section class="container-fluid">
    <section class="row">
        <h1>Customer View</h1>
    </section>
    <section class="row">
        <div class="col-md-4">
            <form action="customer2" method="post">
                <div>
                    <label class="form-label" for="id">Customer ID</label>
                    <input class="form-control" id="id" type="text" name="id">
                </div>
                <div>
                    <label class="form-label" for="name">Customer Name</label>
                    <input class="form-control" id="name" type="text" name="name">
                </div>
                <div>
                    <label class="form-label" for="address">Customer Address</label>
                    <input class="form-control" id="address" type="text" name="address">
                </div>
                <div>
                    <label class="form-label" for="salary">Customer Salary</label>
                    <input class="form-control" id="salary" type="text" name="salary">
                </div>
                <div class="mt-3">
                    <button type="submit" class="btn btn-primary">Save Customer</button>
                </div>
            </form>
        </div>
        <div class="col-md-8">
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
                <%
                    ResultSet rst = (ResultSet) request.getServletContext().getAttribute("rst");
                    if (rst!=null){
                    while (rst.next()) {
                        String id = rst.getString(1);
                        String name = rst.getString(2);
                        String address = rst.getString(3);
                        String salary = rst.getString(4);
                %>
                <tr>
                    <td><%=id%></td>
                    <td><%=name%></td>
                    <td><%=address%></td>
                    <td><%=salary%></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </section>
</section>


<script src="assests/js/bootstrap.min.js"></script>
</body>
</html>


