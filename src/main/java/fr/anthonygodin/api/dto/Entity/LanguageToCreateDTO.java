package fr.anthonygodin.api.dto.Entity;

import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.DTO;

/**
 * Created by AnthoGdn on 15/03/17.
 */
public class LanguageToCreateDTO implements DTO {
    private String name;
    private Language.Level level;
    private String imgURL;

    public LanguageToCreateDTO() {
    }
    public LanguageToCreateDTO(Language language) {
        this();
        this.setName(language.getName());
        this.setLevel(language.getLevel());
        this.setImgURL(language.getImgURL());
    }
    public LanguageToCreateDTO(String name, Language.Level level, String imgURL) {
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
}
