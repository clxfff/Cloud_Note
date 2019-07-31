$(function(){
    $("#register").click(function(){
        register();
    });
});

//注册
function register() {
	// 取值
	var userName = $("#regist_username").val();
	var password = $("#regist_password").val();
	var password2 = $("#final_password").val();
	var nickname = $("#nickname").val();
	// 校验用户名格式
	var reg = /^\w{3,20}$/;
	if(!reg.test(userName)) {
		$("#warning_1").text("3-20位的英文、数字、下划线.").show();
		return;
	} else {
		$("#warning_1").hide();
	}
	//校验密码
	if(password.length<6 || password != password2) {
		alert("两次密码不同!");
		return;
	}
	//进行注册
	var user = {
		"name":userName,
		"password":password,
		"nick":nickname
	};
	$.ajax({
		type:"POST",
		url:basePath+"user/add.do",
		dataType:"json",
		data:user,
		success:function(result) {
			if(result.status==0) {
					alert("注册成功.");
					$("#zc").attr("class","sig sig_out");
					$("#dl").attr("class","log log_in");
					// $("#warning_1").text("用户名已存在.").show();
			} else {
				alert(result.msg);
			}
		},
		error:function(xhr,status,error) {
			alert("请求失败.");
		}
	});
}