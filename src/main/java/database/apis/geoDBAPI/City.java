package database.apis.geoDBAPI;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Marius on 2020-11-16.
 * @version %I%, %G%
 */
public class City {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    /**
     * No args constructor for use in serialization
     */
    public City() {
    }

    /**
     * @param metadata The metadata for the City API.
     * @param data     The data for the City API. This is a list of 5 cities in Sweden, with a population of at least 60 000 people.
     * @param links    Links for the City API.
     */
    public City(List<Datum> data, List<Link> links, Metadata metadata) {
        super();
        this.data = data;
        this.links = links;
        this.metadata = metadata;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public City withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public City withLinks(List<Link> links) {
        this.links = links;
        return this;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public City withMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).append("links", links).append("metadata", metadata).toString();
    }

}
