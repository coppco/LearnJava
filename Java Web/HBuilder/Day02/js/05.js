function scrollImage() {
	//获取图片元素
	var image = document.getElementById("wheel");
	var index = 1;
	setInterval(function show() {
		index++;
		if (index >= 3) {
			index = 1;
		}
		image.src = "./img/" + index + ".jpg";

	}, 3000);
}
