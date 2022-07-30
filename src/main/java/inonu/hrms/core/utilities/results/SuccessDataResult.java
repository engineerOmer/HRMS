package inonu.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{
/*
    public SuccessDataResult(T data, String message) {
        super(data, true,message);
    }

    public SuccessDataResult(T data){
        super(data,true);
    }
    //alternatif sonuclar
    public SuccessDataResult(String message) {
        super(null, true,message);
    }
    public SuccessDataResult() {
        super(null,true);
    }
    public SuccessDataResult(T data) {
        super(true, data);
    }

   public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }*/
    public SuccessDataResult(T data) {
        super(true, data);
    }

        public SuccessDataResult(String message, T data) {
            super(true, message, data);
        }


}
