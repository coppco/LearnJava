class Demo_Array {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		//arrayAlloc();
		arrayOperation();
	}


	//����Ķ���
	public static void arrayAlloc() {
		//��̬��ʼ��, ϵͳĬ�϶���0
		//��������[] ������ = new ��������[���鳤��];
		int[] arr = new int[5];

		arr[4] = 10;
		System.out.println(arr[4]);

		//��̬��ʼ��
		//��������[] ������ = new ��������[]{Ԫ��1,Ԫ��2,Ԫ��3,��};
		//��������[] ������ = {Ԫ��1, Ԫ��2,Ԫ��3,��};
		int[] arr1 = new int[]{1,2,3,4,511};
		arr1 = null;
		System.out.println(arr1[4]);
		

		//�����ע���
		//1 Խ��
		int[] arr11 = new int[]{1,2,3,4};
		arr11[10] = 10; //Խ��
		// ��ָ��
		int[] arr22 = new int[5];
		arr22 = null;
		arr22[10] = 10;  //��ָ��
	}

	//����Ĳ���
	public static void arrayOperation() {
		//1����
		//int[] arr = new int[]{11,22,33,44,55};
		int[] arr = {1,2,3,4,5,6};
			//for (int i = 0;i < 5 ;i++ ) { //����1
		for (int i = 0;i < arr.length ;i++ ) { //����2
			System.out.println(arr[i]);
		}
		forEach(arr);

		System.out.println("���ֵ��:" + max(arr));

		int[] array1 = {789,654,123,1,9};
		//��ת
		revert(array1);
		
		//��ά����
		erwei();
	}
	
	//����ı���
	public static void forEach(int[] arr) {
		for (int i = 0;i < arr.length ;i++ ) {
			System.out.println(arr[i]);
		}
	}


	//�������ֵ����Сֵ
	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1;i < arr.length ;i++ ) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	//���鷴ת
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


	//��ά����
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

		//����
		//ѡ�д���,  shift+table ����
		for (int i = 0;i < arr.length ;i++ ) {
			for (int j = 0;j < arr[i].length ;j++ ) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}


}
