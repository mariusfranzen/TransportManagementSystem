package database.apis.geoDBAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Marius on 2020-11-16.
 * @version %I%, %G%
 */
public class Metadata {

    @SerializedName("currentOffset")
    @Expose
    private Integer currentOffset;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    /**
     * @param currentOffset The current offset from the start of the list.
     * @param totalCount    The total count of cities listed.
     */
    public Metadata(Integer currentOffset, Integer totalCount) {
        super();
        this.currentOffset = currentOffset;
        this.totalCount = totalCount;
    }

    public Integer getCurrentOffset() {
        return currentOffset;
    }

    public void setCurrentOffset(Integer currentOffset) {
        this.currentOffset = currentOffset;
    }

    public Metadata withCurrentOffset(Integer currentOffset) {
        this.currentOffset = currentOffset;
        return this;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Metadata withTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("currentOffset", currentOffset).append("totalCount", totalCount).toString();
    }

}
