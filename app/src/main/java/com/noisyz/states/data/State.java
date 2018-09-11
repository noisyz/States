package com.noisyz.states.data;

import com.google.gson.annotations.SerializedName;
import com.noisyz.bindlibrary.annotation.Bind;
import com.noisyz.bindlibrary.wrappers.view.simple.text.FormattedText;
import com.noisyz.states.R;

import java.io.Serializable;

/**
 * Created by TESSARACT2 on 11.09.2018.
 */


@Bind(generateAdapters = true)
public class State implements Serializable {

    private String id, country, name, abbr, area, capital;

    @SerializedName("largest_city")
    private String largestCity;

    public String getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public String getLargestCity() {
        return largestCity;
    }

    public FormattedText getFormattedAbbr() {
        return new FormattedText(R.string.state_abbr, abbr);
    }
}
