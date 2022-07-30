package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.MediaService;
import inonu.hrms.business.adapters.cloudinary.CloudinaryAdapter;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.ErrorDataResult;
import inonu.hrms.core.utilities.results.MediaResult;
import inonu.hrms.core.utilities.results.SuccessDataResult;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MediaManager implements MediaService {

    private CloudinaryAdapter cloudinaryAdapter;

    @Autowired
    public MediaManager(CloudinaryAdapter cloudinaryAdapter) {
        this.cloudinaryAdapter = cloudinaryAdapter;
    }



    @Override
    public DataResult<MediaResult> setImage(File file) {
        return this.cloudinarySetImage(file);
    }


    private DataResult<MediaResult> cloudinarySetImage(File file) {
        DataResult<JSONObject> result = this.cloudinaryAdapter.imageUpload(file);
        JSONObject eagerJsonObject = result.getData().getJSONArray("eager").getJSONObject(0);
        MediaResult mediaResult = new MediaResult(eagerJsonObject.getString("url"), result.getData().getString("public_id"));
        if(!result.isSuccess()) {
            return new ErrorDataResult<MediaResult>(result.getMessage(), null);
        }

        return new SuccessDataResult<MediaResult>(result.getMessage(), mediaResult);
    }

}