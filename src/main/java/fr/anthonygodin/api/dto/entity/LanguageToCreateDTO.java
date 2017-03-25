package fr.anthonygodin.api.dto.entity;

import fr.anthonygodin.api.domain.entity.Language;
import fr.anthonygodin.api.dto.DTO;

import javax.validation.constraints.NotNull;

/**
 * Created by AnthoGdn on 15/03/17.
 */
public class LanguageToCreateDTO implements DTO {
    @NotNull
    private String name;
    @NotNull
    private Language.Level level;
    @NotNull
    private String imgURL;

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
