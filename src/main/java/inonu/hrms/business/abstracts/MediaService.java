package inonu.hrms.business.abstracts;

import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.MediaResult;

import java.io.File;

public interface MediaService {
    DataResult<MediaResult> setImage(File file);
}
