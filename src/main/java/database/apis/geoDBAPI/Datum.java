package database.apis.geoDBAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Marius on 2020-11-16.
 * @version %I%, %G%
 */
public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("wikiDataId")
    @Expose
    private String wikiDataId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("regionCode")
    @Expose
    private String regionCode;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;

    /**
     * No args constructor for use in serialization
     */
    public Datum() {
    }

    /**
     * @param country     The country this city is located in.
     * @param wikiDataId  WikiData ID for this city.
     * @param regionCode  The region this city is located it.
     * @param city        The city.
     * @param countryCode The 2 letter country code for this country.
     * @param latitude    Latitude coordinates for this city.
     * @param name        The name of this city.
     * @param id          Unique ID for this city.
     * @param type        If this is a village, city et.c.
     * @param region      What region this city is located in.
     * @param longitude   THe longitude coordinates for this city.
     */
    public Datum(Integer id, String wikiDataId, String type, String city, String name, String country, String countryCode, String region, String regionCode, Double latitude, Double longitude) {
        super();
        this.id = id;
        this.wikiDataId = wikiDataId;
        this.type = type;
        this.city = city;
        this.name = name;
        this.country = country;
        this.countryCode = countryCode;
        this.region = region;
        this.regionCode = regionCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Datum withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getWikiDataId() {
        return wikiDataId;
    }

    public void setWikiDataId(String wikiDataId) {
        this.wikiDataId = wikiDataId;
    }

    public Datum withWikiDataId(String wikiDataId) {
        this.wikiDataId = wikiDataId;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Datum withType(String type) {
        this.type = type;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Datum withCity(String city) {
        this.city = city;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Datum withName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Datum withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Datum withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Datum withRegion(String region) {
        this.region = region;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Datum withRegionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Datum withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Datum withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("wikiDataId", wikiDataId).append("type", type).append("city", city).append("name", name).append("country", country).append("countryCode", countryCode).append("region", region).append("regionCode", regionCode).append("latitude", latitude).append("longitude", longitude).toString();
    }

}
