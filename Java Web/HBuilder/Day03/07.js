var arr = new Array(3);
arr[0] = ['苏州', '无锡', '常州', '徐州','连云港', '泰州'];
arr[1]= ['杭州', '宁波', '绍兴', '嘉兴', '湖州', '温州','台州', '丽水'];
arr[2] = ['郑州','许昌', '信阳', '焦作', '新乡', '南阳', '洛阳', '周口', '驻马店'];

function initCity() {

	var cityObj = document.getElementsByName('city')[0];
	for (var i = 0; i < arr[0].length; i++) {
		if (i == 0) {
			cityObj.innerHTML += "<option selected='selected'>" + arr[0][i] + "</option>"
		} else{
			cityObj.innerHTML += "<option>" + arr[0][i] + "</option>"
		}
		
	}
}

function selectPro(value) {
	var cities = arr[parseInt(value)];
	//获取城市下拉选
	var cityObj = document.getElementsByName('city')[0];
	//需要清空， 不然保留上次的元素
	cityObj.innerHTML = "<option>-请选择-</option>";
	for (var i = 0; i < cities.length; i++) {
		if (i == 0) {
			cityObj.innerHTML += "<option selected='selected'>" + cities[i] + "</option>"
		} else{
			cityObj.innerHTML += "<option>" + cities[i] + "</option>"
		}
	}
}

