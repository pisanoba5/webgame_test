<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<!-- 부트스트랩 -->
<title>회원가입</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>

	<div class="container">
		<h1 class="page-header">회원가입</h1>
		<form:form class="form-horizontal" commandName="dto" action="sign_up"
			method="post">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">이름</label>
				<div class="col-sm-6">
					<form:input oninput="idcheck()" id="id" path="id"
						class="form-control" />
					<!-- oninput을 이용하여 실시간 아이디 중복 확인 가능 -->
					<form:errors path="id" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">비밀번호</label>
				<div class="col-sm-6">
					<form:password path="password" class="form-control" />
					<form:errors path="password" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">이름</label>
				<div class="col-sm-6">
					<form:input path="name" class="form-control" />
					<form:errors path="name" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">성별</label>
				<div class="col-sm-6">
					<form:select path="gender" class="form-control">
						<form:option value="남" label="남" />
						<form:option value="여" label="여" />
					</form:select>
					<form:errors path="gender" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">월</label>
				<div class="col-sm-6">
					<form:select path="month" class="form-control">
						<form:option value="" label="월" />
						<form:option value="01" label="1월" />
						<form:option value="02" label="2월" />
						<form:option value="03" label="3월" />
						<form:option value="04" label="4월" />
						<form:option value="05" label="5월" />
						<form:option value="06" label="6월" />
						<form:option value="07" label="7월" />
						<form:option value="08" label="8월" />
						<form:option value="09" label="9월" />
						<form:option value="10" label="10월" />
						<form:option value="11" label="11월" />
						<form:option value="12" label="12월" />
					</form:select>
					<form:errors path="month" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">이메일</label>
				<div class="col-sm-6">
					<form:select path="email" class="form-control">
						<form:option value="@naver.com">naver.com</form:option>
						<form:option value="@daum.net">daum.net</form:option>
						<form:option value="@gmail.com">gmail.com</form:option>
						<form:option value="@nate.com">nate.com</form:option>
					</form:select>
					<form:errors path="email" cssClass="error" />
				</div>
			</div>
			<center>
				<input class="btn btn-default" type="submit" id="sign_up"
					name="sign_up" value="회원가입완료" />
				<button type="button" class="btn btn-warning"
					onclick="location.href = 'list'">취소</button>
			</center>
		</form:form>
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="./resources/js/bootstrap.min.js"></script>
</body>
</html>