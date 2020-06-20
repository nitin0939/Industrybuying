package com.industry.buying.industryBying.Enum;

public enum ColumnValueEnum {
	SPAM("spam"), 
	NOTSPAM("not-spam");
	
	private String value;

	public String getValue() {
		return this.value;
	}
	
	private ColumnValueEnum(String name) {
		this.value = name;
	}
}
