<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container-wrapper">
	<div class="container">
		<h2>Product Inventory Page</h2>
		<p class="lead">제품 재고 현황입니다.</p>
		<table class="table table-striped product-list">
			<thead>
				<tr class="bg-success">
					<th>Photo Thumb</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Manufacturer</th>
					<th>UnitInStock</th>
					<th>Description</th>
					<th class="action-icon"></th>
					<th class="action-icon"></th>
					<th class="action-icon"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products }">
					<tr>
						<td>
							<img src="<c:url value="/resources/images/${product.imageFilename}"/>"
								 alt="image" style="width: 100%;"/>
						</td>
						<td>${product.name}</td>
						<td>${product.category}</td>
						<td>${product.price}</td>
						<td>${product.manufacturer}</td>
						<td>${product.unitInStock}</td>
						<td>${product.description}</td>
						<td>
							<a href="<spring:url value="/viewProduct/${product.id}" />">
								<span class="glyphicon glyphicon-info-sign"></span>
							</a>
						</td>
						<td>
							<a href="<spring:url value="/admin/productInventory/deleteProduct/${product.id}" />">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</a>
						</td>
						<td>
							<a href="<spring:url value="/admin/productInventory/editProduct/${product.id}" />">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="<c:url value="/admin/productInventory/addProduct"/>" 
			class="btn btn-primary">Add Product</a>
	</div>
</div>