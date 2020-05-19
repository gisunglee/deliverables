package silverit.deliverables.common.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "T_OUTPUT")
public class Output {

    @Id @GeneratedValue
    private Long outputNo; //산출물 번호
    private String outputNm; //산출물 명
    private String outputDc; //산출물 설명
    private String outputTyCd; //산출물 타입 코드
    private Integer sortNo; //정렬 번호

    @OneToMany(mappedBy = "output")
    List<ActivityOutput> activityOutputs = new ArrayList<>(); //활동산출물

    // 연관관계 편의 메서드 (산출물 <-> 활동산출물)
    public void changeActivityOutput(ActivityOutput activityOutput){
        this.activityOutputs = activityOutputs;
        activityOutput.setOutput(this);
    }

}
