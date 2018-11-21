<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<!-- 부트스트랩 -->
<title>랭크</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript">
	// 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
	function checkValue() {
		if (!document.userInfo.id.value) {
			alert("아이디를 입력하세요.");
			return false;
		}

		if (!document.userInfo.password.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}

	}

	// 취소 버튼 클릭시 로그인 화면으로 이동
	function goLoginForm() {
		location.href = "LoginForm.jsp";
	}
</script>

</head>
<body>

	<!-- Static navbar -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">공룡점프</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">

					<li class="active"><a href="list">랭크</a></li>

				</ul>
				<c:choose>
					<c:when test="${sessionScope.id == null }">

						<form class="navbar-form navbar-right" name="userInfo"
							action="login" method="post" onsubmit="return checkValue()">
							<div class="form-group">
								<input type="text" class="form-control input-sm" name="id"
									id="id" placeholder="ID">
							</div>
							<div class="form-group">
								<input type="password" class="form-control input-sm"
									name="password" placeholder="PASSWORD">
							</div>
							<button type="submit" class="btn btn-success btn-sm">
								<span class="glyphicon glyphicon-off" aria-hidden="true">Login

								
							</button>
							<button type="button" class="btn btn-primary btn-sm"
								onclick="location='signup_view'">
								<span class="glyphicon glyphicon-list-alt" aria-hidden="true">
									SignUp 
							</button>
						</form>


					</c:when>
					<c:otherwise>
						<ul class="nav navbar-nav navbar-right">
							<form class="navbar-form" method="post">
								${sessionScope.id}님이 로그인중입니다. &nbsp;&nbsp;
							<button type="button" class="btn btn-danger"
					onclick="location.href = 'logout'">Logout</button>
								<button type="button" class="btn btn-info"
					onclick="location.href = 'mypage_view?myPageId=${sessionScope.id}'">My Page</button>
							</form>
							
				
						</ul>
						</form>
					</c:otherwise>
				</c:choose>


			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<h2 class="sub-header">순위</h2>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Rank</td>
						<td>ID</td>
						<td>Total</td>
						<td>Date</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page}" var="dto" varStatus="status">
						<tr>
							<td>${dto.WebGame_Rank}</td>
							<td>${dto.WebGame_Id}</a></td>
							<td>${dto.WebGame_Total}</td>
							<td>${dto.WebGame_Date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 페이징  -->
	<c:choose>
		<c:when
			test="${paging.numberOfRecords ne NULL and paging.numberOfRecords ne '' and paging.numberOfRecords ne 0}">
			<div class="text-center marg-top">
				<ul class="pagination">
					<c:if test="${paging.currentPageNo gt 5}">
						<!-- 현재 페이지가 5를 초과한다면 -->
						<li><a
							href="javascript:goPage(${paging.reset}, ${paging.maxPost})">처음</a></li>
						<!-- 현재 페이지가 5보다 크다면(즉, 6페이지 이상이라면) -->
						<li><a
							href="javascript:goPage(${paging.prevPageNo}, ${paging.maxPost})">이전</a></li>
						<!-- 이전페이지 표시 -->
					</c:if>
					<!-- 다른 페이지를 클릭하였을 시, 그 페이지의 내용 및 하단의 페이징 버튼을 생성하는 조건문-->
					<c:forEach var="i" begin="${paging.startPageNo}"
						end="${paging.endPageNo}" step="1">
						<!-- 변수선언 (var="i"), 조건식, 증감식 -->
						<c:choose>
							<c:when test="${i eq paging.currentPageNo}">
								<li class="active"><a
									href="javascript:goPage(${i}, ${paging.maxPost})">${i}</a></li>
								<!-- 1페이지부터 5개씩 뽑아내고, 1,2,3페이지순-->
							</c:when>
							<c:otherwise>
								<li><a href="javascript:goPage(${i}, ${paging.maxPost})">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<!-- begin에 의해서 변수 i는 1이기 때문에, 처음에는 c:when이 수행된다. 그 후 페이징의 숫자 2를 클릭하면 ${i}는 2로변하고, 현재는 ${i}는 1이므로 otherwise를 수행한다
					         그래서 otherwise에 있는 함수를 수행하여 2페이지의 게시물이 나타나고, 반복문 실행으로 다시 forEach를 수행한다. 이제는 i도 2이고, currentPageNo도 2이기 때문에
					     active에 의해서 페이징부분의 2에 대해서만 파란색으로 나타난다. 그리고 나머지 1,3,4,5,이전,다음을 표시하기위해 다시 c:otherwise를 수행하여 페이징도 나타나게한다.-->
					<!-- // 다른 페이지를 클릭하였을 시, 그 페이지의 내용 및 하단의 페이징 버튼을 생성하는 조건문-->

					<!-- 소수점 제거 =>-->
					<fmt:parseNumber var="currentPage" integerOnly="true"
						value="${(paging.currentPageNo-1)/5}" />
					<fmt:parseNumber var="finalPage" integerOnly="true"
						value="${(paging.finalPageNo-1)/5}" />

					<c:if test="${currentPage < finalPage}">
						<!-- 현재 페이지가 마지막 페이지보다 작으면 '다음'을 표시한다. -->
						<li><a
							href="javascript:goPage(${paging.nextPageNo}, ${paging.maxPost})">다음</a></li>
						<li><a
							href="javascript:goPage(${paging.end}, ${paging.maxPost})">끝</a></li>
					</c:if>
				</ul>
			</div>
		</c:when>
	</c:choose>
	<script>
		function goPage(pages, lines) {
			location.href = "list?pages=" + pages;
		}
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="./resources/js/bootstrap.min.js"></script>

</body>
</html>