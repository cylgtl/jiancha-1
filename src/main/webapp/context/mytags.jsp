<%@ taglib prefix="t" uri="/easyui-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

String bulidPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>
<c:set var="webRoot" value="<%=basePath%>" />
<c:set var="root" value="<%=bulidPath%>" />
<script type="text/javascript" src="${webRoot }/plug-in/echarts/echarts.min.js"></script>
<script type="text/javascript" src="${webRoot }/plug-in/echarts/china.js"></script>