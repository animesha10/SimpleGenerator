package org.mda.generator.metafacade;

import com.google.gson.annotations.SerializedName;

public class AttributeMetafacade
{
    @SerializedName( "attribute-name" )
    private String name;

    /**
     * @return the attribute
     */
    public String getAttribute()
    {
        return name;
    }

    /**
     * @param attribute the attribute to set
     */
    public void setAttribute( String name )
    {
        this.name = name;
    }
}
