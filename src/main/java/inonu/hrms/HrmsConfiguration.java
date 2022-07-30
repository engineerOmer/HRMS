package inonu.hrms;

import inonu.hrms.business.adapters.cloudinary.CloudinaryConfiguration;
import inonu.hrms.core.dataAccess.concretes.BaseRepositoryImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableConfigurationProperties(value = {CloudinaryConfiguration.class})
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class HrmsConfiguration {
}
