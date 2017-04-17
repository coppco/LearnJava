package com.github.IO;

public class Demo4_digui {

	/**
	 * @param args
	 * @throws IntException 
	 */
	public static void main(String[] args) throws IntException {
		int a = 10;
		long b = extracted(a);
		System.out.println(b);
	}

	private static long extracted(int a) throws IntException {
		if (a < 0) {
			throw new IntException("不能传入小于0 的数");
		} else if (a == 0) {
			return 1;
		} else if (a == 1) {
			return 1;
		} else {
			return a * extracted(a-1);
		}
	}

}

class IntException extends Exception {

	public IntException() {
		super();
		
	}

	public IntException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public IntException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public IntException(String message) {
		super(message);
		
	}

	public IntException(Throwable cause) {
		super(cause);
		
	}
	
}
