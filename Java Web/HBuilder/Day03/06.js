onload = function() {

	document.getElementById('toRightOne').onclick = function() {
		var arrs = document.getElementById('left').options;
		for (var i = 0; i < arrs.length; i++) {
			if (arrs[i].selected) {
				document.getElementById('right').appendChild(arrs[i]);
				break;
			}
		}
	};
	
	document.getElementById('toRightTwo').onclick = function() {
		var arrs = document.getElementById('left').options;
		for (var i = 0; i < arrs.length; i++) {
			if (arrs[i].selected) {
				document.getElementById('right').appendChild(arrs[i]);
				//注意移除后数组的长度会变化
				i--;
			}
		}
	};
	
	document.getElementById('toRightMore').onclick = function() {
		var arrs = document.getElementById('left').options;
		//可以把++、--都去掉
		for (var i = 0; i < arrs.length;) {
			document.getElementById('right').appendChild(arrs[i]);
		}
	};
	
	document.getElementById('toLeftOne').onclick = function() {
		var arrs = document.getElementById('right').options;
		for (var i = 0; i < arrs.length; i++) {
			if (arrs[i].selected) {
				document.getElementById('left').appendChild(arrs[i]);
				break;
			}
		}
	};
	
	document.getElementById('toLeftTwo').onclick = function() {
		var arrs = document.getElementById('right').options;
		for (var i = 0; i < arrs.length; i++) {
			if (arrs[i].selected) {
				document.getElementById('left').appendChild(arrs[i]);
				i--;
			}
		}
	};
	
	document.getElementById('toLeftMore').onclick = function() {
		var arrs = document.getElementById('right').options;
		for (var i = 0; i < arrs.length; i++) {
			document.getElementById('left').appendChild(arrs[i]);
			i--;
		}
	};
}
