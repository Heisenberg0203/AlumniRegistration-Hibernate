package com.example.alumni.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class AlumniOrganisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Organisation> organizations;
    @OneToOne
    private  AlumniDetails alumni;
    @Column(nullable = false)
    private  String position;
    @Column(nullable = false)
    private int joining_year;
    private int leaving_year;

    public AlumniOrganisation() {
    }

    public AlumniOrganisation(int id, List<Organisation> organizations, AlumniDetails alumni, String position, int joining_year, int leaving_year) {
        this.id = id;
        this.organizations = organizations;
        this.alumni = alumni;
        this.position = position;
        this.joining_year = joining_year;
        this.leaving_year = leaving_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Organisation> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organisation> organizations) {
        this.organizations = organizations;
    }

    public AlumniDetails getAlumni() {
        return alumni;
    }

    public void setAlumni(AlumniDetails alumni) {
        this.alumni = alumni;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJoining_year() {
        return joining_year;
    }

    public void setJoining_year(int joining_year) {
        this.joining_year = joining_year;
    }

    public int getLeaving_year() {
        return leaving_year;
    }

    public void setLeaving_year(int leaving_year) {
        this.leaving_year = leaving_year;
    }

    @Override
    public String toString() {
        return "AlumniOrganisation{" +
                "id=" + id +
                ", organizations=" + organizations +
                ", alumni=" + alumni +
                ", position='" + position + '\'' +
                ", joining_year=" + joining_year +
                ", leaving_year=" + leaving_year +
                '}';
    }
}
