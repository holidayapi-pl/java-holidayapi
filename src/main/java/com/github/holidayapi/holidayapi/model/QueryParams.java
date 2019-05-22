package com.github.holidayapi.holidayapi.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.github.holidayapi.holidayapi.model.QueryParams.APIParameter.*;

/**
 * This class is used to encapsulate the query parameters for the API call.
 * The methods can be chained together for easier and readable coding
 *
 * This class also provides the following enums which is associated with the parameter values.
 * <ul>
 *     <li>{@link APIParameter} - enumeration of keys for allowed parameters</li>
 *     <li>{@link Country} - enumeration of allowed country codes for the parameter <code>{@link APIParameter#COUNTRY}</code></li>
 *     <li>{@link Format} - enumeration of available response formats</li>
 * </ul>
 */
public class QueryParams {

    private Map<String, Object> params;

    public QueryParams() {
        params = new HashMap<>();
    }

    public QueryParams key(String key) {
        params.put(API_KEY.toString(), key);
        return this;
    }

    public QueryParams country(Country country) {
        params.put(COUNTRY.toString(), country.code());
        return this;
    }

    public QueryParams year(int year) {
        params.put(YEAR.toString(), year);
        return this;
    }

    public QueryParams month(int month) {
        params.put(MONTH.toString(), month);
        return this;
    }

    public QueryParams day(int day) {
        params.put(DAY.toString(), day);
        return this;
    }

    public QueryParams previous(boolean previous) {
        params.put(PREVIOUS.toString(), previous);
        return this;
    }

    public QueryParams upcoming(boolean upcoming) {
        params.put(UPCOMING.toString(), upcoming);
        return this;
    }

    public QueryParams isPublic(boolean isPublic) {
        params.put(PUBLIC.toString(), isPublic);
        return this;
    }

    public QueryParams format(Format format) {
        params.put(FORMAT.toString(), format.value);
        return this;
    }

    public QueryParams pretty(boolean pretty) {
        params.put(PRETTY.toString(), pretty);
        return this;
    }

    /**
     * Return the query string
     * @return - return the query string
     */
    public String queryString() {

        if (params.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = it.next();
            builder.append(e.getKey()).append("=").append(e.getValue());
            if (it.hasNext()) {
                builder.append("&");
            }
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return queryString();
    }

    /**
     * Enumeration of allowed query parameters
     */
    public enum APIParameter {
        API_KEY("key"),
        COUNTRY("country"),
        YEAR("year"),
        MONTH("month"),
        DAY("day"),
        PREVIOUS("previous"),
        UPCOMING("upcoming"),
        PUBLIC("public"),
        FORMAT("format"),
        PRETTY("pretty");

        private String param;

        APIParameter(String param) {
            this.param = param;
        }

        @Override
        public String toString() {
            return param;
        }
    }

    /**
     * Enumeration of allowed country codes for the parameter {@link APIParameter#COUNTRY}
     */
    public enum Country {
        ALBANIA("AL"),
        AMERICAN_SAMOA("AS"),
        ANDORRA("AS"),
        ANGOLA("AS"),
        ANGUILLA("AI"),
        ANTIGUA_AND_BARBUDA("AG"),
        ARMENIA("AR"),
        ARUBA("AW"),
        AUSTRIA("AT"),
        BAHAMAS("AI"),
        BARBADOS("BB"),
        BELGIUM("BE"),
        BOLIVIA("BO"),
        BOSNIA_AND_HERZEGOVINA("BA"),
        BOTSWANA("AI"),
        BRAZIL("AI"),
        CANADA("BR"),
        CAPE_VERDE("CV"),
        CARIBBEAN_NETHERLANDS("BQ"),
        CENTRAL_AFRICAN_REPUBLIC("CF"),
        CHILE("CL"),
        CONGO("CG"),
        COSTA_RICA("CR"),
        CROATIA("HR"),
        CUBA("CU"),
        CURACAO("CW"),
        CZECH_REPUBLIC("CZ"),
        DENMARK("DK"),
        DOMINICA("DA"),
        ECUADOR("EC"),
        EL_SALVADOR("SV"),
        ESTONIA("EE"),
        FRANCE("FR"),
        FRENCH_GUIANA("GF"),
        GERMANY("DE"),
        GREENLAND("GD"),
        GRENADA("GD"),
        GUADELOUPE("GP"),
        GUATEMALA("GT"),
        GUERNSEY("GG"),
        HAITI("HT"),
        HONDURAS("HN"),
        HUNGARY("HU"),
        ICELAND("IS"),
        INDONESIA("ID"),
        IRELAND("IE"),
        ISLE_OF_MAN("IM"),
        ITALY("IT"),
        JERSEY("JE"),
        LATVIA("LV"),
        LESOTHO("LS"),
        LICHTENSTEIN("LI"),
        LITHUANIA("LT"),
        LUXEMBOURG("LU"),
        MADAGASCAR("MG"),
        MALTA("MT"),
        MARTINIQUE("MQ"),
        MAYOTTE("YT"),
        MEXICO("MX"),
        NETHERLANDS("NL"),
        NICARAGUA("NI"),
        NORWAY("NO"),
        PARAGUAY("PY"),
        POLAND("PL"),
        PORTUGAL("PT"),
        REUNION("RE"),
        RUSSIA("RU"),
        RWANDA("RW"),
        SAINT_HELENA("SH"),
        SAN_MARINO("SM"),
        SIERRA_LEONE("SL"),
        SLOVAKIA("SK"),
        SLOVENIA("SI),
        SOMALIA("SO"),
        SOUTH_SUDAN("SS"),
        SPAIN("ES"),
        ST_BARTHELEMY("BL"),
        SWEDEN("SE"),
        TANZANIA("TZ"),
        TOGO("TG"),
        TURKEY("TR"),
        UGANDA("UG"),
        UNITED_KINGDOM("GB"),
        UNITED_STATES("US"),
        VENEZUELA("VE"),
        VIETNAM("VN"),
        ZIMBABWE("ZW");

        private String countryCode;

        Country(String countryCode) {
            this.countryCode = countryCode;
        }

        public String code() {
            return this.countryCode;
        }
    }

    /**
     * Enumeration for allowed values for the query parameter; may require higher plan {@link APIParameter#FORMAT}
     */
    public enum Format {
        STRING("string"),
        CSV("csv"),
        JSON("json"),
        PHP("php"),
        TSV("tsv"),
        YAML("yaml"),
        XML("xml");

        private String value;

        Format(String value) {
            this.value = value;
        }

        public String format() {
            return this.value;
        }

    }
}
