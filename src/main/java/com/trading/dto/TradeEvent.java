package com.trading.dto;

/**
 * The Class TradeEvent.
 * 
 * @author Ankur Sharma
 */
public class TradeEvent {

	/** The id. */
	int id;

	/** The trading event type. */
	String tradingEventType;

	/** The trading accont. */
	String tradingAccont;

	/** The security identifier. */
	String securityIdentifier;

	/** The no of units. */
	int numberOfUnits;

	/** The raw input from user. */
	String rawInputFromUser;

	/**
	 * Instantiates a new trade event.
	 */
	public TradeEvent() {

	}

	/**
	 * Instantiates a new trade event.
	 *
	 * @param id                 the id
	 * @param tradingEventType   the trading event type
	 * @param tradingAccont      the trading accont
	 * @param securityIdentifier the security identifier
	 * @param numberOfUnits      the number of units
	 * @param rawInputFromUser   the raw input from user
	 */
	public TradeEvent(int id, String tradingEventType, String tradingAccont, String securityIdentifier,
			int numberOfUnits, String rawInputFromUser) {
		this.id = id;
		this.tradingEventType = tradingEventType;
		this.tradingAccont = tradingAccont;
		this.securityIdentifier = securityIdentifier;
		this.numberOfUnits = numberOfUnits;
		this.rawInputFromUser = rawInputFromUser;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the trading event type.
	 *
	 * @return the trading event type
	 */
	public String getTradingEventType() {
		return tradingEventType;
	}

	/**
	 * Sets the trading event type.
	 *
	 * @param tradingEventType the new trading event type
	 */
	public void setTradingEventType(String tradingEventType) {
		this.tradingEventType = tradingEventType;
	}

	/**
	 * Gets the trading accont.
	 *
	 * @return the trading accont
	 */
	public String getTradingAccont() {
		return tradingAccont;
	}

	/**
	 * Sets the trading accont.
	 *
	 * @param tradingAccont the new trading accont
	 */
	public void setTradingAccont(String tradingAccont) {
		this.tradingAccont = tradingAccont;
	}

	/**
	 * Gets the security identifier.
	 *
	 * @return the security identifier
	 */
	public String getSecurityIdentifier() {
		return securityIdentifier;
	}

	/**
	 * Sets the security identifier.
	 *
	 * @param securityIdentifier the new security identifier
	 */
	public void setSecurityIdentifier(String securityIdentifier) {
		this.securityIdentifier = securityIdentifier;
	}

	/**
	 * Gets the number of units.
	 *
	 * @return the number of units
	 */
	public int getNumberOfUnits() {
		return numberOfUnits;
	}

	/**
	 * Sets the number of units.
	 *
	 * @param numberOfUnits the new number of units
	 */
	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	/**
	 * Gets the raw input from user.
	 *
	 * @return the raw input from user
	 */
	public String getRawInputFromUser() {
		return rawInputFromUser;
	}

	/**
	 * Sets the raw input from user.
	 *
	 * @param rawInputFromUser the new raw input from user
	 */
	public void setRawInputFromUser(String rawInputFromUser) {
		this.rawInputFromUser = rawInputFromUser;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "[id:" + this.id + "," + this.tradingEventType + "," + this.tradingAccont + "," + this.securityIdentifier
				+ "," + this.numberOfUnits + "]";
	}
}
