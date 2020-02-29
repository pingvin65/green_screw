import org.springframework.data.rest.core.config.EnumTranslationConfiguration;
import org.springframework.data.rest.core.config.MetadataConfiguration;
import org.springframework.data.rest.core.config.ProjectionDefinitionConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


public class MyWebConfiguration extends RepositoryRestConfiguration{

	public MyWebConfiguration(ProjectionDefinitionConfiguration projectionConfiguration,
			MetadataConfiguration metadataConfiguration, EnumTranslationConfiguration enumTranslationConfiguration) {
		super(projectionConfiguration, metadataConfiguration, enumTranslationConfiguration);
		// TODO Auto-generated constructor stub
	}
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		  config.setPageParamName("p")
		        .setLimitParamName("l")
		        .setSortParamName("q");
		}
}
