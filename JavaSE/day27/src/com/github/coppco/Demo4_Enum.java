package com.github.coppco;

public class Demo4_Enum {
	
}

/*public class Week {
	public static final Week MON = new Week();
	public static final Week TUE = new Week();
	private Week() {}
}*/
/*public class Week {
	public static final Week MON = new Week("����һ");
	public static final Week TUE = new Week("���ڶ�");
	private Week() {}
	
	private String name;
	private Week(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}*/

/*public abstract class Week {
	public static final Week MON = new Week("����һ") {
		public void show() {
			System.out.println(getName);
		};
	};
	public static final Week TUE = new Week("���ڶ�") {
		public void show() {
			System.out.println(getName);
		};
	};
	
	private String name;

	private Week() {}

	private Week(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public abstract void show();
}*/

/*public enum Week {
	MON,TUE;
}*/

/*public enum Week {
	MON("����һ"),TUE("���ڶ�");
	
	private String name;
	private Week(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}*/

/*public abstract enum Week {
	MON("����һ") {
		@Override
		public void show() {
			System.out.println(getName());
		}
	},TUE("���ڶ�") {
		@Override
		public void show() {
			System.out.println(getName());
		}
	};
	private String name;

	public String getName() {
		return name;
	}

	private Week(String name) {
		this.name = name;
	}

	public abstract void show();
	
}*/
