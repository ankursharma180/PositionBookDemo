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
	 */
	public TradeEvent(int id, String tradingEventType, String tradingAccont, String securityIdentifier,
			int numberOfUnits) {
		this.id = id;
		this.tradingEventType = tradingEventType;
		this.tradingAccont = tradingAccont;
		this.securityIdentifier = securityIdentifier;
		this.numberOfUnits = numberOfUnits;
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
	 * Gets the trading event type.
	 *
	 * @return the trading event type
	 */
	public String getTradingEventType() {
		return tradingEventType;
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
	 * Gets the security identifier.
	 *
	 * @return the security identifier
	 */
	public String getSecurityIdentifier() {
		return securityIdentifier;
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
