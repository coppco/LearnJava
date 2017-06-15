function loadEnd() {
	var arrs = document.getElementsByTagName('tr');
	for (var i = 0; i < arrs.length; i++) {
		if (i % 2 == 0) {
			arrs[i].style.backgroundColor = '#FFFFCC';
		} else {
			arrs[i].style.backgroundColor = '#BCD68D';
		}
	}
}


function moved(objc) {
	objc.style.backgroundColor = "red";
}

function leaved(objc) {
	objc.style.backgroundColor = "white"
}
