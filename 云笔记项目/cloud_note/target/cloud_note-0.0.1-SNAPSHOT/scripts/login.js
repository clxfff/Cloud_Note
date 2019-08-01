
(function ($) {
    "use strict";


     /*==================================================================
    [ Focus input ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })
    })


    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }



})(jQuery);

/**
 * 页面初始化后，绑定函数。
 */
$(function(){
	
	//登录
	$("#login").click(function(){
		login();
	});
	
});



//登陆
function login() {
	var username = $("#username").val();
	var password = $("#password").val();
	if(username=="" || password=="") {
		return;
	}
	$.ajax({
		type:"POST",
		url:basePath+"user/login.do",
		dataType:"json",
		data:{"name":username,"password":password},
		success: function(result) {
			console.log(result);
			if(result.status==0) {
					//登陆成功，进入系统
					location.href="edit.html";
					addCookie("userId",result.data.cn_user_id,5);
					addCookie("userName",result.data.cn_user_name,5);
					alert(result.msg);
			} else {
				alert(result.msg);
			}
		},
		error:function(xhr,status,error) {
			alert("请求失败.");
		}
	});
}

/**
 * 退出登录
 */
// function logout(){
// 	//注销登陆信息
// 	$.ajax({
// 		type:"post",
// 		url:basePath+"user/logout.do",
// 		dataType:"json",
// 		data:{},
// 		success:function(result) {
// 			if(result.status==0) {
// 				//退回到登陆页
// 				location.href="login.html";
// 			} else {
// 				alert(result.message);
// 			}
// 		},
// 		error:function(xhr,status,error) {
// 			alert("请求失败.");
// 		}
// 	});
// }



