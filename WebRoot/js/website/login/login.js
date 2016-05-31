$(function(){
	login.init();
	
});

var login={
		init:function(){
			$("#inputName").focus(function(){
				//$("#msg").html('');
			});
			$("#inputPassword").focus(function(){
				//$("#msg").html('');
			});
			console.info(localStorage.LocalAdminUserName);
			$("#inputName").val(localStorage.LocalAdminUserName);
			$("#inputPassword").val(localStorage.LocalAdminPassword);
			$("#login").click(login.startLogin);
			$('body').keydown(function(event) {
				if (event.keyCode == 13)
					login.startLogin();
			});
		},
		startLogin:function(){
			var name=$.trim($("#inputName").val());
			var pass=$.trim($("#inputPassword").val());
			var chk = $("#remer").is(":checked");
			if(name==""||pass==""){
				return false;
			}
			$.ajax({
				url:ctx+'/login/startlogin',
				type:'post',
				data:{name:name,password:pass,random:Math.random()},
				dataType:'html',
				success:function(data){
					if(data==JS_RESULT.SUCCESS){
						if(chk){
							localStorage.LocalAdminUserName=name;
							localStorage.LocalAdminPassword=pass;
						}else{
							localStorage.LocalAdminUserName='';
							localStorage.LocalAdminPassword='';
						}
						location.href=ctx+'/index/menu';
					}else{
						alert("账户密码错误");
					}
				}
			});
		}
	};