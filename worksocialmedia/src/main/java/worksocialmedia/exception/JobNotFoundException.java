package worksocialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such Job")
public class JobNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -8252953614783756469L;

  public JobNotFoundException() {
    super();
  }

  public JobNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public JobNotFoundException(String message) {
    super(message);
  }

  public JobNotFoundException(Throwable cause) {
    super(cause);
  }
}
