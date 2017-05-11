<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container-wrapper">
	<div class="container">
		<h1>Register User</h1>
		<p class="lead">회원 가입을 위한 정보를 입력해주세요.</p>

		<form:form 
			action="${pageContext.request.contextPath}/register/"
			method="POST" modelAttribute="user">
			
			<h3>기본 정보</h3>
			<div class="form-group">
				<label for="username">아이디</label>
				<span style="color:#ff0000;">${usernameMsg}</span>
				<form:input path="username" class="form-control" />
				<form:errors path="username" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="password">패스워드</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="email">이메일</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" cssStyle="color: #ff0000;" />
			</div>
			
			<h3>배송주소 정보</h3>
			
			<div class="form-group">
				<label for="shippingStreet">주소</label>
				<form:input path="shippingAddress.address" class="form-control" />
				<form:errors path="shippingAddress.address" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="shippingCountry">국가</label>
				<form:input path="shippingAddress.country" class="form-control" />
				<form:errors path="shippingAddress.country" cssStyle="color: #ff0000;" />
			</div>
			
			<div class="form-group">
				<label for="shipppingZip">우편번호</label>
				<form:input path="shippingAddress.zipCode" class="form-control" />
				<form:errors path="shippingAddress.zipCode" cssStyle="color: #ff0000;" />
			</div>
			
			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
		</form:form>
	</div>
</div>