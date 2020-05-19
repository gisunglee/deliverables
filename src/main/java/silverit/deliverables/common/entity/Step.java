package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "T_STEP")
/**
 * 단계
 */
public class Step {

    @Id @GeneratedValue
    private Long stepNo; //단계 번호
    private String stepNm; //단계 명
    private String mthdlgyCd; //방법론 코드

    private String beginDe; //시작 일자
    private String endDe; //종요 일자
    private String cmpltDe; //완료 일자


    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "PRJ_NO")
    @Setter
    private Project project; // 프로젝트

    //활동
    @OneToMany(mappedBy = "step")
    private List<Activity> activitys = new ArrayList<>(); //활동 = T_ACTIVITY


    //연관관계 편의 메서드 (단계 <-> 프로젝트)
    public void changeProject(Project project) {

        if(this.project != null) {
            this.project.getSteps().remove(this);
        }

        this.project = project;
        project.getSteps().add(this);
    }

    //연관관계 편의 메서드 (단계 <-> 활동)
    public void changeActivity(Activity activity) {
        this.getActivitys().add(activity);
        activity.setStep(this);
    }


}
