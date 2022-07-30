package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.WebsiteType;

import java.util.List;

public interface WebsiteTypeService {
    DataResult<List<WebsiteType>> getAll();
    Result save(WebsiteType websiteType);
}
