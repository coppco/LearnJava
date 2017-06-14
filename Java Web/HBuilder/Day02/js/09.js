function checkValue() {
//获取用户名
	var username = document.getElementById('name_input').value;
//获取密码
	var password = document.getElementById('password_input').value;

	var result = (username.length != 0 && password.length != 0);
	
	if (!result) {
		confirm('用户名或密码不能为空, 请重新输入!');
	}
	return result;
}

//var sayHi = 
//      new Function("sName", "sMessage", "alert(\"Hello \" + sName + sMessage);");

document.getElementById('haha').onclick = function login() {
	alert('登录');
}




