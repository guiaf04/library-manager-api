package library_api.manager.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_magazine")
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String DOI;
    private String title;
    private String magazine_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMagazine_name() {
        return magazine_name;
    }

    public void setMagazine_name(String magazine_name) {
        this.magazine_name = magazine_name;
    }
}
