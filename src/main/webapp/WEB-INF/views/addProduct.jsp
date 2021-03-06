<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container-wrapper">
	<div class="container">
		<h1>Add Product</h1>
		<p class="lead">Fill the below information to add a product:</p>
	
		<form:form 
			action="${pageContext.request.contextPath}/admin/productInventory/addProduct?${_csrf.parameterName}=${_csrf.token}"
			enctype="multipart/form-data"
			method="POST" modelAttribute="product">
			
			<div class="form-group">
				<label for="name">Name</label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="category">Name</label>
				<form:radiobutton path="category" value="컴퓨터" /> 컴퓨터
				<form:radiobutton path="category" value="가전" /> 가전
				<form:radiobutton path="category" value="신발" /> 신발
				
				<form:errors path="category" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="description">description</label>
				<form:textarea path="description" class="form-control"/>
				<form:errors path="description" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="price">Price</label>
				<form:input path="price" class="form-control"/>
				<form:errors path="price" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="unitInStock">Unit In Stock</label>
				<form:input path="unitInStock" class="form-control"/>
				<form:errors path="unitInStock" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="manufacturer">Manufacturer</label>
				<form:input path="manufacturer" class="form-control"/>
				<form:errors path="manufacturer" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="productImage">Upload Picture</label>
				<form:input path="productImage" type="file" class="form-control"/>
			</div>
			
			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
		</form:form>
	</div>
</div>