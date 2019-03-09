package com.qfedu.serviceImp;

public class CheckNumber {
	private String[] numbers= {"18715000252","15012024562"};
	public boolean checkNumber(String number) {
		for (String string : numbers) {
			if(number.equals(string)) {
				return false;
			}
		}
		return true;
	}
}
