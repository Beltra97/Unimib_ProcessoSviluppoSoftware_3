package worksocialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such User Address")
public class AddressUserNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -8252953614783756469L;

  public AddressUserNotFoundException() {
    super();
  }

  public AddressUserNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public AddressUserNotFoundException(String message) {
    super(message);
  }

  public AddressUserNotFoundException(Throwable cause) {
    super(cause);
  }
}
