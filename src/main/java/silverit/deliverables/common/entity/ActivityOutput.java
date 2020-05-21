package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_ACTIVITY_OUTPUT")
public class ActivityOutput {

    @Id @GeneratedValue
    private Long activityOutputNo; //활동 산출물 번호
    private String mandaSeCd; //필수 구분 코드
    private String modulByWritYn; //모듈 작성 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACTIVITY_NO")
    @Setter
    private Activity activity; //활동


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OUTPUT_NO")
    @Setter
    private Output output; //산출물

    //연관관계 편의 메서드 (활동산출물 <-> 활동)
    public void changeActivity (Activity activity){
        if(this.activity != null){
            this.activity.getActivityOutputs().remove(this);
        }
        this.activity = activity;
        activity.getActivityOutputs().add(this);
    }

    //연관관계 편의 메서드 (활동산출물 <-> 산출물)
    public void changeOutput (Output output){
        if(this.output != null){
            this.output.getActivityOutputs().remove(this);
        }
        this.output = output;
        output.getActivityOutputs().add(this);
    }


}
