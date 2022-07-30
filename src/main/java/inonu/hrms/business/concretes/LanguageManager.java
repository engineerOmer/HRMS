package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.LanguageService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.SuccessDataResult;
import inonu.hrms.core.utilities.results.SuccessResult;
import inonu.hrms.dataAccess.abstracts.LanguageRepository;
import inonu.hrms.entities.tables.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inonu.hrms.core.utilities.results.Result;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public DataResult<List<Language>> getAllByName(String name) {
        return new SuccessDataResult<List<Language>>(this.languageRepository.findFirst10ByNameContainingIgnoreCase(name));
    }

    @Override
    public Result save(Language language) {
        this.languageRepository.save(language);
        return new SuccessResult();
    }

}