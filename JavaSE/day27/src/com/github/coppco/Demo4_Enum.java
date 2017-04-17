package com.github.coppco;

public class Demo4_Enum {
	
}

/*public class Week {
	public static final Week MON = new Week();
	public static final Week TUE = new Week();
	private Week() {}
}*/
/*public class Week {
	public static final Week MON = new Week("星期一");
	public static final Week TUE = new Week("星期二");
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
	public static final Week MON = new Week("星期一") {
		public void show() {
			System.out.println(getName);
		};
	};
	public static final Week TUE = new Week("星期二") {
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
	MON("星期一"),TUE("星期二");
	
	private String name;
	private Week(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}*/

/*public abstract enum Week {
	MON("星期一") {
		@Override
		public void show() {
			System.out.println(getName());
		}
	},TUE("星期二") {
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
