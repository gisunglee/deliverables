package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "T_REQUIREMENT_SPEC")
/**
 * 요구사항 명세
 */
public class RequirementSpec {

    @Id @GeneratedValue
    private String requirementNo; //요구사항 번호
    private String requirementClasCd; //요구사항 분류 코드
    private String requirementDefi; //요구사항 정의
    private String requirementText; //요구사항 내용
    private String requirementId; //요구사항 id
    private String priorRankNo; //우선 순위 번호
    private String dfflyCd; //난이도 코드
    private String rstcMaterText; //제약 사항 내용
    private String inspStdrText; //검사 기준 내용
    private String fnctSeCd; //기능 구분 코드
    private String requirementNm; //요구사항 명칭
    private String aceptncYn; //수용 여부
    private String chrgEmpId; //담당 사원 id
    private String entyPathText; //진입 경로 내용
    private String specProgStatCd; //명세 진행 상태 코드
    private String apvlReqDtt; //승인 요청 일시
    private String apvlpsId; //승인자 ID
    private String apvlDtt; //승인 일시
    private String noteCn;//노트 내용

    private String modulNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRJ_NO")
    @Setter
    private Project project; // 프로젝트

    //연관관계 편의 메서드
    public void relationProject(Project project) {

        if(this.project != null) {
            this.project.getRequirementSpecs().remove(this);
        }

        this.project = project;
        project.getRequirementSpecs().add(this);
    }


}
