package org.mda.generator.metafacade;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class EntityMetafacade
{
    @SerializedName( "entity-name" )
    private String name;

    @SerializedName( "attributes" )
    private List<AttributeMetafacade> attributes;

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name )
    {
        this.name = name;
    }

    /**
     * @return the attributes
     */
    public List<AttributeMetafacade> getAttributes()
    {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes( List<AttributeMetafacade> attributes )
    {
        this.attributes = attributes;
    }
}
