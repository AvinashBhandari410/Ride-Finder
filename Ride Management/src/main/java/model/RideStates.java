package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class RideStates {
	
	@Id
	@Column(name="StateID",unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int StateID;
	
	@Column(name="StateName")
	private String StateName;
	
	public int getStateID() {
		return StateID;
	}

	public void setStateID(int stateID) {
		this.StateID = stateID;
	}

	public String getState() {
		return StateName;
	}

	public void setState(String state) {
		this.StateName = state;
	}

	public String getStateCode() {
		return StateCode;
	}

	public void setStateCode(String stateCode) {
		StateCode = stateCode;
	}

	@Column(name="StateCode")
	private String StateCode;
}
