package inonu.hrms.business.adapters;


import inonu.hrms.business.abstracts.IdentityValidationService;
import inonu.hrms.core.utilities.results.ErrorResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;
import outsource.tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

@Service
public class MernisAdapter implements IdentityValidationService {

    @Override
    public Result checkIdentityNumber(String identityNumber, String firstName, String lastName, Date birthDate) {
        KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
        boolean result = true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(birthDate.getTime());
        try {
            result = kpsPublicSoapProxy.TCKimlikNoDogrula(
                    Long.parseLong(identityNumber),
                    firstName.toUpperCase(),
                    lastName.toUpperCase(),
                    calendar.get(Calendar.YEAR)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(result) {
            return new SuccessResult();
        }else {
            return new ErrorResult(firstName.toUpperCase() + " " + lastName.toUpperCase() + " : Kimlik doğrulama başarısız.");
        }

    }

}