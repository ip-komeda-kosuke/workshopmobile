package jp.co.biglobe.workshopmobile.Service;

import jp.co.biglobe.workshopmobile.domain.entame_free.EntameFreeOption;
import jp.co.biglobe.workshopmobile.domain.fee.MonthlyFee;
import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeeService {
    public MonthlyFee getMothlyFee(Plan plan, EntameFreeOption option) {
        if (plan.is1G() && option.isValue()) {
            throw new RuntimeException();
        }
        return plan.getMonthlyFee().plus(new MonthlyFee(option.isValue() ? 1200 : 0));
    }
}
