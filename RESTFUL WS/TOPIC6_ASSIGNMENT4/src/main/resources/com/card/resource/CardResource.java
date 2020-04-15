

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
@Path("/card")
public class CardResource {
	

	@GET
	@Path("/{creditCardNumber}")
	@Produces(MediaType.TEXT_PLAIN)
	public String isValid(@PathParam("creditCardNumber") String creditCardNumber) {
		try {
			if (creditCardNumber != null && Long.valueOf(creditCardNumber) != null) {
				return String.valueOf(Long.valueOf(creditCardNumber) % 2 == 0);
			}
		} catch (NumberFormatException e) {
		}
		return String.valueOf(false);
	}

}
