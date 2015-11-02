package com.payhub.ws.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

public class TransactionAmount {
	
	private static final long serialVersionUID = -635976989093261428L;
	public static final Currency USD = Currency.getInstance("USD");
	private static final String CURRENCY_CODE= "en-US";
	private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;
	private static final String CURRENCY_CODE_REGEX = "USD";
	
	private BigDecimal amount = BigDecimal.ZERO;
	
    private String currency=USD.getCurrencyCode();

	public static TransactionAmount dollars(BigDecimal amount) {
		return new TransactionAmount(amount, USD);
	}

	public TransactionAmount() {
		super();

	}

	TransactionAmount(BigDecimal amount, Currency currency) {
		this(amount, currency, DEFAULT_ROUNDING);
	}

	TransactionAmount(BigDecimal amount, Currency currency,
			RoundingMode rounding) {
		this.amount = amount;
		this.currency = currency.getCurrencyCode();

		this.amount = amount.setScale(currency.getDefaultFractionDigits(),
				rounding);
	}

	

	public BigDecimal getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return getCurrency() + " " + getAmount();
	}

	public String toString(Locale locale) {
		return getCurrency() + " " + getAmount();
	}
}
