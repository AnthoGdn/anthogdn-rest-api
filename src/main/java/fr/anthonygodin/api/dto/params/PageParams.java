package fr.anthonygodin.api.dto.params;

import fr.anthonygodin.api.dto.DTO;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Map;

/**
 * Created by AnthoGdn on 19/03/17.
 */
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

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

}
