package toolstask1;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/")
public class CalculationService {
    //@Inject
    //private CalculationRepo DB;

    public CalculationService() {
    }

    @Path("calc")
    @POST
    public int calculate(CalculationForm calculation) {
        int result;
        switch (calculation.getOperation()) {
            case "+":
                result = calculation.getNumber1() + calculation.getNumber2();
                break;
            case "-":
                result = calculation.getNumber1() - calculation.getNumber2();
                break;
            case "*":
                result = calculation.getNumber1() * calculation.getNumber2();
                break;
            case "/": {
                if (calculation.getNumber2() == 0)
                    throw new IllegalArgumentException("Can't divide by zero");
                result = calculation.getNumber1() / calculation.getNumber2();
                break;
            }
            default:
                throw new IllegalArgumentException("Unsupported operation");
        }
        //DB.insert(calculation);
        return result;
    }


    @Path("/")
    @GET
    public String getHealth() {
        return "Up and running";
    }
}