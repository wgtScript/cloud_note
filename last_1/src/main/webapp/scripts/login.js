$(function(){
	$('#login').click(checkLogin);
	
	$('#count').on('blur',checkName).focus();
	
	$('#password').on('blur',checkPassword);
	
	$(window).keydown(function(e){
		if(e.keyCode==13){
			console.log('Enter');
			$('#login').click();
		}
	});
})

function checkLogin(){
	console.log('checkLogin');
	if(checkName()+checkPassword()!=2){
		return;
	}
	
	
	var username=$('#count').val();
	var password=$('#password').val();
	$.getJSON('login.do',{username:username,password:password},function(data){
			console.log(data.state);
			if(data.state==1){
				console.log('登录成功,跳转');
				setCookie('userId',data.data.id);
				location.href='edit.html';
				return;
			}
			if(data.state==2){
			//	console.log('用户名错误');
				$('#count').next().show().text(data.message);
				return;
			}
			if(data.state==3){
			//	console.log('密码错误');
				$('#password').next().show().text(data.message);
				return;
			}
			if(data.state==0){
				console.log('查无此人');
			}
		});
}
function checkName(){
	console.log('checkName()');
	var username=$('#count').val();
	if (username==""){
		$('#count').next().show().text('没填名字');
		return;
	}
	$('#count').next().hide();
	return true;
}
function checkPassword(){
	console.log("checkPassword");
	var password=$('#password').val();
	if(password==""){
		$('#password').next().show().text('没填密码');
		return;
	}
	var reg=/^\w{3,10}$/;
	if(!reg.test(password)){
		$('#password').next().show().text('密码长度不符');
		return;
	}
	$('#password').next().hide();
	return true;
}
