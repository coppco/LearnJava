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


function getValue(name) {
	if (name == "username") {
		//获取value值
		var text = document.getElementById('name_input').value;
		if (text.length == 0) {
			document.getElementById("name_desc").innerHTML = "用户名不能为空";
		} else {
			document.getElementById("name_desc").innerHTML = "";
		}

	} else if (name == "password"){
		var text = document.getElementById('password_input').value;
		if (text.length == 0) {
			document.getElementById("password_desc").innerHTML = "密码不能为空";
		} else {
			document.getElementById("password_desc").innerHTML = "";
		}
	}
}

function clearText(name) {
	if (name == "username") {
			document.getElementById("name_desc").innerHTML = "";

	} else if (name == "password"){
			document.getElementById("password_desc").innerHTML = "";
	}
}


