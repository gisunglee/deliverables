package silverit.deliverables.common.entity;

import lombok.Getter;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "T_MEMBER")
public class Member {

    @Id @GeneratedValue
    private Long memberNo; //사원 번호
    private String memberNm; //사원 명
    private String ofcposCd; //직위 코드
    private String hnphNo; //휴대폰 번호
    private String sexdstnCd; //성별 코드
    private String rgllbrSeCd; //정규직구분코드
    private String advntg; //장점
    private String wkpt; //단점
    private String charct; //성격
    private String docWritngCapaScore; //문서 작성 능력 점수
    private String progrmCapaScore; //프로그램 능력 점수
    private String jobDfnCapaScore; //업무 정의 능력 점수
    private String brtyrMonDd; //생년월일
    private String loginId; //로그인 ID
    private String scrtNo; //비밀 번호
    private String todayFeelScore; //오늘 기분 점수
    private String todayJobLoadDgree; //오늘 업무 부하
    private String iconCd; //아이콘 코드
    private String iconPullFilePath; //아이콘 전체 파일 경로

    @OneToMany(fetch = FetchType.LAZY)
    private List<HolidaysHist> holidaysHists = new ArrayList<>();

    //연관 관계 편의 메서드 (직원 <-> 연차이력)
    public void changeHolidaysHists(HolidaysHist holidaysHist){
        this.holidaysHists.add(holidaysHist);
        holidaysHist.setMember(this);
    }

}
