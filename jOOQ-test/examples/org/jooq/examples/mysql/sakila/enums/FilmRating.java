/**
 * This class is generated by jOOQ
 */
package org.jooq.examples.mysql.sakila.enums;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public enum FilmRating implements org.jooq.EnumType {
	G("G"),

	PG("PG"),

	PG_13("PG-13"),

	R("R"),

	NC_17("NC-17"),

	;

	private final java.lang.String literal;

	private FilmRating(java.lang.String literal) {
		this.literal = literal;
	}

	@Override
	public java.lang.String getName() {
		return "film_rating";
	}

	@Override
	public java.lang.String getLiteral() {
		return literal;
	}
}
