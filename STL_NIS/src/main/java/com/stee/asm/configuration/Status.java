package com.stee.asm.configuration;

/**
 *数据库获取燃烧时间和开关状态的类
 */
public class Status {
	private Integer burningHour;
	private boolean isLampOn;
	
	public Status(){
		
	}

	public Integer getBurningHour() {
		return burningHour;
	}

	public void setBurningHour(Integer burningHour) {
		this.burningHour = burningHour;
	}

	public boolean isLampOn() {
		return isLampOn;
	}

	public void setLampOn(boolean isLampOn) {
		this.isLampOn = isLampOn;
	}
	
}
