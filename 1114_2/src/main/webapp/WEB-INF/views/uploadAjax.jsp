<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.uploadResult {
	width: 100vw;
	height: 20vh;
	display: flex;
	flex-direction: row;
	justify-content: center;
	background-color: pink;
}

.uploadUl {
	display: flex;
	flex-direction: row;
	justify-content: center;
	list-style: none;
}

.uploadUl li {
	width: 100px;
	height: 100px;
	background: aqua;
	border: 1px solid black;
	border-radius: 3px;
	margin: 10px;
}
</style>
</head>
<body>
	<h1>Upload with Ajax</h1>
	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>
	<button id='uploadBtn'>Upload</button>

	<div class='uploadResult'>
		<ul class='uploadUl'>
			<li>AAA</li>
			<li>AAA</li>
			<li>AAA</li>
			<li>AAA</li>
		</ul>
	</div>

	<form id="actionForm" action="/downFile" method="get" target="_blank">
		<input type="hidden" name="fname">
	</form>


	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>

	<script>
	var $actionForm = $("#actionForm");
	
		function down(fileName) {
			$actionForm.find("input[name='fname']").val(fileName);
			$actionForm.submit();
		}
			
		$(document).ready(function() {

			var $listUL = $(".uploadUl");
			
			$("#uploadBtn").on("click", function(e) {

				let formData = new FormData();

				let inputFile = $("input[name='uploadFile']");

				let files = inputFile[0].files;

				console.log(files);

				//add filedate to formdata
				for (let i = 0; i < files.length; i++) {
					formData.append("uploadFile", files[i]);
				}

				$.ajax({
					url : '/uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					type : 'POST',
					success : function(result) {
						console.log(result);
				
						let str="";
						
						for(let i=0; i<result.length; i++){
							
							let item = result[i];
							
							str += "<li onclick='javascript:down(\""+item.uuid+"\")'>";
							
							str += item.fileName;
							
							if(item.image){
								str+="<img src='/viewFile?fname=s_"+item.uuid+"'/>";
							} else {
								str+="<div>"+item.uuid+"</div>";
							}
							
							str += "</li>";
						}

						$listUL.append(str);
					}
				}); //$.ajax

			});
		});
	</script>


</body>
</html>