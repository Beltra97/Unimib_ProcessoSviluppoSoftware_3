package worksocialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such Company")
public class CompanyNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -8252953614783756469L;

  public CompanyNotFoundException() {
    super();
  }

  public CompanyNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public CompanyNotFoundException(String message) {
    super(message);
  }

  public CompanyNotFoundException(Throwable cause) {
    super(cause);
  }
}
