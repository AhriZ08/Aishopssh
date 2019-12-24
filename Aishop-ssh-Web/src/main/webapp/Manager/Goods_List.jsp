<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Aishopssh.Dao.ManagerDao.ManageGoodsDao" %>
<%@ page import="com.Aishopssh.Entites.Goods" %>
<%@ page import="com.Aishopssh.Entites.Type1" %>
<%@ page import="com.Aishopssh.Entites.Type2" %>
<%@ page import="com.Aishopssh.Entites.Type3" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String path = request.getContextPath();
	List<Goods> reclist = (List<Goods>)session.getAttribute("goods");
	session.removeAttribute("goods");
	ManageGoodsDao beanDB = new ManageGoodsDao();
	List<Type1> type1list = beanDB.GetAllType1();
	List<Type2> type2list = beanDB.GetAllType2();
	List<Type3> type3list = beanDB.GetAllType3();
%>
${goods[0].getName()}
<link rel="stylesheet" type="text/css" href="<%=path %>/css/Manager.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/layui/css/layui.css">
<script type="text/javascript" src="<%=path %>/js/datacheck.js"></script>
<script src="<%=path %>/js/jquery.js"></script>
<body>
	<%
		int count = reclist.size();
		int type1count = type1list.size();
		int type2count = type2list.size();
		int type3count = type3list.size();
		for (int i = 0; i < count; i++) {
			Goods goods = reclist.get(i);
			String type1 = "";
			String type2 = "";
			String type3 = "";
			String tuijian = "";
			String tupian = goods.getPicture();

			for (int j = 0; j < type1count; j++) {
				Type1 Type1 = type1list.get(j);
				if (goods.getTypeIdLevel1() == Type1.getId()) {
					type1 = Type1.getTypeName();
				}
			}

			for (int j = 0; j < type2count; j++) {
				Type2 Type2 = type2list.get(j);
				if (goods.getTypeIdLevel2() == Type2.getId()) {
					type2 = Type2.getTypeName();
				}
			}

			for (int j = 0; j < type3count; j++) {
				Type3 Type3 = type3list.get(j);
				if (goods.getTypeIdLevel3() == Type3.getId()) {
					type3 = Type3.getTypeName();
				}
			}

			if (goods.getIsRecommend() == 1) {
				tuijian = "是";
			}
			else if (goods.getIsRecommend() == 0) {
				tuijian = "否";
			}
	%>
			<div class="table_big">
				<div class="table_left_1">
					<label class="td_header_mingcheng">商品名称：</label>
					<label class="td_mingcheng"><%=goods.getName()%></label>
				</div>
				<div class="table_left_2">
					<label class="td_header_addtime">上市时间：</label>
					<label class="td_addtime"><%=goods.getAddtime()%></label>
					<label class="td_header_shichangjia">市场价：</label>
					<label class="td_shichangjia"><%=goods.getMarketPirce()%></label>
					<label class="td_header_huiyuanjia">会员价：</label>
					<label class="td_huiyuanjia"><%=goods.getMemberPrice()%></label>
				</div>
				<div class="table_left_3">
					<label class="td_header_type">类别：</label>
					<label class="td_type"><%=type1%>-<%=type2%>-<%=type3%></label>
					<label class="td_header_dengji">等级：</label>
					<label class="td_dengji"><%=goods.getLevel()%></label>
					<label class="td_header_pingpai">品牌：</label>
					<label class="td_pingpai"><%=goods.getBrand()%></label>
				</div>
				<div class="table_left_4">
					<label class="td_header_xinghao">型号：</label>
					<label class="td_xinghao"><%=goods.getModel()%></label>
					<label class="td_header_tuijian">是否推荐：</label>
					<label class="td_tuijian"><%=tuijian%></label>
				</div>
				<div class="table_left_5">
					<label class="td_header_shuliang">总数量：</label>
					<label class="td_shuliang"><%=goods.getNum()%></label>
					<label class="td_header_cishu">已售出：</label>
					<label class="td_cishu"><%=goods.getPurchaseTime()%></label>
					<label class="td_header_kucun">剩余库存：</label>
					<label class="td_kucun"><%=goods.getNum() - goods.getPurchaseTime()%></label>
				</div>
				<div class="table_left_6">
					<label class="td_header_jianjie">简介：</label>
					<label class="td_jianjie"><%=goods.getIntroduction()%></label>
				</div>
				<div class="table_right">
					<label><img  class="td_tupian" src="<%=path + tupian%>"></label>
				</div>
			</div>
			<div>
				<table width="100%">
					<tr>
						<td align="right" width="600px"><button type="button" class="layui-btn" OnClick="GoodsEdit(<%=goods.getId()%>)">修改商品信息</button></td>
						<td align="left" width="600px"><button type="button" class="layui-btn layui-btn-danger" OnClick="GoodsDelete(<%=goods.getId()%>)" >删除商品</button></td>
					</tr>
				</table>
			</div>

	<%
		}
	%>
	<script>
			function GoodsEdit(id) {
				window.location.href = "<%=path%>/GoodsGetAction.action?id=" + id;
			}
			function GoodsDelete(id) {
				var flag = 0;
				if (confirm("确认要删除该商品吗？")) {
					flag = 1;
				}
				if (flag == 1) {
					window.location.href = "<%=path%>/GoodsDeleteAction.action?id=" + id;
				}
			}
	</script>
</body>
</html>