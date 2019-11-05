<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

   <!-- Page Heading -->
   <h1 class="h3 mb-2 text-gray-800">Register</h1>
   <p class="mb-4">
      DataTables is a third party plugin that is used to generate the demo
      table below. For more information about DataTables, please visit the <a
         target="_blank" href="https://datatables.net">official DataTables
         documentation</a>.
   </p>

   <!-- DataTales Example -->
   <div class="card shadow mb-4">
      <div class="card-header py-3">
         <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
      </div>
      <div class="card-body">
         
      </div>
   </div>
   <div  style="display: flex; justify-content: flex-end">
   <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
  </div>

</div>


<script >
$(document).ready(function(){
   console.log("ready");
   })
</script>
<%@ include file="../includes/footer.jsp"%>

