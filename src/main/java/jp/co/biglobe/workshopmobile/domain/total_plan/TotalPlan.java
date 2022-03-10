package jp.co.biglobe.workshopmobile.domain.total_plan;

import jp.co.biglobe.workshopmobile.domain.entame_free.EntameFreeOption;
import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class TotalPlan {
    @Getter
    private EntameFreeOption option;
    @Getter
    private Plan plan;

    public void changeOption(EntameFreeOption option) {
        this.option = option;
    }

    public void changePlan(Plan plan) {
        this.plan = plan;
    }
}
