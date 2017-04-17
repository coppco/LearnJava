class Demo_Array {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		//arrayAlloc();
		arrayOperation();
	}


	//数组的定义
	public static void arrayAlloc() {
		//动态初始化, 系统默认都是0
		//数据类型[] 数组名 = new 数据类型[数组长度];
		int[] arr = new int[5];

		arr[4] = 10;
		System.out.println(arr[4]);

		//静态初始化
		//数据类型[] 数组名 = new 数据类型[]{元素1,元素2,元素3,…};
		//数据类型[] 数组名 = {元素1, 元素2,元素3,…};
		int[] arr1 = new int[]{1,2,3,4,511};
		arr1 = null;
		System.out.println(arr1[4]);
		

		//数组的注意点
		//1 越界
		int[] arr11 = new int[]{1,2,3,4};
		arr11[10] = 10; //越界
		// 空指针
		int[] arr22 = new int[5];
		arr22 = null;
		arr22[10] = 10;  //空指针
	}

	//数组的操作
	public static void arrayOperation() {
		//1遍历
		//int[] arr = new int[]{11,22,33,44,55};
		int[] arr = {1,2,3,4,5,6};
			//for (int i = 0;i < 5 ;i++ ) { //方法1
		for (int i = 0;i < arr.length ;i++ ) { //方法2
			System.out.println(arr[i]);
		}
		forEach(arr);

		System.out.println("最大值是:" + max(arr));

		int[] array1 = {789,654,123,1,9};
		//反转
		revert(array1);
		
		//二维数组
		erwei();
	}
	
	//数组的遍历
	public static void forEach(int[] arr) {
		for (int i = 0;i < arr.length ;i++ ) {
			System.out.println(arr[i]);
		}
	}


	//数组最大值和最小值
	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1;i < arr.length ;i++ ) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	//数组反转
	public static void revert(int[] arr) {
		for (int i = 0;i< arr.length ;i++ ) {
			System.out.println(arr[i]);
		}
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

		for (int x = 0;x< arr.length ;x++ ) {
			System.out.println(arr[x]);
		}
	}


	//二维数组
	public static void erwei() {
		int[][] arr = new int[3][2];
		arr[0][0] = 100;
		arr[2][1] = 1;
		int[] arr1[] = new int[3][4];

		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[0][0]);

		int[][] arr11 = new int[3][];
		System.out.println(arr11[0]);

		//遍历
		//选中代码,  shift+table 缩进
		for (int i = 0;i < arr.length ;i++ ) {
			for (int j = 0;j < arr[i].length ;j++ ) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}


}
