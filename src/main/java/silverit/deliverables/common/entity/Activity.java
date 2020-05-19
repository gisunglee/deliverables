package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "T_ACTIVITY")
public class Activity {

    @Id @GeneratedValue
    private Long actvtyNo; //활동 번호
    private String fldDstnctCd; //영역 구분 코드
    private String activityNm; //활동 명
    private String rmarkText; //비고 내용
    private String beginDe; //시작 일자
    private String endDe; //종료 일자
    private String cmpltDe; //완료 일자
    private String regstrId; //등록자 id
    private String rdDt; //등록일시
    private String amndrId; //수정자 id
    private String mdDt; // 수정 일시

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STEP_NO")
    @Setter
    private Step step;

    @OneToMany(mappedBy = "activity" )
    private List<Task> tasks = new ArrayList<>(); //태스크

    @OneToMany(mappedBy = "activity" )
    private List<ActivityOutput> activityOutputs = new ArrayList<>(); //활동산출물

//    @OneToMany(mappedBy = "activity" )
//    private List<Activity> activityPrdcs = new ArrayList<>(); //태스크

    //연관관계 편의 메서드 (활동 <-> 단계)
    public void changeStep(Step step) {
        if(this.step != null) {
            this.step.getActivitys().remove(this);
        }
        this.step = step;
        step.getActivitys().add(this);
    }

    //연관관계 편의 메서드 (활동 <-> 단계)
    public void relationTasks(Task task){
        this.tasks.add(task);
        task.setActivity(this);
    }

    //연관관계 편의 메서드 (활동 <-> 활동산출물)
    public void relationActivityPrdcs(ActivityOutput activityPrdc){
        this.activityOutputs.add(activityPrdc);
        activityPrdc.setActivity(this);
    }



}
