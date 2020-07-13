<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/static/css" />
<spring:url var="js" value="/resources/static/js" />
<spring:url var="images" value="/resources/static/images" />

<!-- <c:set var="contextRoot" value="${pageContext.request.contextPath}" /> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Online Shopping Website Using Spring MVC and Hibernate">
    <!-- <meta name="_csrf" content="${_csrf.token}">
    <meta name="_csrf_header" content="${_csrf.headerName}"> -->

    <title>Online Shopping - ${title}</title>

    <script>
        window.menu = '${title}';

        window.contextRoot = '${contextRoot}'

    </script>


    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Readable Theme -->
    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


    <!-- Bootstrap DataTables -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


    <!-- Custom CSS -->
    <link href="${css}/myapp.css" rel="stylesheet">
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

            <!-- Load only when user clicks products -->
            <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
                <%@include file="listProducts.jsp"%>
            </c:if>

            <!-- Load only when user clicks single product -->
            <c:if test="${userClickShowProduct == true }">
                <%@include file="singleProduct.jsp"%>
            </c:if>
            
            <!-- Load only when user clicks manage product -->
            <c:if test="${userClickManageProducts == true }">
                <%@include file="manageProducts.jsp"%>
            </c:if>

            <!-- Footer comes here -->
            <%@include file="./shared/footer.jsp"%>

            <!-- jQuery -->
            <script src="${js}/jquery.js"></script>

            <script src="${js}/jquery.validate.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="${js}/bootstrap.min.js"></script>

            <!-- DataTable Plugin -->
            <script src="${js}/jquery.dataTables.js"></script>

            <!-- DataTable Bootstrap Script -->
            <script src="${js}/dataTables.bootstrap.js"></script>

            <!-- DataTable Bootstrap Script -->
            <script src="${js}/bootbox.min.js"></script>

            <!-- Self coded javascript -->
            <script src="${js}/myapp.js"></script>
        </div>
    </div>
</body>

</html>