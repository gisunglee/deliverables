package silverit.deliverables.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "T_MENU")
public class Menu {

    @Id @GeneratedValue
    private String menuNo; //메뉴 번호
    private String menuNm; //메뉴 명
    private String useYn; //사용 여부
    private String menuDc; //메뉴 설명
    private String rmark; //비고

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUIREMENT_NO")
    @Setter
    private RequirementSpec requirementSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRJ_NO")
    @Setter
    private Project project; //프로젝트 번호

    //연관 관계 편의 메서드 (메뉴 <-> 요구사항명세)
    public void changeRequirementSpec(RequirementSpec requirementSpec){
        if(this.requirementSpec != null){
            this.requirementSpec.getMenus().remove(this);
        }
        this.requirementSpec = requirementSpec;
        requirementSpec.getMenus().add(this);
    }

    //연관 관계 편의 메서드 (메뉴 <-> 프로젝트)
    public void changeProject(Project project){
        if(this.project != null){
            this.project.getMenus().remove(this);
        }
        this.project = project;
        project.getMenus().add(this);
    }

    /* ************************************************
        자기 참조 관계 설정
     ************************************************ */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPPER_MENU_NO")
    @Setter
    private Menu superMenu;

    //연관 관계 편의 메서드 (하위메뉴 <-> 상위메뉴)
    public void changeSuperMenu(Menu superMenu){
        if(this.superMenu != null){
            this.superMenu.getSubMenu().remove(this);
        }
        this.superMenu = superMenu;
        superMenu.getSubMenu().add(this);
    }

    @OneToMany(mappedBy = "superMenu" )
    private List<Menu> subMenu = new ArrayList<>(); //메뉴

    //연관 관계 편의 메서드 (상위메뉴 <-> 하위메뉴)
    public void changeSubMenu(Menu subMenu){
        this.superMenu = subMenu;
        subMenu.setSuperMenu(this);
    }



}
