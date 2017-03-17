package fr.anthonygodin.api.dto.Entity;

import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.EntityDTO;

/**
 * Created by AnthoGdn on 15/03/17.
 */
public class LanguageDTO extends EntityDTO {
    private String name;
    private Language.Level level;
    private String imgURL;

    public LanguageDTO() {
    }
    public LanguageDTO(Language language) {
        this();
        this.setId(language.getId());
        this.setName(language.getName());
        this.setLevel(language.getLevel());
        this.setImgURL(language.getImgURL());
    }

    public LanguageDTO(String id, String name, Language.Level level, String imgURL) {
        this.setId(id);
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

    public Language.Level getLevel() {
        return level;
    }
    public void setLevel(Language.Level level) {
        this.level = level;
    }

    public String getImgURL() {
        return imgURL;
    }
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

//    @Override
//    public String toString() {
//        return "LanguageDTO{" +
//                "id='" + getId() + '\'' +
//                ", name='" + name + '\'' +
//                ", level=" + level + '\'' +
//                ", imgURL='" + imgURL + '\'' +
//                '}';
//    }
}

