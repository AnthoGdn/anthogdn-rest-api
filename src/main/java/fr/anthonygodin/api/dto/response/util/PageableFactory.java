package fr.anthonygodin.api.dto.response.util;

import fr.anthonygodin.api.dto.params.PageParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by AnthoGdn on 19/03/17.
 */
public class PageableFactory {

    public static Pageable getPage(PageParams pageParams) {
        Sort sort = new Sort(Sort.Direction.ASC, "orderNb");
        return new PageRequest(pageParams.getPage(), pageParams.getPerPage(), sort);
    }
}
