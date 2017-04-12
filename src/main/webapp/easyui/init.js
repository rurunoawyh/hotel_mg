$(function(){
	//联动后台获取菜单的内容
	/*
	$.ajax({
		type:"post",
		url:"/cmfz/menu/menuList",
		dataType:"json",
		success:function(menus){
			InitLeftMenu(menus);
		}
	});
	*/
	InitLeftMenu();
	tabClose();


	$('#tabs').tabs({
        onSelect: function (title) {
            var currTab = $('#tabs').tabs('getTab', title);
            var iframe = $(currTab.panel('options').content);

			var src = iframe.attr('src');
			if(src)
				$('#tabs').tabs('update', { tab: currTab, options: { content: createFrame(src)} });

        },
        onContextMenu:function(e,title,index){
             e.preventDefault();
        }
	});

})

//初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({animate:false});
   /*	
    $.each(menus, function(i, n) {
    	var menulist ='';
		menulist +='<ul>';
        $.each(n.childResources, function(j, o) {
			menulist += '<li><div><a href="javascript:void(0)" ref="'+o.id+'" href="#" rel="' + o.resourceUrl + '" ><span class="icon '+o.resourceIcon+'" title="'+o.resourceIcon+'">&nbsp;</span><span class="nav">' + o.resourceName + '</span></a></div></li> ';
        })
		menulist += '</ul>';

		$('#nav').accordion('add', {
            title: n.resourceName,
            content: menulist,
            iconCls: 'icon ' + n.resourceIcon
        });

    });
    */

	$('.easyui-accordion li a').click(function(){
		var tabTitle = $(this).children('.nav').text();
		var tabIcon = $(this).children(".icon").prop("title");

		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = getIcon(tabIcon);

		addTab(tabTitle,url,icon);
		$('.easyui-accordion li div').removeClass("selected");
		$(this).parent().addClass("selected");
	}).hover(function(){
		$(this).parent().addClass("hover");
	},function(){
		$(this).parent().removeClass("hover");
	});

	//选中第一个
	var panels = $('#nav').accordion('panels');
	var t = panels[0].panel('options').title;
    $('#nav').accordion('select', t);
}

//获取左侧导航的图标
function getIcon(icon){
	return 'icon '+icon;
}


function addTab(subtitle,url,icon){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			icon:icon
		});
	}else{
		$('#tabs').tabs('select',subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}


function createFrame(url)
{
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})

}


//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}
