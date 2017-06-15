function scrollImage() {
	//获取图片元素
	var image = document.getElementById("wheel1");
	var index = 1;
	setInterval(function show() {
		index++;
		if (index >= 3) {
			index = 1;
		}
		image.src = "./img/" + index + ".jpg";

	}, 1000);
	
//	var ad = document.getElementById('ad');
//
//	setInterval(function showAd() {
//		ad.style.display = 'inherit';
//	}, 4000);
}



