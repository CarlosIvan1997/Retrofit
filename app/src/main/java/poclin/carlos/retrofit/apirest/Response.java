package poclin.carlos.retrofit.apirest;

public class Response <Data>{

    public boolean status;
    public Body<Data> body;
    public Error error;

    public class Body <Data>{
        public String message;
        public Data data;
    }

    public class Error {
        public Integer errorcode;
        public String errorMessage;
    }

}
