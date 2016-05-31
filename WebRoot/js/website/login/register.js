$(function(){
	register.init();
	
});

var register={
	init:function(){
		$("#save_register").click(register.save);
	},
	save:function(){
		var name=$.trim($("#name").val());
		var pass=$.trim($("#password").val());
		var repass=$.trim($("#repassword").val());
		var age=$.trim($("#age").val());
		var realName=$.trim($("#realName").val());
		var phone=$.trim($("#phone").val());
		var descript=$.trim($("#descript").val());
		var re = /^[0-9]*[1-9][0-9]*$/ ; //判断是否为正整数
		var cellp = /^0?1[3|4|5|8][0-9]\d{8}$/;//判断手机号码
		if(name==""){
			$("#error-name").html('请输入用户名');
			return false;
		}else
			$("#error-name").html('');
		if(pass==""){
			$("#error-password").html('请输入密码');
			return false;
		}else if(pass.length<6){
			$("#error-password").html('密码至少六位');
			return false;
		}else if(repass==""){
			$("#error-password").html('请输入确认密码');
			return false;
		}else if(pass!=repass){
			$("#error-password").html('确认密码不一致');
			return false;
		}else
			$("#error-password").html('');
		if(descript>99){
			$("#error-descript").html('太长啦');
			return false;
		}else
			$("#error-descript").html('');
		if(!cellp.test(phone)){
			$("#error-phone").html('请输入正确的手机号');
			return false;
		} 
		else
			$("#error-phone").html('');
		if(re.test(age)){
			if(parseInt(age)>150){
				$("#error-age").html('请输入正确年龄');
				return false;
			}
			else
				$("#error-age").html('');
		}
		else{
			$("#error-age").html('请输入正确年龄.');
			return false;
		}
		$.ajax({
			url:ctx+'/login/registersave',
			type:'post',
			data:$("#register_form").serialize(),
			dataType:'html',
			success:function(data){
				if(data==JS_RESULT.SUCCESS){
					alert("注册成功，跳转登录页面。");
					location.href=ctx+'/login/';
				}
			}
		});
	}


};