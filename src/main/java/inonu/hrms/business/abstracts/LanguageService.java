package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.Language;

import java.util.List;

public interface LanguageService {
        DataResult<List<Language>> getAllByName(String name);
        Result save(Language language);
}
