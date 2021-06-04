<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Beneficiari</title>
<jsp:include page="/jsp/common/head_imports.jsp"/>
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<jsp:include page="/jsp/common/sidebar.jsp"/>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">
            <div class="card card-primary card-outline">
              <div class="card-header">
                <h5 class="m-0">Lista beneficiari</h5>
              </div>
              <div class="card-body">
              
              <table class="table table-striped">
				<tr>
					<td><strong>ID</strong></td>
					<td><strong>Nume</strong></td>
					<td><strong>Varsta</strong></td>
				    <td><strong>Adresa</strong></td>
				    <td><strong>Caine</strong></td>
					
					<td><strong>Detalii</strong></td>
					<td><strong>Editare</strong></td>
					<td></td>
				</tr>
				<c:forEach var="bn" items="${beneficiari}">
					<tr>
						<td><c:out value="${bn.id}"/></td> 
						<td><c:out value="${bn.nume}"/></td>
						<td><c:out value="${bn.varsta}"/></td> 
						<td><c:out value="${bn.adresa}"/></td>
						<td><c:out value="${caini[bn.caineID]}"/></td>
						
						<td><a href="<c:url value="/detaliib.htm?id=${bn.id}"/>">Detalii</a></td>
						<td><a href="<c:url value="/editare-beneficiari.htm?id=${bn.id}"/>">Editare</a></td>
						<td><a href="<c:url value="/deleteb.htm?id=${bn.id}"/>">Delete</a></td>
					</tr>
				</c:forEach>
				</table>
				<br/><br/>
				<a class="btn btn-primary" href="<c:url value="/adaugare-beneficiari.htm"/>">Adaugare beneficiari</a>
           
              </div>
            </div>
          </div>
          <!-- /.col-md-6 -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
      <jsp:include page="/jsp/common/footer.jsp"/>
  
</div>
<!-- ./wrapper -->

    <jsp:include page="/jsp/common/bottom_imports.jsp"/>

</body>

</html>