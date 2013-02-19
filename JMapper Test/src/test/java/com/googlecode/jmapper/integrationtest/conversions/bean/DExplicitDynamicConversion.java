package com.googlecode.jmapper.integrationtest.conversions.bean;

public class DExplicitDynamicConversion {

	private String destination;
	private String destination2;
	private String destination3;
	private String destination4;
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	public String getDestination2() {
		return destination2;
	}

	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}
	
	public String getDestination3() {
		return destination3;
	}

	public void setDestination3(String destination3) {
		this.destination3 = destination3;
	}

	public String getDestination4() {
		return destination4;
	}

	public void setDestination4(String destination4) {
		this.destination4 = destination4;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result
				+ ((destination2 == null) ? 0 : destination2.hashCode());
		result = prime * result
				+ ((destination3 == null) ? 0 : destination3.hashCode());
		result = prime * result
				+ ((destination4 == null) ? 0 : destination4.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DExplicitDynamicConversion other = (DExplicitDynamicConversion) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (destination2 == null) {
			if (other.destination2 != null)
				return false;
		} else if (!destination2.equals(other.destination2))
			return false;
		if (destination3 == null) {
			if (other.destination3 != null)
				return false;
		} else if (!destination3.equals(other.destination3))
			return false;
		if (destination4 == null) {
			if (other.destination4 != null)
				return false;
		} else if (!destination4.equals(other.destination4))
			return false;
		return true;
	}

	/**
	 * @param destination
	 * @param destination2
	 * @param destination3
	 * @param destination4
	 */
	public DExplicitDynamicConversion(String destination, String destination2,
			String destination3, String destination4) {
		super();
		this.destination = destination;
		this.destination2 = destination2;
		this.destination3 = destination3;
		this.destination4 = destination4;
	}

	@Override
	public String toString() {
		return "DExplicitDynamicConversion: destination(" + destination
				+ ") destination2(" + destination2 + ") destination3("
				+ destination3 + ") destination4(" + destination4 + ")";
	}

	public DExplicitDynamicConversion() {}
}
