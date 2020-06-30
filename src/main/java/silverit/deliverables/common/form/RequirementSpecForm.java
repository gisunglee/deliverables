package silverit.deliverables.common.form;

import lombok.Getter;
import lombok.Setter;
import silverit.deliverables.common.entity.Module;
import silverit.deliverables.common.entity.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
/**
 * 요구사항 명세
 */
public class RequirementSpecForm {

    private Long requirementNo; //요구사항 번호
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

}
