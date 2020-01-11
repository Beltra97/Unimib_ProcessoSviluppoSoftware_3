package worksocialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such Company Address")
public class AddressCompanyNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -8252953614783756469L;

  public AddressCompanyNotFoundException() {
    super();
  }

  public AddressCompanyNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public AddressCompanyNotFoundException(String message) {
    super(message);
  }

  public AddressCompanyNotFoundException(Throwable cause) {
    super(cause);
  }
}
