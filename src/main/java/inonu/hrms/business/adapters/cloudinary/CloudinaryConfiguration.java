package inonu.hrms.business.adapters.cloudinary;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "cloudinary")
@Getter
@Setter
@Validated
public class CloudinaryConfiguration {
    @NotNull
    private String apiKey;
    @NotNull
    private String secret;
    @NotNull
    private String cloudName;

    public String toString() {
        return "cloudinary://"+this.getApiKey()+":"+this.getSecret()+"@"+this.getCloudName();
    }
}