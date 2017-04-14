$(function(){
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'70px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
		
		});
	$('#switch_login').click(function(){
		
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'154px',width:'70px'});
		
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
		});
if(getParam("a")=='0')
{
	$('#switch_login').trigger('click');
}
});
	
function logintab(){
	scrollTo(0);
	$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
	$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
	$('#switch_bottom').animate({left:'154px',width:'96px'});
	$('#qlogin').css('display','none');
	$('#web_qr_login').css('display','block');
	
}


//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}
$(document).ready(function() {
$("#jobNum").change(function(){console.info("0");checkjobNum();});
$("#accountNum").change(function(){checkAccount();});
$("#user").change(function(){validateUser();});
$("#passwd").change(function(){validatePwd()});
$("#reg").click(function(){regist()});
//验证
function validateUser() {
    if ($('#user').val() == "") {
        $('#user').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        $('#userCue').html("<font color='red'><b>×用户名不能为空</b></font>");
        return false;
    }
    if ($('#user').val().length < 4 || $('#user').val().length > 16) {

        $('#user').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        $('#userCue').html("<font color='red'><b>×用户名位4-16字符</b></font>");
        return false;
    }
    else{
        $('#userCue').html("");
        $('#user').focus().css({
            border: "1px solid black",
            boxShadow: "0 0 2px black"
        });
        return true;
    }
}
//校验工号
function checkjobNum(){
    if ($('#jobNum').val() == "") {
        $('#jobNum').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        $('#userCue').html("<font color='red'><b>×工号不能为空</b></font>");
        return false;
    }
    if ($('#jobNum').val().length < 8 || $('#jobNum').val().length > 8) {

        $('#jobNum').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        $('#userCue').html("<font color='red'><b>×工号必须是8位</b></font>");
        return false;

    }else {
        $.ajax( {
            url: "/user/checkAccountNum.json",
            data:{"jobNum":$("#jobNum").val()},
            dataType: "json",
            success: function(data) {
                if (data.status==false) {
                    $('#userCue').html("<font color='red'><b>×工号已存在！</b></font>");
                    return false;
                }else{
                $('#userCue').html("");
                    $('#jobNum').focus().css({
                        border: "1px solid gray",
                        boxShadow: "0 0 2px gray"
                    });
                return true;
                }
            }
        });
    }
}
//校验账号
function checkAccount(){
    if ($('#accountNum').val() == "") {
        $('#accountNum').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        $('#userCue').html("<font color='red'><b>×账号不能为空</b></font>");
        return false;
    }
    if ($('#accountNum').val().length < 8 || $('#accountNum').val().length > 14) {

        $('#accountNum').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        $('#userCue').html("<font color='red'><b>×账号位数8-14</b></font>");
        return false;

    }else{
        $.ajax( {
            url: "/user/checkAccountNum.json",
            data:{"accountNum":$("#accountNum").val()},
            dataType: "json",
            success: function(data) {
                if (data.status==false) {
                    $('#userCue').html("<font color='red'><b>×该账号已存在！</b></font>");
                    return false;
                }if (data.status==false){
                    $('#userCue').html("");
                    $('#accountNum').focus().css({
                        border: "1px solid gray",
                        boxShadow: "0 0 2px gray"
                    });
                    return true;
                }
            }
        });}
}
//验证密码
function validatePwd(){
    if ($('#passwd').val().length < 6) {
        $('#passwd').focus();
        $('#userCue').html("<font color='red'><b>×密码不能小于" + 6 + "位</b></font>");
        return false;
    }else{
        $('#userCue').html("");
        return true;}
}
//注册
function regist(){
    if(validateUser()&&checkjobNum()&&checkAccount()&&validatePwd()){
        $.ajax( {
            url: "/user/register.json",
            data:{"accountNum":$("#accountNum").val()},
            dataType: "json",
            success: function(data) {
                if (data.status==false) {
                    $('#userCue').html("<font color='red'><b>data.msg</b></font>");
                }if(data.status==true){
                    $('#userCue').html("");
                    alert("注册成功!");
                }
            }
        });
    }else{
        $('#userCue').html("");
        alert("请输入正确的信息");
    }
}
});

/*



	$('#reg').click(function() {

		$.ajax({
			type: reMethod,
			url: "/member/ajaxyz.php",
			data: "uid=" + $("#user").val() + '&temp=' + new Date(),
			dataType: 'html',
			success: function(result) {

				if (result.length > 2) {
					$('#user').focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});$("#userCue").html(result);
					return false;
				} else {
					$('#user').css({
						border: "1px solid #D7D7D7",
						boxShadow: "none"
					});
				}

			}
		});



		$('#regUser').submit();
	});

});
*/
