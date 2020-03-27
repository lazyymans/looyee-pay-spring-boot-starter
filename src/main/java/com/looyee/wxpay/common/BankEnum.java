package com.looyee.wxpay.common;

public enum BankEnum {
	ICBC("1002", "工商银行"),
	ABC("1005", "农业银行"),
	BOC("1026", "中国银行"),
	CCB("1003", "建设银行"),
	CMB("1001", "招商银行"),
	PSBC("1066", "邮储银行"),
	BCM("1020", "交通银行"),
	SPDB("1004", "浦发银行"),
	CMBC("1006", "民生银行"),
	CIB("1009", "兴业银行"),
	PA("1010", "平安银行"),
	CITIC("1021", "中信银行"),
	HX("1025", "华夏银行"),
	GDB("1027", "广发银行"),
	CEB("1022", "光大银行"),
	BOB("4836", "北京银行"),
	BONN("1056", "宁波银行"),
	BOSH("1024", "上海银行"),
	;

	private String code;
	private String name;

	BankEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getNameByCode(String code) {
		for (BankEnum ade : BankEnum.values()) {
			if (ade.getCode().equals(code)) {
				return ade.name;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
