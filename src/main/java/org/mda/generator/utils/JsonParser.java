package org.mda.generator.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.mda.generator.metafacade.EntityMetafacade;

import com.google.gson.Gson;

public class JsonParser
{
    private static JsonParser mParser;
    private Gson mGson = new Gson();

    private JsonParser()
    {

    }

    public static JsonParser getInstance()
    {
        if( mParser == null )
        {
            mParser = new JsonParser();
        }
        return mParser;
    }

    public EntityMetafacade getEntityMetafacade( String fileName ) throws FileNotFoundException
    {
        FileReader lReader = new FileReader( fileName );
        return mGson.fromJson( lReader, EntityMetafacade.class );
    }

    public static void main( String[] args ) throws IOException
    {
        EntityMetafacade lEntityMetadata = getInstance().getEntityMetafacade( "E:\\Mine\\SimpleGenerator\\src\\main\\resources\\source\\Test.json" );
        TemplateEngine lEngine = new TemplateEngine();
        lEngine.generateFile( lEntityMetadata, "template/entity.vsl", "E:\\Mine\\SimpleGenerator\\src\\main\\java\\generated\\" );
    }

}
