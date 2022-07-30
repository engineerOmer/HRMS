package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.WebsiteTypeService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.core.utilities.results.SuccessDataResult;
import inonu.hrms.core.utilities.results.SuccessResult;
import inonu.hrms.dataAccess.abstracts.WebsiteTypeRepository;
import inonu.hrms.entities.tables.WebsiteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WebsiteTypeManager implements WebsiteTypeService {

    private WebsiteTypeRepository websiteTypeRepository;

    @Autowired
    public WebsiteTypeManager(WebsiteTypeRepository websiteTypeRepository) {
        this.websiteTypeRepository = websiteTypeRepository;
    }

    @Override
    public DataResult<List<WebsiteType>> getAll() {
        return new SuccessDataResult<List<WebsiteType>>(this.websiteTypeRepository.findAll());
    }

    @Override
    public Result save(WebsiteType websiteType) {
        this.websiteTypeRepository.save(websiteType);

        return new SuccessResult();
    }
}
