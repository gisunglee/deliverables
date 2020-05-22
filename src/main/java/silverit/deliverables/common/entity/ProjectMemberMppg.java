package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_PROJECT_MEMBER_MPPG")
public class ProjectMemberMppg {

    @Id @GeneratedValue
    private Long prjMemberMppgNo; //프로젝트 직원 번호
    private String rspofCd; //직원 코드
    private String chrgJobNm; //담당 업무 명
    private String inptDe; //투입일자
    private String endDe; //종료일자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRJ_NO")
    @Setter
    private Project project; //프로젝트 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_NO")
    @Setter
    private Member member; //회원 번호


    //연관 관계 편의 메서드 (프로젝트 팀원 <-> 프로젝트)
    public void changeProject(Project project){
        if(this.project != null){
            this.project.getProjectMemberMppg().remove(this);
        }
        this.project = project;
        project.getProjectMemberMppg().add(this);
    }

    //연관 관계 편의 메서드 (프로젝트 팀원 <-> 직원)
    public void changeMember(Member member){
        if(this.member != null){
            this.member.getProjectMemberMppg().remove(this);
        }
        this.member = member;
        member.getProjectMemberMppg().add(this);
    }


}
