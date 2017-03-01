package org.mda.generator.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.mda.generator.metafacade.EntityMetafacade;

public class TemplateEngine
{

    VelocityEngine mVelocityEngine;

    public TemplateEngine()
    {
        mVelocityEngine = new VelocityEngine();
        mVelocityEngine.setProperty( RuntimeConstants.RESOURCE_LOADER, "classpath" );
        mVelocityEngine.setProperty( "classpath.resource.loader.class", ClasspathResourceLoader.class.getName() );
        mVelocityEngine.init();
    }

    public void generateFile( EntityMetafacade entity,
                              String templatePath,
                              String pathToGenerate ) throws IOException
    {

        Template lTemplate = mVelocityEngine.getTemplate( templatePath );
        VelocityContext context = new VelocityContext();
        context.put( "entity", entity );
        File dir = new File( pathToGenerate );
        dir.mkdirs();
        FileWriter writer = new FileWriter( new File( dir.getAbsolutePath() + File.separator + entity.getName() ) );
        lTemplate.merge( context, writer );
        writer.close();
    }
}
