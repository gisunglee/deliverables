package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_TASK")
public class Task {

    @Id @GeneratedValue
    private Long taskNo; //태스크 번호
    private String taskNm; //태스크 이름
    private String taskDc; //태스크 설명
    private Integer sortNo; //정렬 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACTIVITY_NO")
    @Setter
    private Activity activity; //활동

    //연관관계 편의 메서드 (태스크 <-> 활동)
    public void changeActivity (Activity activity){

        if(this.activity != null){
            this.activity.getTasks().remove(this);
        }
        this.activity = activity;
        activity.getTasks().add(this);
    }

}
