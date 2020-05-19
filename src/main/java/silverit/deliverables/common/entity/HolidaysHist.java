package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_HOLIDAYS_HIST")
public class HolidaysHist {

    @Id @GeneratedValue
    private Long holidaysHistId; //연차이력 ID
    private String beginDe; //시작 일자
    private String endDe; //종료 일자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_NO")
    @Setter
    private Member member;

    //연관 관계 편의 메서드 (연차이력 <-> 직원)
    public void changeMember(Member member){
        if(this.member != null){
            this.member.getHolidaysHists().remove(this);
        }
        this.member = member;
        member.getHolidaysHists().add(this);
    }
}
