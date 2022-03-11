package jp.co.biglobe.workshopmobile.api.monthlyfee;

import jp.co.biglobe.workshopmobile.Service.FeeService;
import jp.co.biglobe.workshopmobile.domain.entame_free.EntameFreeOption;
import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class MonthlyFeeApi {

    @RequestMapping(value = "/monthly-fee", method = RequestMethod.GET)
    public Map invoke(
            Request request
    ) {
        Plan plan;
        switch (request.getPlan()) {
            case g1:
                plan = Plan._1ギガ;
                break;
            case g3:
                plan = Plan._3ギガ;
                break;
            case g30:
                plan = Plan._30ギガ;
                break;
            default:
                plan = null;
        }
        EntameFreeOption option = new EntameFreeOption(request.isEntame_free());
        Map<String, Object> res = new HashMap<>();
        res.put("monthly_fee", new FeeService().getMonthlyFee(plan, option).getValue());
        return res;
    }


}
