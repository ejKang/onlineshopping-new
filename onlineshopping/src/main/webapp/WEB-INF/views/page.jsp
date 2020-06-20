<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

    <title>Online Shopping - ${title}</title>

    <script>
        window.menu = '${title}';

        window.contextRoot = '${contextRoot}'

    </script>


    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Readable Theme -->
    <link href="resources/css/bootstrap-readable-theme.css" rel="stylesheet">


    <!-- Bootstrap DataTables -->
    <link href="resources/css/dataTables.bootstrap.css" rel="stylesheet">


    <!-- Custom CSS-->
    <link href="resources/css/myapp.css" rel="stylesheet"> 
</head>

<body>
    <div class="se-pre-con"></div>
    <div class="wrapper">
        <%@include file="./shared/navbar.jsp"%>


        <div class="content">

            <!-- Loading the home content -->
            <c:if test="${userClickHome == true }">
                <%@include file="home.jsp"%>
            </c:if>

            <!-- Load only when user clicks about -->
            <c:if test="${userClickAbout == true }">
                <%@include file="about.jsp"%>
            </c:if>

            <!-- Load only when user clicks contact -->
            <c:if test="${userClickContact == true }">
                <%@include file="contact.jsp"%>
            </c:if>

            <!-- Load only when user clicks contact -->
            <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
                <%@include file="listProducts.jsp"%>
            </c:if>


            <!-- Footer comes here -->
            <%@include file="./shared/footer.jsp"%>

            <!-- jQuery -->
            <script src="resources/js/jquery.js"></script>

            <script src="resources/js/jquery.validate.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="resources/js/bootstrap.min.js"></script>

            <!-- DataTable Plugin -->
            <script src="resources/js/jquery.dataTables.js"></script>

            <!-- DataTable Bootstrap Script -->
            <script src="resources/js/dataTables.bootstrap.js"></script>

            <!-- DataTable Bootstrap Script -->
            <script src="resources/js/bootbox.min.js"></script>

            <!-- Self coded javascript -->
            <script src="resources/js/myapp.js"></script>
        </div>
    </div>
</body>

</html>