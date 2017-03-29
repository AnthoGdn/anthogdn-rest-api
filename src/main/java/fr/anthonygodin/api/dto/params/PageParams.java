package fr.anthonygodin.api.dto.params;

import fr.anthonygodin.api.dto.DTO;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by AnthoGdn on 19/03/17.
 */
@Getter
@Setter
public class PageParams implements DTO {
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int page;
    @Min(1)
    @Max(50)
    private int perPage;

    public PageParams() {
        this.page = 0;
        this.perPage = 10;
    }
}
