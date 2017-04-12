<%@ page pageEncoding="UTF-8" contentType="text/html;charest=UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>百知后台管理系统</title>
    <link href="${base_path}/css/default.css" rel="stylesheet"
          type="text/css" />
    <link rel="stylesheet" type="text/css"
          href="${base_path}/easyui/themes/default/easyui.css" />
    href="${base_path}/easyui-extend/easyui/themes/icon.css" />
    <script type="text/javascript" src="${base_path}/easyui/jquery-1.7.2.js"></script>
    <script type="text/javascript"
            src="${base_path}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${base_path}/easyui-extend/easyui/js/easyui-lang-zh_CN.js"></script>
    
	<script type="text/javascript" src='${base_path}/easyui/init.js'> </script>
    <script type="text/javascript">
       //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }

        

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', "恭喜，密码修改成功！您的新密码为：" + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = '/cmfz/page/login.jsp';
                    }
                });
            })
        });
		
		

    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;background: url(${base_path }/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">欢迎:suns  <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 16px; "><img src="${base_path }/images/blocks.gif" width="20" height="20" align="absmiddle" />百知后台管理系统</span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">By suns@zparkhr.com.cn</div>
    </div>
    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
       <div id="nav" class="easyui-accordion" fit="true" border="false">
          <c:forEach var="parent_menu" items="${requestScope.resource }">
		    <div title="${parent_menu.resourceName}" data-options="iconCls:'icon ${parent_menu.resourceIcon}'">
		       <ul>
		         <c:forEach var="child_menu" items="${parent_menu.children}">
		           		<li><div><a href="javascript:void(0)" ref="${child_menu.id }" href="#" rel="${base_path}/${child_menu.resourceUrl} " >
		           		<span class="icon ${child_menu.resourceIcon}" title="${child_menu.resourceIcon}">&nbsp;</span><span class="nav">${child_menu.resourceName}</span></a>
		              </div></li>
		          </c:forEach> 
		            
		        </ul>
			</div>
		 </c:forEach>
       </div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
       <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="overflow:hidden; color:red;text-align:center; padding-top:200px; " >
				<img src="${base_path }/images/logo.png" alt="" width="200px" />
			</div>
	   </div>
    </div>
    
    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false" maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px; background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >确定</a> 
				<a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>
</body>
</html>