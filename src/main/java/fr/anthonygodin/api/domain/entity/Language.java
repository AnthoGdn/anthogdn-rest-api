package fr.anthonygodin.api.domain.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by AnthoGdn on 15/03/17.
 */
@javax.persistence.Entity
@Table
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Language extends  Entity {

    @Column(nullable = false)
    private String name;
    @Column
    private Level level;
    @Column(nullable = false)
    private String imgURL;

    public Language() {}
    public Language(String id, String name, Level level, String imgURL, int orderNb) {
        this.setId(id);
        this.setOrderNb(orderNb);
        this.name = name;
        this.level = level;
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public String getImgURL() {
        return imgURL;
    }
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language)) return false;

        Language language = (Language) o;

        if (getName() != null ? !getName().equals(language.getName()) : language.getName() != null) return false;
        if (getLevel() != language.getLevel()) return false;
        return getImgURL() != null ? getImgURL().equals(language.getImgURL()) : language.getImgURL() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getLevel() != null ? getLevel().hashCode() : 0);
        result = 31 * result + (getImgURL() != null ? getImgURL().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id = '" + getId() + '\'' +
                ", order = '" + getOrderNb() + '\'' +
                ", name = '" + name + '\'' +
                ", level = " + level +
                ", imgURL ='" + imgURL + '\'' +
                '}';
    }

    // ENUM
    public enum Level {
        MIDDLE, GOOD, HIGH;
    }
}
