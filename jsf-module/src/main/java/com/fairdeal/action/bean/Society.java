package com.fairdeal.action.bean;

public class Society {
	private String name;
	private String societyId;

	public Society(String societyId, String name) {
		this.name = name;
		this.societyId = societyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocietyId() {
		return societyId;
	}

	public void setSocietyId(String societyId) {
		this.societyId = societyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((societyId == null) ? 0 : societyId.hashCode());
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
		Society other = (Society) obj;
		if (societyId == null) {
			if (other.societyId != null)
				return false;
		} else if (!societyId.equals(other.societyId))
			return false;
		return true;
	}

}
