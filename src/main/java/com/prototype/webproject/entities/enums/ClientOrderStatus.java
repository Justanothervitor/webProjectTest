package com.prototype.webproject.entities.enums;

public enum ClientOrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	
	private int code;
	
	private ClientOrderStatus (int code)
	{
		this.code = code;
	}
	
	public int getCode()
	{
		return code;
	}
	
	public static ClientOrderStatus valueOf(int code)
	{
		for(ClientOrderStatus value: ClientOrderStatus.values())
		{
			if(value.getCode() == code )
			{
				return value;
			}
		}throw new IllegalArgumentException("Invalid ClientOrderStatus code man!");
	}
	
}
